package com.example.nolazora

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.nolazora.databinding.FragmentTeamSettingBinding
import com.example.nolazora.databinding.FragmentTitleBinding


class TeamSettingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentTeamSettingBinding.inflate(inflater, container, false);
        binding.btnSelectTeam.setOnClickListener{
            findNavController().navigate(R.id.action_teamSettingFragment_to_gameSelectFragment)
        }
        return binding.root
    }

}