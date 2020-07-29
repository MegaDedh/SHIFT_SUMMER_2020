package ru.asshands.softwire.shift_summer_2020.city.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_city.*
import ru.asshands.softwire.shift_summer_2020.R
import ru.asshands.softwire.shift_summer_2020.domain.entity.City

class CityDetailFragment : Fragment() {
    private val ctx = activity?.applicationContext

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_city, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val city = checkNotNull(arguments?.getParcelable<City>("city"))

        fragment_city_name.text = city.name
        fragment_city_temperature.text = "Темпратура ${city.weather.temperature}"
        fragment_city_humidity.text = "Влажность ${city.weather.humidity}"
        fragment_city_wind_speed.text = "Ветер ${city.weather.windSpeed}"
    }
}