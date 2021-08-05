package com.example.kotlindemo.customdialog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.kotlindemo.R
import com.example.kotlindemo.databinding.FragmentSpinnerBinding

class SpinnerFragment : DialogFragment() {

    private lateinit var binding: FragmentSpinnerBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSpinnerBinding.inflate(inflater, container, false)
            //String array
            binding.weekDaySpinner.onItemSelectedListener=object :AdapterView.OnItemSelectedListener{
                override fun onItemSelected(adapterView: AdapterView<*>?, p1: View?, posion: Int, p3: Long) {

                    binding.spinnerDataTextView.text="Select week day from Spinner "+adapterView?.getItemAtPosition(posion).toString()
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

            }
        //Array
        val customList= arrayOf("January","February","March","April")
        val adapter=ArrayAdapter<String>(requireContext(),R.layout.support_simple_spinner_dropdown_item,customList)
        binding.monthSpinner.adapter=adapter
        binding.monthSpinner.onItemSelectedListener=object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(adapterView: AdapterView<*>?, p1: View?, posion: Int, p3: Long) {
              //  Toast.makeText(context,"${adapterView?.getItemAtPosition(posion).toString()}", Toast.LENGTH_SHORT).show()
                binding.spinnerMonthTextView.text="Selected Month from Spinner "+adapterView?.getItemAtPosition(posion).toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }


        return binding.root

    }
}