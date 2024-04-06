package com.illidancstormrage.mainapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.sqlite.db.SimpleSQLiteQuery
import com.illidancstormrage.mainapp.databinding.ActivityMainBinding
import com.illidancstormrage.mainapp.room.CSToolKitDatabase
import com.illidancstormrage.mainapp.room.entity.Department
import com.illidancstormrage.mainapp.room.entity.User
import com.illidancstormrage.utils.database.room.condition.AbstractWrapper
import com.illidancstormrage.utils.database.room.condition.QueryWrapper
import com.illidancstormrage.utils.log.LogUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //1获取数据库实例
        val db = CSToolKitDatabase.getMemoryDatabase(this)
        //2获取dao代理实例
        val userDao = db.userDao()
        val user1 = User(name = "jack", age = 12)
        val user2 = User(name = "jack", age = 12)
        val userList = ArrayList<User>().apply {
            add(user1)
            add(user2)
        }
        val departmentDao = db.departmentDao()
        val department1 = Department(dept = "Mark", empId = 4)
        val department2 = Department(dept = "John", empId = 10)
        val department3 = Department(dept = "Son", empId = 12)
        val department4 = Department(dept = "Suju", empId = 20)
        val department5 = Department(dept = "LinShu", empId = 41)
        val departmentList = ArrayList<Department>().apply {
            add(department1)
            add(department2)
            add(department3)
            add(department4)
            add(department5)
        }


        //3非主线程进行数据操作
        lifecycleScope.launch(Dispatchers.IO) {
            launch {
                //val resInt = userDao.insertUser(user1)
                //LogUtil.e(msg = "插入影响行数resInt - $resInt")
                //val resIntList = userDao.insert(userList)
                //LogUtil.e(msg = "resIntList - $resIntList")
                //LogUtil.e(msg = "返回表名 = ${departmentDao.tableName}")
            }
            launch {
                /*val resLong = departmentDao.insert(department1)
                LogUtil.e(msg = "部门插入结果resLong - $resLong")
                val resList = departmentDao.insert(departmentList)
                LogUtil.e(msg = "部门插入结果resList - $resList")
                val id = resList[0]
                val departmentRes = departmentDao.selectById(id = id)
                LogUtil.e(msg = "selectById - $departmentRes")
                LogUtil.e(msg = "selectByIds - ${departmentDao.selectByIds(3, 2)}")
                LogUtil.e(msg = "selectAll - ${departmentDao.selectAll()}")
                //删除 d1
                department1.id = resLong
                department2.id = 2*/

                //LogUtil.e(msg = "selectAll - ${departmentDao.delete(department1, department2)}")
                //LogUtil.e(msg = "selectAll - ${departmentDao.selectAll()}")
                /*LogUtil.e(
                    msg = "select SimpleSQLiteQuery - ${
                        departmentDao.queryOne(
                            SimpleSQLiteQuery(
                                query = "select * from Department where emp_id > ?",
                                bindArgs = arrayOf(5)
                            )
                        )
                    }"
                )*/
                //LogUtil.e(msg = "------------------------")
                //包装类
                /*val queryWrapper = QueryWrapper()
                queryWrapper.eq( "dept", "Mark")
                    .between(conjunction = AbstractWrapper.CONJUNCTION_OR,"emp_id", 9, 21)

                LogUtil.e(msg = "queryWrapper - $queryWrapper")
                LogUtil.e(msg = "queryWrapper - ${queryWrapper.getWhereClause()}")
                LogUtil.e(msg = "------------------------")
                LogUtil.e(msg = "结果： ${departmentDao.selectList(queryWrapper)}")*/


            }
            launch {
                LogUtil.e(msg = "------------------------")
                val resList = departmentDao.insert(departmentList)
                LogUtil.e(msg = "部门插入结果resList - $resList")

            }


        }

    }
}