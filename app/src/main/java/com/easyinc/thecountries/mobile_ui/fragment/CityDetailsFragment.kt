package com.easyinc.thecountries.mobile_ui.fragment

import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.easyinc.thecountries.R
import com.easyinc.thecountries.base.BaseFragment
import com.easyinc.thecountries.mobile_ui.MainActivity
import com.easyinc.thecountries.presentation.model.CountryDetailsView
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import kotlinx.android.synthetic.main.fragment_city_details.*


class CityDetailsFragment : BaseFragment() {

    lateinit var countryName: String

    private lateinit var mainActivity: MainActivity

    override fun layoutId(): Int {
        return R.layout.fragment_city_details
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity = (activity as MainActivity)
        countryName = requireArguments().getString(resources.getString(R.string.country_name))!!
        mainViewModel = mainActivity.mainViewModel
        mainViewModel.getCountryByName(countryName)
        mainActivity.showProgressbar(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeCountryDetails()
        observeCountryDetailsError()
    }

    private fun observeCountryDetailsError() {
        mainViewModel.observeCountryDetailsError().observe(viewLifecycleOwner, Observer {
            if (it)
                showErrorLayout(false)
            else
                showErrorLayout(true)
        })
    }

    private fun showErrorLayout(show: Boolean) {
        ll_error?.visibility = if (show) View.VISIBLE else View.GONE
    }

    private fun observeCountryDetails() {
        mainViewModel.observeCountry().observe(viewLifecycleOwner, Observer {
            drawCountryInfo(it)
            mainActivity.showProgressbar(false)
        })
    }

    private fun drawCountryInfo(country: CountryDetailsView) {
        GlideToVectorYou.init().with(context).load(Uri.parse(country.flag),img_country_image)
        tv_country_name.text = country.name
        tv_country_language.text = country.language
        tv_country_currency.text = country.currency
        tv_country_timezone.text = country.timezone
    }

}