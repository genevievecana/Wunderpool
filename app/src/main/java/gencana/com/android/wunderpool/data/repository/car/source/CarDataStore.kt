package gencana.com.android.wunderpool.data.repository.car.source

import android.arch.lifecycle.LiveData
import android.arch.paging.DataSource
import gencana.com.android.wunderpool.data.entity.CarDataEntity

/**
 * Created by Gen Cana on 22/09/2018
 */
interface CarDataStore {

    fun insert(items: List<CarDataEntity>)

    fun getCarList() : DataSource.Factory<Int, CarDataEntity>

    fun getAllCarList(): LiveData<List<CarDataEntity>>
}