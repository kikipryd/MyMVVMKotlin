package net.kikipryd.mymvvmkotlin.feature

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.annotation.NonNull
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import net.kikipryd.mymvvmkotlin.App
import net.kikipryd.mymvvmkotlin.dagger.component.ActivityComponent

abstract class BaseActivity : AppCompatActivity() {

    lateinit var context: Context
    var bundle: Bundle? = null

    abstract val contentView: Int

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
        setContentView(contentView)
        bundle = intent.extras
        context = this
        injectActivityComponent(App.activityComponent)
        initViewModel(ViewModelProviders.of(this))
        initData()
        initComponent()
        attachData()
    }

    abstract fun injectActivityComponent(activityComponent: ActivityComponent)

    abstract fun initViewModel(viewModelProvider: ViewModelProvider)

    abstract fun initData()

    abstract fun initComponent()

    abstract fun attachData()

    protected fun showMessage(message: String) {
        val dialog = AlertDialog.Builder(context).create()
        dialog.setMessage(message)
        dialog.show()
    }
}
