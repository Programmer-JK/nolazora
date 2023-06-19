package com.example.nolazora

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nolazora.databinding.FragmentGameWordBinding
import java.util.Random


class GameWordFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding = FragmentGameWordBinding.inflate(inflater, container, false);
        var sampleArr = arrayOf("basic","amount","bank","cash","coin","cost","counter","credit","dollar","exchange",
            "expense","fare","grade","market","money","price","rent","allowance","coupon","economic",
            "seller","buyer","computer","battery","degree","goat","disease","doctor","electricity","engine",
            "poison","plastic","metal","medicine","level","iron","fever","experiment","environment","engineer",
            "research","science","steel","telephone","television","weight","weather","astronaut","compass","graph",
            "inventor","magnet","scope","telescope","spaceship","surgery","tissue","vacuum","airplane","airport",
            "gather","material","presciption","skip","force","fundamental","attract","regular","firm","ecological",
            "intent","entail","contend","descent","population","ambiguity","sabotage","abundance","resume","solution",
            "water","involve","tragedy","racial","specific","rough","steep","numerous","humid","metaphor",
            "anecdote","notably","edible","colonize","bias","cohesion","livestock","outlet","greed","fatality",
            "variance","myriad","enhance","emerge","feminine","inspire","cherish","urban","innocent","stripe",
            "internet","multiplex","connect","transport","transfer","segment","flow","management","principle","congestion",
            "logical","algorithm","effort","layer","reliable","application","network","link","physical","socket",
            "process","port","datagram","payload","recall","source","code","thread","thread","host",
            "length","handshaking","software","streaming","multimedia","header","format","checksum","wrap","service",
            "send","action","receive","machines","channel","packet","index","sequence","while","time",
            "pipeline","cumulative","database","duplex","hash","table","probe","pattern","shift","predict",
            "curriculum","dress","theft","means","suspect","depiction","disobedient","endure","examplary","suppress",
            "accuse","distrust","testimony","compel","crucial","judicial","resolution","trespass","bound","enactment",
            "excursion","flock","mural","choir","right","splash","stroll","bring","propel","eminent");

        val list = mutableListOf<Int>().apply{
            for(i in 0..99){
                this.add(i)
            }
        }
        list.shuffle()
        var Iter = 0;

        binding.button.setOnClickListener {
            binding.textView.text = sampleArr.get(list[Iter])
            Iter++;
            binding.tvCount.text = Iter.toString()
        }
        return binding.root;
    }
}