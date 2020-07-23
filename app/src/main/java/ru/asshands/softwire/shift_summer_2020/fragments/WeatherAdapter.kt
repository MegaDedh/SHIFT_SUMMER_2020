package ru.asshands.softwire.shift_summer_2020.fragments

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_city.view.*
import ru.asshands.softwire.shift_summer_2020.R
import ru.asshands.softwire.shift_summer_2020.models.CityWeather

class WeatherAdapter(

    private val list: List<CityWeather>,
    private val context: Context
) : RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {



        fun bindView(ctx: Context, item: CityWeather) {
            val res = ctx.resources
            itemView.item_city_name.text = item.name
            itemView.item_city_temperature.text = res.getString(
                R.string.temperature_placeholder, item.weather.temperature.toString()
            )
            itemView.item_city_humidity.text = res.getString(
                R.string.humidity_placeholder, item.weather.humidity.toString()
            )
            itemView.item_city_wind_speed.text = res.getString(
                R.string.humidity_placeholder, item.weather.windSpeed.toString()
            )


            itemView.setOnClickListener {
                val bundle = bundleOf("city" to item)
                it.findNavController()
                    .navigate(R.id.action_weatherListFragment_to_cityFragment,bundle)
        }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_city, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.bindView(context, item)
    }

    override fun getItemCount(): Int {
        return list.size
    }

}