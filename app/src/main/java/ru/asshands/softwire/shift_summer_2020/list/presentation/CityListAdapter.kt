package ru.asshands.softwire.shift_summer_2020.list.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_city.view.*
import ru.asshands.softwire.shift_summer_2020.R
import ru.asshands.softwire.common.CityWeather
import java.util.*

class CityListAdapter(
    diffUtilCallback: CityDiffUtilCallback,
    private val clickListener: (CityWeather) -> Unit
) : PagedListAdapter<CityWeather, CityListAdapter.ViewHolder>(diffUtilCallback) {

//    old version:
//    private val cityList: MutableList<CityWeather> = LinkedList()
//    fun setCityList(newCity: List<CityWeather>) {
//        cityList.clear()
//        cityList.addAll(newCity)
//        notifyDataSetChanged()
//    }

    class ViewHolder(itemView: View, private val cityListener: (CityWeather) -> Unit) :
        RecyclerView.ViewHolder(itemView) {

        fun bindView(item: CityWeather) {
            itemView.item_city_name.text = item.name
            itemView.item_city_temperature.text = "Темпратура ${item.temperature}"
            //itemView.item_city_humidity.text = "Влажность ${item.weather.humidity}"
            //itemView.item_city_wind_speed.text = "Ветер ${item.weather.windSpeed}"

            itemView.setOnClickListener {
                cityListener(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_city, parent, false)
        return ViewHolder(
            view, clickListener
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        getItem(position)?.let { holder.bindView(it) }
    }

//    override fun getItemCount(): Int {
//        return cityList.size
//    }

}