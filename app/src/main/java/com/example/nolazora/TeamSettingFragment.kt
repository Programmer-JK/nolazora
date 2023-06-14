package com.example.nolazora

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.view.isVisible
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

        var spinData = resources.getStringArray(R.array.count)
        var adapter = getActivity()?.let { ArrayAdapter<String>(it, android.R.layout.simple_list_item_1, spinData) }
        binding.spinPeopleCount.adapter = adapter

        binding.spinPeopleCount.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            var teamArr = arrayOf(binding.twTeam1,binding.twTeam2,binding.twTeam3,binding.twTeam4,binding.twTeam5,binding.twTeam6,binding.twTeam7,binding.twTeam8)
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                teamArr.forEach{v -> v.isVisible = false}
                if ( position != 0 ){
                    for (i in 0..position step(1)){
                        teamArr[i].isVisible = true;
                    }
                }
            }
        }
        return binding.root
    }

}