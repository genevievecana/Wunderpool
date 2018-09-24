package gencana.com.android.wunderpool.presentation.utils

import android.arch.paging.PagedList


/**
 * Created by Gen Cana on 23/09/2018
 */

private const val PAGE_SIZE = 100
private const val PRE_FETCH_DISTANCE = 30

fun generatePagingConfig()
     = PagedList.Config.Builder()
            .setPageSize(PAGE_SIZE)
            .setPrefetchDistance(PRE_FETCH_DISTANCE)
            .setEnablePlaceholders(false)
            .build()
