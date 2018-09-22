package gencana.com.android.wunderpool.domain.interactor

import androidx.paging.DataSource
import gencana.com.android.wunderpool.data.db.entity.CarEntity
import gencana.com.android.wunderpool.domain.repository.CarRepository
import javax.inject.Inject

/**
 * Created by Gen Cana on 22/09/2018
 */
class GetCarListInteractor @Inject constructor(
        private val repository: CarRepository) {

    fun getCarList(): DataSource.Factory<Int, CarEntity>{
        return repository.getCarList()
    }
}