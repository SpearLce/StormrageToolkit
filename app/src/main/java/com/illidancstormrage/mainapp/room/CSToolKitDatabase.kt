package com.illidancstormrage.mainapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.illidancstormrage.mainapp.room.dao.DepartmentDao
import com.illidancstormrage.mainapp.room.dao.UserDao
import com.illidancstormrage.mainapp.room.entity.Department
import com.illidancstormrage.mainapp.room.entity.User
import kotlin.reflect.KClass


@Database(entities = [User::class, Department::class], version = 1, exportSchema = false)
abstract class CSToolKitDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun departmentDao(): DepartmentDao

    companion object {
        //db单例模式
        //1 存放单例的变量
        private var instance: CSToolKitDatabase? = null
        private var instanceInMemory: CSToolKitDatabase? = null

        @Synchronized //保证线程安全，防止多线程环境下初始化多个数据库实例
        fun getLocalDatabase(context: Context): CSToolKitDatabase { //一个静态工厂方法
            //2 判断单例变量是否为空
            instance?.let {
                //不为空，单例返回
                return it
            }
            return Room.databaseBuilder(
                context.applicationContext,//app上下文
                CSToolKitDatabase::class.java, //db.class
                "app_database"//数据库名
            ).build().apply {
                instance = this //保存单例
            }
        }

        @Synchronized
        fun getMemoryDatabase(context: Context) = if (instanceInMemory != null) {
            instanceInMemory!!
        } else {
            Room.inMemoryDatabaseBuilder(
                context,
                CSToolKitDatabase::class.java
            ).build().apply {
                instanceInMemory = this
            }
        }

    }

}