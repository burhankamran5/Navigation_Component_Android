package com.example.navigationcomponetsexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation


class MainFragment : Fragment() {

    var navController: NavController? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.view_transactions_btn).setOnClickListener {
            navController?.navigate(R.id.action_mainFragment_to_viewTransactionFragment)
        }
        view.findViewById<Button>(R.id.view_balance_btn).setOnClickListener{
            navController?.navigate(R.id.action_mainFragment_to_viewBalanceFragment)
        }
        view.findViewById<Button>(R.id.send_money_btn).setOnClickListener{
            navController?.navigate(R.id.action_mainFragment_to_chooserRecipientFragment)

        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_main, container, false)
    }




}