package gencana.com.android.wunderpool.presentation.ui.view.main

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import gencana.com.android.wunderpool.domain.interactor.GetCarListInteractor
import gencana.com.android.wunderpool.domain.model.Car
import gencana.com.android.wunderpool.presentation.base.BaseViewModel
import gencana.com.android.wunderpool.presentation.utils.generatePagingConfig
import javax.inject.Inject

/**
 * Created by Gen Cana on 22/09/2018
 */
class MainViewModel @Inject constructor(
        private val carListInteractor: GetCarListInteractor)
    : BaseViewModel<PagedList<Car>>() {

    override fun loadLiveData(): LiveData<PagedList<Car>>? {
        return LivePagedListBuilder(carListInteractor.getCarList(), generatePagingConfig())
                .build()
    }

}