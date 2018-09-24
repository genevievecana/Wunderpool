package gencana.com.android.wunderpool.data.db


import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.RoomDatabase
import javax.inject.Inject

/**
 * Created by Gen Cana on 22/09/2018
 */
class DbCallBack @Inject constructor ()
    : RoomDatabase.Callback() {

    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)
    }
}