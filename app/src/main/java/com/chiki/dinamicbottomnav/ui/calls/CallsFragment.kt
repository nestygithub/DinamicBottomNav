package com.chiki.dinamicbottomnav.ui.calls

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.chiki.dinamicbottomnav.databinding.CallsFragmentBinding

class CallsFragment : Fragment() {

    //ViewModel
    private lateinit var callsViewModel: CallsViewModel

    //Binding
    private var _binding: CallsFragmentBinding? = null
    private val binding get() = _binding!!

    //Lifecycle
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        callsViewModel = ViewModelProvider(this)[CallsViewModel::class.java]        //Initialize ViewModel

        _binding = CallsFragmentBinding.inflate(inflater, container, false)         //Initialize Binding
        val root: View = binding.root

        val textView: TextView = binding.textCalls
        callsViewModel.text.observe(viewLifecycleOwner){
            textView.text = it
        }
        return root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}