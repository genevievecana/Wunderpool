package gencana.com.android.wunderpool.presentation.ui.view.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import gencana.com.android.wunderpool.domain.interactor.AddCarListInteractor
import gencana.com.android.wunderpool.domain.interactor.GetCarListInteractor
import gencana.com.android.wunderpool.domain.model.Car
import gencana.com.android.wunderpool.presentation.base.BaseViewModel
import javax.inject.Inject

/**
 * Created by Gen Cana on 22/09/2018
 */
class MainViewModel @Inject constructor(
        private val addCarListInteractor: AddCarListInteractor,
        private val carListInteractor: GetCarListInteractor)
    : BaseViewModel<LiveData<PagedList<Car>>>() {

    var addCarListLiveData = MutableLiveData<Unit>()

    fun addCarList(carList: List<Car>){
        addDisposable(
                addCarListInteractor.execute(carList)
                        .subscribe(
                                {
                                    addCarListLiveData.setValue(Unit)
                                },
                                {
                                    errorLiveData.postValue(it.message)
                                }
                        )
        )

    }

    fun getCarList(): LiveData<PagedList<Car>>{
        val myPagingConfig = PagedList.Config.Builder()
                .setPageSize(30)
                .setPrefetchDistance(50)
                .setEnablePlaceholders(false)
                .build()

        val factory: DataSource.Factory<Int, Car> = carListInteractor.getCarList()
        val pagedListBuilder = LivePagedListBuilder(factory, myPagingConfig).build()
        return pagedListBuilder
    }
}