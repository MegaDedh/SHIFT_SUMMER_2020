package ru.asshands.softwire.shift_summer_2020.list.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_weather_list.*
import ru.asshands.softwire.shift_summer_2020.R
import ru.asshands.softwire.common.City
import ru.asshands.softwire.shift_summer_2020.list.di.CityListViewModelFactory

class CityListFragment : Fragment(R.layout.fragment_weather_list) {

    private val viewModel: CityListViewModel by viewModels {
        CityListViewModelFactory()
    }
    private val adapter =
        CityListAdapter { city ->
            viewModel.cityClicked(city)
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.city.observe(this, Observer(::setCityList))
        viewModel.cityClickedEvent.observe(this, Observer(::showCityDetails))

        initTrainsRecyclerView()
    }

    private fun setCityList(cityList: List<City>) {
        adapter.setCityList(cityList)
    }

    private fun showCityDetails(city: City) {
        val bundle = bundleOf("city" to city)
        findNavController()
            .navigate(R.id.action_weatherListFragment_to_cityFragment, bundle)
    }

    private fun initTrainsRecyclerView() {
        cities_list_fragment_recyclerView.layoutManager = LinearLayoutManager(context)
        cities_list_fragment_recyclerView.adapter = adapter
    }

}