package gencana.com.android.wunderpool.presentation.extensions

import android.view.View

/**
 * Created by Gen Cana on 23/09/2018
 */

fun View.visibleInvisible(visible: Boolean = true){
    visibility = if (visible) View.VISIBLE else View.INVISIBLE
}