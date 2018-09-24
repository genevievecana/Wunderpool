package gencana.com.android.wunderpool.presentation.ui.view.map

import android.arch.lifecycle.LiveData
import gencana.com.android.wunderpool.domain.interactor.GetAllCarListInteractor
import gencana.com.android.wunderpool.domain.model.Car
import gencana.com.android.wunderpool.presentation.base.BaseViewModel
import gencana.com.android.wunderpool.presentation.constant.key.SCHEDULER_MAIN_THREAD
import io.reactivex.Scheduler
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by Gen Cana on 23/09/2018
 */
class MapViewModel  @Inject constructor(
        private val getAllCarListInteractor: GetAllCarListInteractor,
        @Named(SCHEDULER_MAIN_THREAD) private val mainThread: Scheduler
) : BaseViewModel<List<Car>>() {

    init {
        loadingMediatorLiveData.addSource(this.loadLiveData()!!){ loadingMediatorLiveData.postValue(false)}
    }

    override fun loadLiveData(): LiveData<List<Car>>? {
        return getAllCarListInteractor.getCarList()
    }
}