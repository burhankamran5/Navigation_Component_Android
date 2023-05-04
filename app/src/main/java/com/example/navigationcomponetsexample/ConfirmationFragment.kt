package com.example.navigationcomponetsexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.navigationcomponetsexample.dataclass.Money

class ConfirmationFragment : Fragment() {

    lateinit var recipient: String
    lateinit var money: Money

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        recipient = arguments?.getString("recipient").toString()
        money = arguments?.getParcelable("amount")!!

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_confirmation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val amount = money.amount
        val res = "You have  sent $amount to $recipient"
        view.findViewById<TextView>(R.id.confirmation_message).text = res


    }
}