package com.example.kotlindemo.customdialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.lifecycleScope
import com.example.kotlindemo.databinding.FragmentCustomDialogBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class CustomDialogFragment : DialogFragment(), View.OnClickListener {

    private lateinit var binding: FragmentCustomDialogBinding
    private var radioData: String? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCustomDialogBinding.inflate(inflater, container, false)
        binding.confirmButton.setOnClickListener(this)
        binding.cancelButton.setOnClickListener(this)

        lifecycleScope.launch {
            withContext(Dispatchers.Main) {
                radioData = choose()
            }
        }
        return binding.root
    }

    private suspend fun choose():String?{
        binding.rattingRadioGroup.setOnCheckedChangeListener { _, checkedId ->
            radioData= binding.rattingRadioGroup.findViewById<RadioButton>(checkedId).text.toString()
            // Toast.makeText(requireContext(), "Confirm $${radioButton.text.toString()}", Toast.LENGTH_LONG).show()
        }
        return radioData
    }


    override fun onClick(view: View?) {
        when (view?.id) {
            binding.confirmButton.id -> {

                Toast.makeText(context, "$radioData", Toast.LENGTH_SHORT).show()
                }

            binding.cancelButton.id -> {
                Toast.makeText(requireContext(), "cancel", Toast.LENGTH_LONG).show()
                dismiss()
            }

        }

    }
}

