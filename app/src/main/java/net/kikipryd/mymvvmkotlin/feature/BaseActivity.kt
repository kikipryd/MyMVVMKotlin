package net.kikipryd.mymvvmkotlin.feature

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.annotation.NonNull
import android.support.v7.app.AppCompatActivity
import net.kikipryd.mymvvmkotlin.App
import net.kikipryd.mymvvmkotlin.dagger.component.ActivityComponent
import org.jetbrains.anko.alert

abstract class BaseActivity : AppCompatActivity() {

    lateinit var context: Context
    var bundle: Bundle? = null

    fun launchActivity(@NonNull context: Context, @NonNull classActivity: Class<*>, @NonNull bundle: Bundle) {
        val intent = Intent(context, classActivity)
        intent.putExtras(bundle)
        context.startActivity(intent)
    }

    fun launchActivity(@NonNull context: Context, @NonNull classActivity: Class<*>) {
        context.startActivity(Intent(context, classActivity))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initAnkoView()
        bundle = intent.extras
        context = this
        injectActivityComponent(App.activityComponent)
        initViewModel(ViewModelProviders.of(this))
        initData()
        attachListener()
        attachData()
    }

    abstract fun initAnkoView()

    abstract fun injectActivityComponent(activityComponent: ActivityComponent)

    abstract fun initViewModel(viewModelProvider: ViewModelProvider)

    abstract fun initData()

    abstract fun attachData()

    abstract fun attachListener()

    fun showMessage(message: String) {
        alert {
            this.message = message
        }.show()
    }
}
