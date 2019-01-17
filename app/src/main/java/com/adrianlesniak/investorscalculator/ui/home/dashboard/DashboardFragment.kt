package com.adrianlesniak.investorscalculator.ui.home.dashboard

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.adrianlesniak.investorscalculator.App
import com.adrianlesniak.investorscalculator.R
import com.adrianlesniak.investorscalculator.ui.calculation.NewCalculationActivity
import com.adrianlesniak.investorscalculator.utils.AmountFormatter
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : Fragment() {

    companion object {
        fun newInstance() = DashboardFragment()
    }

    private val viewModel: DashboardViewModel by lazy {
        val dashboardViewModelFactory = (activity!!.application as App).dashboardViewModelFactory
        ViewModelProviders.of(this, dashboardViewModelFactory).get(DashboardViewModel::class.java)
    }

    private val amountFormatter: AmountFormatter by lazy {
        (activity!!.application as App).amountFormatter
    }

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

        val calculationsAdapter = CalculationsAdapter(layoutInflater, amountFormatter, viewModel)
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