package com.example.kotlindemo.customdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.kotlindemo.databinding.ActivityCustomeDialogBinding

class CustomDialogActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityCustomeDialogBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCustomeDialogBinding.inflate(layoutInflater)

        binding.dialogButton.setOnClickListener(this)
        binding.checkboxButton.setOnClickListener(this)
        binding.spinnerButton.setOnClickListener(this)

        setContentView(binding.root)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            binding.dialogButton.id->
            {
                val dialog=CustomDialogFragment()
                dialog.show(supportFragmentManager,"CustomDialog")

            }
            binding.checkboxButton.id->{
                val dialog=CheckBoxDialogFragment()
                dialog.show(supportFragmentManager,"CheckBoxDialog")
            }
            binding.spinnerButton.id->{
                val dialog=SpinnerFragment()
                dialog.show(supportFragmentManager,"Spinner")
            }
        }

    }
}