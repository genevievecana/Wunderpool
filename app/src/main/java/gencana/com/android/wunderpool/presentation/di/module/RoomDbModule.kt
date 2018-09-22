package gencana.com.android.wunderpool.presentation.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import androidx.room.Room
import gencana.com.android.wunderpool.data.db.AppDatabase
import gencana.com.android.wunderpool.data.db.DbCallBack
import gencana.com.android.wunderpool.data.db.dao.PlaceMarkDao
import gencana.com.android.wunderpool.domain.interactor.AddCarListInteractor
import gencana.com.android.wunderpool.presentation.constant.key.DATABASE_NAME


/**
 * Created by Gen Cana on 22/09/2018
 */

@Module
class RoomDbModule{

    @Singleton
    @Provides
    fun provideDbCallBack(): DbCallBack{
        return DbCallBack()
    }

    @Singleton
    @Provides
    fun provideAppDatabase(context: Context, dbCallBack: DbCallBack): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .addCallback(dbCallBack)
                .build()
    }

    @Singleton
    @Provides
    fun providePlaceMarkDao(appDatabase: AppDatabase): PlaceMarkDao {
        return appDatabase.placeMarkDao()
    }
}