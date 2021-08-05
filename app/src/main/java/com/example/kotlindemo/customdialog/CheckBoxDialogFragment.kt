package com.example.kotlindemo.customdialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.lifecycleScope
import com.example.kotlindemo.databinding.FragmentCheckBoxDialogBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class CheckBoxDialogFragment : DialogFragment() {
    private lateinit var binding: FragmentCheckBoxDialogBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCheckBoxDialogBinding.inflate(inflater, container, false)

        binding.orderButton.setOnClickListener {
            getOrder()
        }
        binding.cancelOrderButton.setOnClickListener {
            dismiss()
        }
        return binding.root
    }

    private fun getOrder() {
        lifecycleScope.launch {
            val onion = binding.onionCheckBox.isChecked
            val cheese = binding.cheeseCheckBox.isChecked
            val chicken = binding.chickenCheckBox.isChecked
            val order =
                "Your order is \n ${if (onion) "Onion" else ""}\n" +
                        "${if (cheese) "Cheese" else ""}\n" +
                        " ${if (chicken) "Chicken" else ""}"
            withContext(Dispatchers.Main) {
                binding?.orderTextView.text = order
            }
        }
    }


}