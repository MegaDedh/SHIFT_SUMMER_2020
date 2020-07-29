package ru.asshands.softwire.shift_summer_2020.list.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_city.view.*
import ru.asshands.softwire.shift_summer_2020.R
import ru.asshands.softwire.shift_summer_2020.domain.entity.City
import java.util.*

class CityListAdapter(
    private val clickListener: (City) -> Unit
) : RecyclerView.Adapter<CityListAdapter.ViewHolder>() {

    private val cityList: MutableList<City> = LinkedList()

    fun setCityList(newCity: List<City>) {
        cityList.clear()
        cityList.addAll(newCity)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View, private val cityListener: (City) -> Unit) :
        RecyclerView.ViewHolder(itemView) {



        fun bindView(item: City) {
            itemView.item_city_name.text = item.name
            itemView.item_city_temperature.text = "Темпратура ${item.weather.temperature}"
            itemView.item_city_humidity.text = "Влажность ${item.weather.humidity}"
            itemView.item_city_wind_speed.text = "Ветер ${item.weather.windSpeed}"

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
        val item = cityList[position]
        holder.bindView(item)
    }

    override fun getItemCount(): Int {
        return cityList.size
    }

}