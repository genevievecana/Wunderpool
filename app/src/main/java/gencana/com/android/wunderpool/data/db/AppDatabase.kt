package gencana.com.android.wunderpool.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import gencana.com.android.wunderpool.data.db.dao.PlaceMarkDao
import gencana.com.android.wunderpool.data.db.entity.CarEntity

/**
 * Created by Gen Cana on 22/09/2018
 */

@Database(entities = [CarEntity::class], version = 1, exportSchema = false)
@TypeConverters(ColumnConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun placeMarkDao(): PlaceMarkDao
}