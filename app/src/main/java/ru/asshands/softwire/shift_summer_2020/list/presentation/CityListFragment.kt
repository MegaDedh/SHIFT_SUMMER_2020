package ru.asshands.softwire.shift_summer_2020.list.presentation

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_weather_list.*
import ru.asshands.softwire.shift_summer_2020.R
import ru.asshands.softwire.common.CityWeather
import ru.asshands.softwire.shift_summer_2020.list.di.CityListViewModelFactory

class CityListFragment : Fragment(R.layout.fragment_weather_list) {

    private val viewModel: CityListViewModel by viewModels {
        CityListViewModelFactory()
    }
    private val adapter =
        CityListAdapter(CityDiffUtilCallback()) { city ->
            viewModel.cityClicked(city)
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.cityClickedEvent.observe(this, Observer(::showCityDetails))

        initTrainsRecyclerView()

        fragment_weather_list_add_city_fab.setOnClickListener {
            addCity()
        }
    }

    private fun setCityList(cityList: PagedList<CityWeather>) {
        adapter.submitList(cityList)
        fragment_weather_list_recyclerView.adapter = adapter
        fragment_weather_list_list_progress_bar.visibility = View.GONE
    }

    private fun showCityDetails(city: CityWeather) {
        val bundle = bundleOf("city" to city)
        findNavController()
            .navigate(R.id.action_weatherListFragment_to_cityFragment, bundle)
    }

    private fun addCity() {
        findNavController()
            .navigate(R.id.action_weatherListFragment_to_cityAddFragment)
    }

    private fun initTrainsRecyclerView() {
        fragment_weather_list_recyclerView.layoutManager = LinearLayoutManager(context)
                viewModel.city.observe(this, Observer(::setCityList))

    }

}