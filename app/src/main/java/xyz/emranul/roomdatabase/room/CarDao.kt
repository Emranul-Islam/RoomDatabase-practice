package xyz.emranul.roomdatabase.room

import androidx.lifecycle.LiveData
import androidx.room.*
import xyz.emranul.roomdatabase.model.Car

@Dao
interface CarDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCar(car: Car)

    @Update
    suspend fun updateCar(car: Car)

    @Query("SELECT * FROM car ORDER BY id ASC")
    fun getAllCar(): LiveData<List<Car>>

    @Delete()
    suspend fun deleteCar(car: Car)

    @Query("DELETE FROM car")
    suspend fun deleteAllCar()

}