package com.chiki.dinamicbottomnav.ui.settings

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.chiki.dinamicbottomnav.databinding.SettingsFragmentBinding

class SettingsFragment : Fragment() {

    //ViewModel
    private lateinit var settingsViewModel: SettingsViewModel

    //Binding
    private var _binding: SettingsFragmentBinding? = null
    private val binding get() = _binding!!

    //Lifecycle
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        settingsViewModel = ViewModelProvider(this)[SettingsViewModel::class.java]      //Initialize viewModel

        _binding = SettingsFragmentBinding.inflate(inflater, container, false)      //Initialize Binding
        val root: View = binding.root

        val textView: TextView = binding.textSettings
        settingsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}