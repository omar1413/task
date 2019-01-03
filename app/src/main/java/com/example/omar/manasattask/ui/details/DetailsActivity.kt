package com.example.omar.manasattask.ui.details

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.omar.manasattask.R
import com.example.omar.manasattask.data.retrofit.pojo.persondetails.PersonDetailsResponse
import com.example.omar.manasattask.ui.base.BaseActivity
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_details.*
import javax.inject.Inject

class DetailsActivity : BaseActivity(), DetailsMvpView {

    @Inject
    lateinit var presenter: DetailsMvpPresenter<DetailsMvpView>

    @Inject
    lateinit var groupieAdapter: GroupAdapter<ViewHolder>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        activityComponent?.inject(this)
        setupRecycler()
        presenter.onAttach(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDetach()
    }

    fun setupRecycler() {
        val layoutManager = GridLayoutManager(this, 5)
        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                if (position == 0)
                    return 5
                return 1
            }

        }
        image_details_recycler.layoutManager = layoutManager
        image_details_recycler.adapter = groupieAdapter

    }


    override fun fillData(personDetails: PersonDetailsResponse) {

        groupieAdapter.add(0, DetailsHeader(personDetails))
        image_details_recycler.scrollToPosition(0)
    }

    override fun addImageItem(uri: String) {
            groupieAdapter.add(DetailsItem(uri))

    }
}
