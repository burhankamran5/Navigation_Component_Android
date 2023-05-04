package com.example.navigationcomponetsexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation


class ChooserRecipientFragment : Fragment() {

    var navController: NavController? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        val input = view.findViewById<EditText>(R.id.input_recipient)

        view.findViewById<Button>(R.id.next_btn).setOnClickListener {
            if (input.text.isNotEmpty()) {
                val bundle = bundleOf("recipient" to input.text.toString())
                navController?.navigate(
                    R.id.action_chooserRecipientFragment_to_specifyAmountFragment,
                    bundle
                )
            }else{
                Toast.makeText(activity, "Enter the name", Toast.LENGTH_SHORT)
                    .show()
            }
        }
        view.findViewById<Button>(R.id.cancel_btn).setOnClickListener {
            requireActivity().onBackPressed()
        }


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chooser_recipient, container, false)
    }


}