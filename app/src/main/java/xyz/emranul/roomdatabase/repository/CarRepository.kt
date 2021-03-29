package xyz.emranul.roomdatabase.repository

import androidx.lifecycle.LiveData
import xyz.emranul.roomdatabase.model.Car
import xyz.emranul.roomdatabase.room.CarDao

class CarRepository(private val carDao: CarDao) {
    suspend fun addCar(car: Car) {
        carDao.addCar(car)
    }

    suspend fun updateCar(car: Car) {
        carDao.updateCar(car)
    }

    suspend fun deleteCar(car: Car) {
        carDao.deleteCar(car)
    }

    suspend fun deleteAllCar() {
        carDao.deleteAllCar()
    }

    val allCar :LiveData<List<Car>> = carDao.getAllCar()
}