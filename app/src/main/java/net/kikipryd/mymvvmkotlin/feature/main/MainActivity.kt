package net.kikipryd.mymvvmkotlin.feature.main

import android.arch.lifecycle.ViewModelProvider
import android.view.View
import android.view.View.OnClickListener
import net.kikipryd.mymvvmkotlin.R
import net.kikipryd.mymvvmkotlin.dagger.component.ActivityComponent
import net.kikipryd.mymvvmkotlin.feature.BaseActivity
import net.kikipryd.mymvvmkotlin.viewmodel.main.MainViewModel

class MainActivity : BaseActivity(), MainViewModel.Callback, OnClickListener {

    private lateinit var mainViewModel: MainViewModel

    override val contentView: Int
        get() = R.layout.activity_main

    override fun injectActivityComponent(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun onDestroy() {
        mainViewModel.detachView()
        super.onDestroy()
    }

    override fun initViewModel(viewModelProvider: ViewModelProvider) {
        mainViewModel = viewModelProvider.get(MainViewModel::class.java)
        mainViewModel.attchView(this)
    }

    override fun initData() {
        mainViewModel.getQuestions()
    }

    override fun initComponent() {
    }

    override fun attachData() {
    }

    override fun onClick(view: View) {
        when (view.id) {
            else -> {
            }
        }
    }

    override fun onLoading() {
    }

    override fun onResponse(response: Any?) {
    }

    override fun onFailure(message: String) {
    }
}
