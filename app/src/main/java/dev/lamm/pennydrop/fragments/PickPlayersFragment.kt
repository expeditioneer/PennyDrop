package dev.lamm.pennydrop.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import dev.lamm.pennydrop.databinding.FragmentPickPlayersBinding
import dev.lamm.pennydrop.viewmodels.PickPlayersViewModel


class PickPlayersFragment : Fragment() {

    private val pickPlayersViewModel by activityViewModels<PickPlayersViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentPickPlayersBinding
            .inflate(inflater, container, false)
            .apply {
                this.vm = pickPlayersViewModel
            }

        return binding.root
    }
}