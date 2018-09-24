package gencana.com.android.wunderpool.data.repository.car.source

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations
import android.arch.paging.DataSource
import gencana.com.android.wunderpool.data.db.dao.PlaceMarkDao
import gencana.com.android.wunderpool.data.entity.CarDataEntity
import gencana.com.android.wunderpool.data.entity.mapper.toDataEntity
import gencana.com.android.wunderpool.data.entity.mapper.toDbEntity

/**
 * Created by Gen Cana on 22/09/2018
 */
class RoomDataStore(private val placeMarkDao: PlaceMarkDao): CarDataStore {

    override fun getAllCarList(): LiveData<List<CarDataEntity>> {
        return Transformations.map(placeMarkDao.getAllList()) {
            list -> list.map { it.toDataEntity()
        } }
    }

    override fun insert(items: List<CarDataEntity>) {
        placeMarkDao.insert(items.map {
            it.toDbEntity()
        })
    }

    override fun getCarList(): DataSource.Factory<Int, CarDataEntity> {
        return placeMarkDao.getPagedList().map { it.toDataEntity() }
    }

}