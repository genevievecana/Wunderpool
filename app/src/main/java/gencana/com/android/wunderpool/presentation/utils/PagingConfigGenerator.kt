package gencana.com.android.wunderpool.presentation.utils

import androidx.paging.PagedList

/**
 * Created by Gen Cana on 23/09/2018
 */

fun generatePagingConfig()
     = PagedList.Config.Builder()
            .setPageSize(30)
            .setPrefetchDistance(50)
            .setEnablePlaceholders(false)
            .build()
