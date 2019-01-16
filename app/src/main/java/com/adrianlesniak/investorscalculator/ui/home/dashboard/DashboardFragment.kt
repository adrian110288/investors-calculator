package com.adrianlesniak.investorscalculator.ui.home.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.adrianlesniak.investorscalculator.App
import com.adrianlesniak.investorscalculator.R
import com.adrianlesniak.investorscalculator.ui.calculation.NewCalculationActivity
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : Fragment() {

    companion object {
        fun newInstance() = DashboardFragment()
    }

    private lateinit var viewModel: DashboardViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        (activity as? AppCompatActivity)?.supportActionBar?.title = ""
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dashboardViewModelFactory = (activity!!.application as App).dashboardViewModelFactory
        viewModel = ViewModelProviders.of(this, dashboardViewModelFactory).get(DashboardViewModel::class.java)

        val calculationsAdapter = CalculationsAdapter(context)
        past_calculations_recycler_view.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = calculationsAdapter
        }

        new_calculation_fab.setOnClickListener {
            activity?.let { NewCalculationActivity.launch(it) }
        }

        viewModel.calculations.observe(this, Observer {
            calculationsAdapter.addItems(it)
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.dashboard_toolbar_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

}