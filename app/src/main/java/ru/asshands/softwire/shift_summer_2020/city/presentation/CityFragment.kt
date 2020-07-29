package ru.asshands.softwire.shift_summer_2020.city.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_city.*
import ru.asshands.softwire.shift_summer_2020.R
import ru.asshands.softwire.shift_summer_2020.domain.entity.CityWeather

class CityFragment : Fragment() {
    private val ctx = activity?.applicationContext
    private val res = ctx?.resources

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_city, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val city = checkNotNull(arguments?.getParcelable<CityWeather>("city"))

        // падает тут. не могу получить Resources
        //  if (res !== null) {
        fragment_city_name.text = city.name
        fragment_city_temperature.text = res?.getString(
            R.string.temperature_placeholder, city.weather.temperature.toString()
        )
        fragment_city_humidity.text = res?.getString(
            R.string.humidity_placeholder, city.weather.humidity.toString()
        )
        fragment_city_wind_speed.text = res?.getString(
            R.string.humidity_placeholder, city.weather.windSpeed.toString()
        )
        //     } else throw error("Error! Resources is null!")
    }
}
