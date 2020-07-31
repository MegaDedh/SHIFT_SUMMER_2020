package ru.asshands.softwire.shift_summer_2020.list.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import okhttp3.logging.HttpLoggingInterceptor
import ru.asshands.softwire.shift_summer_2020.list.data.CityRepositoryImpl
import ru.asshands.softwire.shift_summer_2020.list.data.NetworkCityDataSourceImpl
import ru.asshands.softwire.shift_summer_2020.list.domain.GetCityUseCase
import ru.asshands.softwire.shift_summer_2020.list.presentation.CityListViewModel


class CityListViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass == CityListViewModel::class.java) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()
            val retrofit = Retrofit.Builder()
                .baseUrl("https://shift-summer-2020.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

            val api = retrofit.create(NotesApi::class.java)


            val networkDataSource = NetworkCityDataSourceImpl(api)
            val cityRepository = CityRepositoryImpl(networkDataSource)
            val getCityUseCase = GetCityUseCase(cityRepository)

            return CityListViewModel(getCityUseCase) as T
        } else {
            error("Unexpected class $modelClass")
        }
    }
}