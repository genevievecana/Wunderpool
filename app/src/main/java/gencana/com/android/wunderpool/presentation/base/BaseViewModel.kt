package gencana.com.android.wunderpool.presentation.base

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by Gen Cana on 22/09/2018
 */
abstract class BaseViewModel<T>: ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    protected val loadingMediatorLiveData = MediatorLiveData<Boolean>()

    val responseLiveData: LiveData<T> by lazy {
        loadingMediatorLiveData.postValue(true)
        loadLiveData() ?: MutableLiveData()
    }

    protected val errorLiveData = MutableLiveData<String>()

    fun getLoadingMediatorLiveData(): LiveData<Boolean>{
        return loadingMediatorLiveData
    }

    fun getErrorLiveData(): LiveData<String>{
        return errorLiveData
    }

    fun addDisposable(disposable: Disposable){
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    open protected fun loadLiveData(): LiveData<T>?{
        return null
    }
}