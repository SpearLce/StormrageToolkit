package com.illidancstormrage.mainapp.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Department")
data class Department(
    var dept: String,
    @ColumnInfo(name = "emp_id")
    var empId: Int,
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
)
