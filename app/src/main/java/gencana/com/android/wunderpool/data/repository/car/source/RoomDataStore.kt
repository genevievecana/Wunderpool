package gencana.com.android.wunderpool.data.repository.car.source

import androidx.paging.DataSource
import gencana.com.android.wunderpool.data.db.dao.PlaceMarkDao
import gencana.com.android.wunderpool.data.db.entity.CarEntity

/**
 * Created by Gen Cana on 22/09/2018
 */
class RoomDataStore(private val placeMarkDao: PlaceMarkDao): CarDataStore {

    override fun insert(items: List<CarEntity>) {
        placeMarkDao.insert(items)
    }

    override fun getCarList(): DataSource.Factory<Int, CarEntity> {
        return placeMarkDao.getPagedList()
    }

}