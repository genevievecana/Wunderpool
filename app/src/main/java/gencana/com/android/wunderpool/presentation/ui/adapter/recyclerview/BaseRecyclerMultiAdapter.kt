package gencana.com.android.wunderpool.presentation.ui.adapter.recyclerview

import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import gencana.com.android.wunderpool.presentation.interfaces.ViewHolderType
import gencana.com.android.wunderpool.presentation.factory.ViewHolderFactory
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

/**
 * Created by Gen Cana on 22/09/2018
 */
class BaseRecyclerMultiAdapter<E: ViewHolderType>(
        var itemClickPublisher: PublishSubject<E>?
) : PagedListAdapter<E, BaseRecyclerMultiAdapter.BaseViewHolder<E>>(DiffCallBack<E>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<E> {
        return ViewHolderFactory.createViewType(parent, viewType) as BaseViewHolder<E>
    }

    override fun onBindViewHolder(holder: BaseViewHolder<E>, position: Int) {
        getItem(position)?.let { holder.onBind(it, itemClickPublisher) }

    }

    internal inline fun <reified R>getClickObservable(): Observable<R>?{
        return itemClickPublisher
                ?.filter{it is R }
                ?.map { it as R }
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position)?.viewTypeEnum?.type!!
    }


    abstract class BaseViewHolder<E : ViewHolderType>(itemView: View) : RecyclerView.ViewHolder(itemView) {

        abstract fun onBind(data: E, itemClickPublisher: PublishSubject<E>?)
    }

}