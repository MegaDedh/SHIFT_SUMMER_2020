package ru.asshands.softwire.shift_summer_2020.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_weather_list.*
import ru.asshands.softwire.shift_summer_2020.R
import ru.asshands.softwire.shift_summer_2020.models.CityWeather
import ru.asshands.softwire.shift_summer_2020.models.WeatherParams

class WeatherListFragment : Fragment() {
    private val cityWeather = mutableListOf<CityWeather>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_weather_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initTrainsRecyclerView()
        setTestData()


        cities_list_fragment_recyclerView.adapter =
            WeatherAdapter(cityWeather, view.context)

    }

    private fun initTrainsRecyclerView() {
        cities_list_fragment_recyclerView.layoutManager = LinearLayoutManager(context)

    }

    private fun setTestData() {
        cityWeather.clear()
        cityWeather.add(CityWeather("Томск", WeatherParams(20.6f, 70, 3)))
        cityWeather.add(CityWeather("Новосибирск", WeatherParams(25.4f, 60, 5)))
        cityWeather.add(CityWeather("Москва", WeatherParams(23.4f, 55, 7)))
        cityWeather.add(CityWeather("Краснодар", WeatherParams(41f, 63, 10)))
        cityWeather.add(CityWeather("Сургут", WeatherParams(-45.3f, 40, 8)))
        cityWeather.add(CityWeather("Воркута", WeatherParams(-45.3f, 40, 14)))
        cityWeather.add(CityWeather("Магадан", WeatherParams(-55.3f, 57, 17)))
        cityWeather.add(CityWeather("Якутск", WeatherParams(-65.3f, 60, 20)))
    }

}
