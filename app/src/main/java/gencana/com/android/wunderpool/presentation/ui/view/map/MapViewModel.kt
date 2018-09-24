package gencana.com.android.wunderpool.presentation.ui.view.map

import android.arch.lifecycle.LiveData
import gencana.com.android.wunderpool.domain.interactor.GetAllCarListInteractor
import gencana.com.android.wunderpool.domain.model.Car
import gencana.com.android.wunderpool.presentation.base.BaseViewModel
import javax.inject.Inject

/**
 * Created by Gen Cana on 23/09/2018
 */
class MapViewModel  @Inject constructor(
        private val getAllCarListInteractor: GetAllCarListInteractor)
    : BaseViewModel<List<Car>>() {

    init {
        loadingMediatorLiveData.addSource(this.loadLiveData()!!){ loadingMediatorLiveData.postValue(false)}
    }

    override fun loadLiveData(): LiveData<List<Car>>? {
        return getAllCarListInteractor.getCarList()
    }
}