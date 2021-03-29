package xyz.emranul.roomdatabase.viewmodel

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import xyz.emranul.roomdatabase.model.Car
import xyz.emranul.roomdatabase.repository.CarRepository
import xyz.emranul.roomdatabase.room.CarDatabase

class CarViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: CarRepository
    private var allCar :LiveData<List<Car>>

    init {
        val carDao = CarDatabase.getDatabase(application).carDao()
        repository = CarRepository(carDao)
        allCar = repository.allCar
    }

    fun getAllCar(): LiveData<List<Car>> = allCar

    fun addCar(car: Car) {
        viewModelScope.launch {
            repository.addCar(car)
        }
    }

    fun updateCar(car: Car) {
        viewModelScope.launch {
            repository.updateCar(car)
        }
    }

    fun deleteCar(car: Car) {
        viewModelScope.launch {
            repository.deleteCar(car)
        }
    }

    fun deleteAllCar() {
        viewModelScope.launch {
            repository.deleteAllCar()
        }
    }

}