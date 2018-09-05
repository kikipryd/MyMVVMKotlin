package net.kikipryd.mymvvmkotlin.feature.main

import android.arch.lifecycle.ViewModelProvider
import android.view.View
import android.view.View.OnClickListener
import net.kikipryd.mymvvmkotlin.dagger.component.ActivityComponent
import net.kikipryd.mymvvmkotlin.feature.BaseActivity
import org.jetbrains.anko.setContentView


class MainActivity : BaseActivity(), MainViewModel.Callback, OnClickListener {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var contentView: MainView

    override fun initAnkoView() {
        contentView = MainView()
        contentView.setContentView(this)
    }

    override fun injectActivityComponent(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun initViewModel(viewModelProvider: ViewModelProvider) {
        mainViewModel = viewModelProvider.get(MainViewModel::class.java)
        mainViewModel.attchView(this)
    }

    override fun onDestroy() {
        mainViewModel.detachView()
        super.onDestroy()
    }

    override fun initData() {
        mainViewModel.getQuestions()
    }

    override fun attachData() {
    }

    override fun attachListener() {
    }

    override fun onClick(view: View) {
    }

    override fun onLoading() {
    }

    override fun onResponse(response: Any?) {
    }

    override fun onFailure(message: String) {
    }
}
