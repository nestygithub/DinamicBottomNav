package com.chiki.dinamicbottomnav.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.chiki.dinamicbottomnav.R
import com.chiki.dinamicbottomnav.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    //ViewModel
    private lateinit var dashboardViewModel: DashboardViewModel

    //Binding
    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    //Lifecycle
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dashboardViewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)        //Initialize ViewModel

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)         //Initialize Binding
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner){
            textView.text = it
        }
        return root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}