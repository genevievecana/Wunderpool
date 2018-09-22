package gencana.com.android.wunderpool.domain.interactor

import gencana.com.android.wunderpool.data.db.entity.CarEntity
import gencana.com.android.wunderpool.domain.repository.CarRepository
import gencana.com.android.wunderpool.presentation.constant.key.SCHEDULER_IO
import gencana.com.android.wunderpool.presentation.constant.key.SCHEDULER_MAIN_THREAD
import io.reactivex.Observable
import io.reactivex.Scheduler
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by Gen Cana on 22/09/2018
 */
class AddCarListInteractor @Inject constructor(
        private val repository: CarRepository,
        @Named(SCHEDULER_IO) private val io: Scheduler,
        @Named(SCHEDULER_MAIN_THREAD) private val mainThread: Scheduler
): UseCase<Unit, List<CarEntity>>(io, mainThread) {

    override fun getObservable(params: List<CarEntity>?): Observable<Unit> {
        return  Observable.fromCallable {   repository.insert(params!!) }
    }


}