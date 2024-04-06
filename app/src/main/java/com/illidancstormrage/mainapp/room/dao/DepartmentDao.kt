package com.illidancstormrage.mainapp.room.dao

import androidx.room.Dao
import com.illidancstormrage.mainapp.room.entity.Department
import com.illidancstormrage.utils.database.room.dao.BaseDao

@Dao
abstract class DepartmentDao : BaseDao<Department>() {

}