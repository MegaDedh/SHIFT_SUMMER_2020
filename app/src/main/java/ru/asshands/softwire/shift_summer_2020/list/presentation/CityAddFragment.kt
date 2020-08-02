package ru.asshands.softwire.shift_summer_2020.list.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_add_city.*
import ru.asshands.softwire.shift_summer_2020.R


class CityAddFragment : Fragment(R.layout.fragment_add_city) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ctx = activity?.applicationContext ?: throw error("Fail get applicationContext")

        fragment_add_city_button_add.setOnClickListener {
            val inputCity = fragment_add_city_name.text.toString()
            val inputTemperature = fragment_add_city_temperature.text.toString().toIntOrNull()

            if (inputCity.isNotBlank() && inputTemperature != null) {
                Toast.makeText(ctx, "Функция добавления не добавлена", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(ctx, "Все поля должны быть заполнены", Toast.LENGTH_LONG).show()
            }
        }
    }
}