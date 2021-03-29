package xyz.emranul.roomdatabase.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Car(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    var name:String,
    var model:String,
    var color:String
)
