package com.easyinc.thecountries.mobile_ui.fragment

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.easyinc.thecountries.R
import com.easyinc.thecountries.base.BaseFragment
import com.easyinc.thecountries.mobile_ui.MainActivity
import com.easyinc.thecountries.mobile_ui.adapter.CountryAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_countries.*
import javax.inject.Inject

@AndroidEntryPoint
class CountriesFragment : BaseFragment() {

    @Inject
    lateinit var mainListAdapter: CountryAdapter

    private lateinit var mainActivity: MainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity = (activity as MainActivity)
        mainViewModel = mainActivity.mainViewModel
        mainViewModel.getCountries()
        mainActivity.showProgressbar(true)
    }

    override fun layoutId(): Int {
        return R.layout.fragment_countries
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        navigateToCountryDetails()
        refreshCountries()
        observeCountries()
        observeRefreshedCountries()
    }

    private fun refreshCountries() {
        btn_refresh_countries.setOnClickListener {
            mainViewModel.refreshCountries()
            mainActivity.showProgressbar(true)
        }
    }

    private fun navigateToCountryDetails() {
        mainListAdapter.clickListener = {
            if (it.isNotEmpty()){
                val bundle = bundleOf(resources.getString(R.string.country_name) to it)
                findNavController().navigate(R.id.action_countriesFragment_to_cityDetailsFragment,bundle)
            }

        }
    }

    private fun initRecycler() {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = mainListAdapter
        }
    }

    private fun observeCountries() {
        mainViewModel.observeCountriesList().observe(viewLifecycleOwner, Observer {
            mainListAdapter.submitList(it)
            mainActivity.showProgressbar(false)
        })
    }

    private fun observeRefreshedCountries() {
        mainViewModel.observeRefreshedCountries().observe(viewLifecycleOwner, Observer {
            mainListAdapter.submitList(it)
            mainActivity.showProgressbar(false)
        })
    }

}