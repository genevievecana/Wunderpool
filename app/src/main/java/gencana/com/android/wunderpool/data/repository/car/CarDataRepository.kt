package gencana.com.android.wunderpool.data.repository.car

import androidx.paging.DataSource
import gencana.com.android.wunderpool.data.db.entity.CarEntity
import gencana.com.android.wunderpool.data.repository.car.source.CarDataStore
import gencana.com.android.wunderpool.data.repository.car.source.CarDataStoreFactory
import gencana.com.android.wunderpool.domain.repository.CarRepository
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Gen Cana on 22/09/2018
 */

@Singleton
class CarDataRepository @Inject constructor(
        carDataStoreFactory: CarDataStoreFactory)
    : CarRepository{

    private var carDataStore: CarDataStore = carDataStoreFactory.create()

    override fun insert(items: List<CarEntity>) {
        carDataStore.insert(items)
    }

    override fun getCarList(): DataSource.Factory<Int, CarEntity> {
        return carDataStore.getCarList()
    }


}