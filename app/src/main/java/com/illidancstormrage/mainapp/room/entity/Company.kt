package com.illidancstormrage.mainapp.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Company")
data class Company(
    var name: String,
    var age: Int,
    var address: String,
    var salary: Double,
    @PrimaryKey(autoGenerate = true)
    var id: Long
)