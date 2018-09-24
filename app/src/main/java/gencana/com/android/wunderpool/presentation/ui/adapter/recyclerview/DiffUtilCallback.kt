package gencana.com.android.wunderpool.presentation.ui.adapter.recyclerview

import android.support.v7.util.DiffUtil
import gencana.com.android.wunderpool.presentation.interfaces.PagingData


/**
 * Created by Gen Cana on 22/09/2018
 */
class DiffCallBack<T: PagingData>: DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.getDataId() == newItem.getDataId()
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.equals(newItem)
    }

}