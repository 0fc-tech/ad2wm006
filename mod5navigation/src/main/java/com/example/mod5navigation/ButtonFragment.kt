package com.example.mod5navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController


class ButtonFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_button, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //On récupère le button et lors du clic sur celui-ci on navigue vers TargetFragment
        view.findViewById<Button>(R.id.button).setOnClickListener {
            findNavController().navigate(
                ButtonFragmentDirections.actionButtonTarget(
                    Singe(
                    "Mandrill","Joseph",12,"Orange",)
                )
            )
        }
    }
}