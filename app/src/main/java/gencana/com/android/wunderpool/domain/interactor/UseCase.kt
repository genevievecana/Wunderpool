package gencana.com.android.wunderpool.domain.interactor

import androidx.lifecycle.MutableLiveData
import io.reactivex.Observable
import io.reactivex.Scheduler

/**
 * Created by Gen Cana on 22/09/2018
 */
abstract class UseCase<T, P>(private val io: Scheduler,
                          private val mainThread: Scheduler) {

    val isRunningLiveData = MutableLiveData<Boolean>()

    abstract fun getObservable(params: P? = null): Observable<T>

    fun execute(params: P) : Observable<T>{
        return getObservable(params)
                .doOnSubscribe { isRunningLiveData.postValue(true) }
                .doAfterTerminate { isRunningLiveData.postValue(false) }
                .subscribeOn(io)
                .observeOn(mainThread)

    }

}
