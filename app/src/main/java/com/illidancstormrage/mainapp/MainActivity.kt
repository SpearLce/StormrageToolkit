package com.illidancstormrage.mainapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.illidancstormrage.mainapp.databinding.ActivityMainBinding
import com.illidancstormrage.utils.extensions.javaClassName
import com.illidancstormrage.utils.log.LogUtil
import com.illidancstormrage.utils.snackbar.showSnackBar
import com.illidancstormrage.utils.toast.makeToast

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //toast
        //this.javaClass.simpleName.makeToast(Toast.LENGTH_LONG)

        //snackBar
        /*val view = binding.root
        view.showSnackBar(
            message = "snackBar",
            duration = Snackbar.LENGTH_INDEFINITE,
            actionBtnText = "撤销",
            {
                //snackBar设置属性
                setActionTextColor(Color.YELLOW)
            }
        )
        {
            //button 监听逻辑
            "123".makeToast(Toast.LENGTH_LONG)
        }*/

        //LogUtil
        //LogUtil.e(msg = "xxxx")

        //Any.javaClassName
        //LogUtil.d(msg = this.javaClassName)
    }
}