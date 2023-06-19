package com.example.nolazora

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.nolazora.databinding.FragmentGameSelectBinding
import com.example.nolazora.databinding.FragmentTeamSettingBinding

/**
 * A simple [Fragment] subclass.
 * Use the [GameSelectFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameSelectFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentGameSelectBinding.inflate(inflater, container, false);
        binding.btnGameEnd.setOnClickListener{
            findNavController().navigate(R.id.action_gameSelectFragment_to_titleFragment)
        }
        binding.btnGame1.setOnClickListener {
            findNavController().navigate(R.id.action_gameSelectFragment_to_gameOneFragment)
        }
        binding.btnGame2.setOnClickListener {
            findNavController().navigate(R.id.action_gameSelectFragment_to_gameTwoFragment)
        }
        binding.btnGame3.setOnClickListener {
            findNavController().navigate(R.id.action_gameSelectFragment_to_gameThreeFragment)
        }
        binding.btnGame4.setOnClickListener {
            findNavController().navigate(R.id.action_gameSelectFragment_to_gameFourFragment)
        }
        binding.btnGame5.setOnClickListener {
            findNavController().navigate(R.id.action_gameSelectFragment_to_gameFiveFragment)
        }
        binding.btnShowScore.setOnClickListener {
            findNavController().navigate(R.id.action_gameSelectFragment_to_gameWordFragment)
        }
        return binding.root
    }
}