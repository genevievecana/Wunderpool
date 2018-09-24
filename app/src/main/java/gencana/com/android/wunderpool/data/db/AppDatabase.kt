package gencana.com.android.wunderpool.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
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