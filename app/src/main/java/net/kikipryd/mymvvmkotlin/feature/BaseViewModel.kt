package net.kikipryd.mymvvmkotlin.feature

import android.arch.lifecycle.ViewModel

import net.kikipryd.mymvvmkotlin.App
import net.kikipryd.mymvvmkotlin.dagger.component.ViewModelComponent

abstract class BaseViewModel<CALLBACK : BaseViewModel.BaseCallback> : ViewModel() {

    var callback: CALLBACK? = null

    init {
        injectPresenterComponent(App.viewModelComponent)
    }

    abstract fun injectPresenterComponent(viewModelComponent: ViewModelComponent)

    fun attchView(callback: CALLBACK) {
        this.callback = callback
    }

    fun detachView() {
        callback = null
    }

    interface BaseCallback
}
