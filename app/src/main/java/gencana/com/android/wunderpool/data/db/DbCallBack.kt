package gencana.com.android.wunderpool.data.db

import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import gencana.com.android.wunderpool.data.db.entity.CarEntity
import gencana.com.android.wunderpool.domain.interactor.AddCarListInteractor
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