package gencana.com.android.wunderpool.presentation.base

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by Gen Cana on 22/09/2018
 */
abstract class BaseViewModel<T>: ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    val loadingLiveData = MutableLiveData<Boolean>()

    val responseLiveData = MutableLiveData<T>()

    val errorLiveData = MutableLiveData<String>()

    fun addDisposable(disposable: Disposable){
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}