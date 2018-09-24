package gencana.com.android.wunderpool.presentation.ui.view.main

import android.arch.lifecycle.Observer
import android.arch.paging.PagedList
import android.content.Intent
import android.os.Bundle
import gencana.com.android.wunderpool.R
import gencana.com.android.wunderpool.domain.model.Car
import gencana.com.android.wunderpool.presentation.base.BaseActivity
import gencana.com.android.wunderpool.presentation.extensions.toast
import gencana.com.android.wunderpool.presentation.extensions.visibleInvisible
import gencana.com.android.wunderpool.presentation.ui.adapter.recyclerview.BaseRecyclerMultiAdapter
import gencana.com.android.wunderpool.presentation.utils.SharedPref
import gencana.com.android.wunderpool.presentation.utils.getCarListFromJson
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : BaseActivity<MainViewModel, PagedList<Car>>() {

    @Inject
    lateinit var sharedPref: SharedPref

    private lateinit var recyclerViewAdapter: BaseRecyclerMultiAdapter<Car>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        recyclerViewAdapter = BaseRecyclerMultiAdapter(null)
        recycler_view.adapter = recyclerViewAdapter
        setup()

    }

    private fun setup() {
        if (sharedPref.carDataAdded != true){
            viewModel.addCarList(getCarListFromJson(this))
            viewModel.addCarListLiveData.observe(this, Observer {
                sharedPref.carDataAdded = true
            })
        }


    }

    override val layout: Int
        get() = R.layout.activity_main


    override fun showLoading(show: Boolean) {
        progress_bar.visibleInvisible(show)
    }

    override fun onResponseSuccess(data: PagedList<Car>) {
        recyclerViewAdapter.submitList(data)
    }

    override fun onError(errorMsg: String?) {
        toast(errorMsg ?: getString(R.string.error_default))
    }
}
