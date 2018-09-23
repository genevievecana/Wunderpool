package gencana.com.android.wunderpool.presentation.ui.view.main

import android.os.Bundle
import gencana.com.android.wunderpool.R
import androidx.paging.PagedList
import gencana.com.android.wunderpool.domain.model.Car
import gencana.com.android.wunderpool.presentation.base.BaseActivity
import gencana.com.android.wunderpool.presentation.ui.adapter.recyclerview.BaseRecyclerMultiAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity<MainViewModel, PagedList<Car>>() {

    private lateinit var recyclerViewAdapter: BaseRecyclerMultiAdapter<Car>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        recyclerViewAdapter = BaseRecyclerMultiAdapter(null)
        recycler_view.adapter = recyclerViewAdapter
        mainViewModel.loadingLiveData
    }

    override val layout: Int
        get() = R.layout.activity_main


    override fun showLoading(show: Boolean) {

    }

    override fun onResponseSuccess(data: PagedList<Car>) {
        recyclerViewAdapter.submitList(data)
    }

    override fun onError(errorMsg: String) {

    }
}
