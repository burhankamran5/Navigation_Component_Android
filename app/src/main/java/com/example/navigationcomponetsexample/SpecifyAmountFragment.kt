package com.example.navigationcomponetsexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.navigationcomponetsexample.dataclass.Money
import java.math.BigDecimal

class SpecifyAmountFragment : Fragment() {

    var navController: NavController? = null
    var recipient: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipient = requireArguments().getString("recipient")

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.cancel_btn).setOnClickListener {
            requireActivity().onBackPressed()
        }
        val input = view.findViewById<EditText>(R.id.input_amount)
        view.findViewById<Button>(R.id.send_btn).setOnClickListener {

            if (input.text.isNotEmpty()) {
                val amount = Money(BigDecimal(input.text.toString()))
                val bundle = bundleOf(
                    "recipient" to recipient,
                    "amount" to amount

                )
                navController?.navigate(
                    R.id.action_specifyAmountFragment_to_confirmationFragment,
                    bundle,
                )
                Toast.makeText(activity, "Navigation with Arguments Done", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(activity, "Enter the Amount", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        val message = "Sending Money to $recipient"
        view.findViewById<TextView>(R.id.recipient).text = message

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_specify_amount, container, false)
    }


}