package gencana.com.android.wunderpool.data.db.dao

import android.arch.lifecycle.LiveData
import android.arch.paging.DataSource
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import gencana.com.android.wunderpool.presentation.constant.key.TABLE_PLACE_MARK
import gencana.com.android.wunderpool.data.db.entity.CarEntity
import gencana.com.android.wunderpool.presentation.constant.key.COLUMN_ADDRESS
import gencana.com.android.wunderpool.presentation.constant.key.COLUMN_COORDINATES
import gencana.com.android.wunderpool.presentation.constant.key.COLUMN_VIN

/**
 * Created by Gen Cana on 22/09/2018
 */

@Dao
interface PlaceMarkDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(item: List<CarEntity>)

    @Query("SELECT * FROM $TABLE_PLACE_MARK")
    fun getPagedList(): DataSource.Factory<Int, CarEntity>

    @Query("SELECT $COLUMN_COORDINATES, $COLUMN_ADDRESS, $COLUMN_VIN FROM $TABLE_PLACE_MARK")
    fun getAllList(): LiveData<List<CarEntity>>

}