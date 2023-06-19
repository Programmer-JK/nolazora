package com.example.nolazora

import android.app.AlertDialog
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.example.nolazora.databinding.FragmentGameOneBinding


class GameOneFragment : Fragment() {
    lateinit var binding: FragmentGameOneBinding
    lateinit var countDownTimer : CountDownTimer

    var gameStart = false;
    var teamAend = false;
    var teamBend = false;

    var teamAscore = 0;
    var teamBscore = 0;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentGameOneBinding.inflate(inflater, container, false);
        binding.btnCorrect.isEnabled = false;
        binding.btnWrong.isEnabled = false;
        binding.tvScore.text = "0"

        val list = mutableListOf<Int>().apply{
            for(i in 0..41){
                this.add(i)
            }
        }
        list.shuffle()
        var iter = 0;
        binding.btnSkip.setOnClickListener {
            if(gameStart){
                //skip 동작 코드
            } else {
                if(teamAend && teamBend){ // AB 둘다 끝났을 때
                    gameStart = false;
                } else if (teamAend && !teamBend){ // A만 끝났을 때
                    binding.tvTeamName.text = "Team B"
                }
                gameStart = true;
                binding.btnSkip.text = "SKIP";
                binding.btnCorrect.isEnabled = true;
                binding.btnWrong.isEnabled = true;
                startTimer();
            }

        }
        binding.btnCorrect.setOnClickListener {
            if(!teamAend){
                teamAscore++;
                binding.tvScore.text = teamAscore.toString();
            } else {
                teamBscore++;
                binding.tvScore.text = teamBscore.toString();
            }
        }

        return binding.root
    }
    private fun startTimer() {
        countDownTimer = object:CountDownTimer(2000, 1000){
            override fun onTick(p0: Long) {
                binding.tvTimer.text = (p0 / 1000).toString()
            }
            override fun onFinish() {
                binding.tvTimer.text = "end"
                binding.btnSkip.text = "START"
                gameStart = false;
                binding.btnCorrect.isEnabled = false;
                binding.btnWrong.isEnabled = false;

                if(!teamAend){
                    teamAend = true;
                } else {
                    teamBend = true;
                }
            }
        }
        countDownTimer.start();
    }

}