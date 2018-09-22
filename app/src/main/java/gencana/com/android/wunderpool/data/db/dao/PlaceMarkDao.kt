package gencana.com.android.wunderpool.data.db.dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import gencana.com.android.wunderpool.presentation.constant.key.TABLE_PLACE_MARK
import gencana.com.android.wunderpool.data.db.entity.CarEntity

/**
 * Created by Gen Cana on 22/09/2018
 */

@Dao
interface PlaceMarkDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(item: List<CarEntity>)

    @Query("SELECT * FROM $TABLE_PLACE_MARK")
    fun getPagedList(): DataSource.Factory<Int, CarEntity>

}