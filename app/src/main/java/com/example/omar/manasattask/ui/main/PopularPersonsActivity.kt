package com.example.omar.manasattask.ui.main

import android.app.Person
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.omar.manasattask.R
import com.example.omar.manasattask.models.PopularPerson
import com.example.omar.manasattask.ui.base.BaseActivity
import com.example.omar.manasattask.ui.details.DetailsActivity
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_popular_persons.*
import javax.inject.Inject

class PopularPersonsActivity : BaseActivity(), PopularPersonsMvpView {



    @Inject
    lateinit var presenter: PopularPersonsMvpPresenter<PopularPersonsMvpView>

    @Inject
    lateinit var linearLayoutManager: LinearLayoutManager

    @Inject
    lateinit var groupieAdapter: GroupAdapter<ViewHolder>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popular_persons)

        activityComponent?.inject(this)

        setupRecycler()
        presenter.onAttach(this)

    }

    fun setupRecycler(){
        popular_persons_recycler.layoutManager = linearLayoutManager
        popular_persons_recycler.adapter = groupieAdapter
        groupieAdapter.setOnItemClickListener{
            item, v ->
            presenter.onItemClicked(v.tag as Int)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDetach()
    }


    override fun listPopularPersons(persons: List<PopularPerson>) {

    }

    override fun addPopularPersonToTheList(person: PopularPerson) {
        groupieAdapter.add(PersonItem(person))
    }


    override fun goToDetailsActivity() {
        val intent = Intent(this, DetailsActivity::class.java)
        startActivity(intent)
    }

}
