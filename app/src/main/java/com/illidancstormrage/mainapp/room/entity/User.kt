package com.illidancstormrage.mainapp.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    var name: String,
    var age: Int,
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0 //id放最后，自动id情况下，默认参数仅提供占位
)
