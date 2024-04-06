package com.illidancstormrage.mainapp.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.illidancstormrage.mainapp.room.entity.User


@Dao
interface UserDao {
    //非查询返回值可以不写
    @Insert
    fun insertUser(vararg users: User): List<Long> //插入单个，返回插入rowId
    @Insert
    fun insertUser(user: User): Long
    @Insert
    fun insert(user: List<User>): List<Long>

    @Query("select * from User")
    fun getAllUsers(): List<User>


}