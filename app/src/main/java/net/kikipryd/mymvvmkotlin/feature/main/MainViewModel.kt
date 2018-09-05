package net.kikipryd.mymvvmkotlin.feature.main

import net.kikipryd.mymvvmkotlin.api.ApiCallback
import net.kikipryd.mymvvmkotlin.api.ApiManager
import net.kikipryd.mymvvmkotlin.dagger.component.ViewModelComponent
import net.kikipryd.mymvvmkotlin.model.MainModel
import net.kikipryd.mymvvmkotlin.feature.BaseViewModel
import javax.inject.Inject

class MainViewModel : BaseViewModel<MainViewModel.Callback>() {

    @Inject
    lateinit var apiManager: ApiManager

    var mainModel: MainModel? = null

    override fun injectPresenterComponent(viewModelComponent: ViewModelComponent) {
        viewModelComponent.inject(this)
    }

    fun getQuestions() {
        callback?.onLoading()
        apiManager.questions.enqueue(object : ApiCallback<Any>() {
            override fun onResponse(response: Any?) {
                callback?.onResponse(response)
            }

            override fun onFailure(message: String) {
                callback?.onFailure(message)
            }
        })
    }

    interface Callback : BaseCallback {
        fun onLoading()

        fun onResponse(response: Any?)

        fun onFailure(message: String)
    }
}
