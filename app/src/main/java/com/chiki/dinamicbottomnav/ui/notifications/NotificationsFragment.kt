package com.chiki.dinamicbottomnav.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.chiki.dinamicbottomnav.R
import com.chiki.dinamicbottomnav.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {

    //ViewModel
    private lateinit var notificationsViewModel: NotificationsViewModel

    //Binding
    private var _binding: FragmentNotificationsBinding? = null
    private val binding get() = _binding!!

    //Lifecycle
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        notificationsViewModel = ViewModelProvider(this)[NotificationsViewModel::class.java]        //Initialize ViewModel

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)         //Initialize Binding
        val root: View = binding.root

        val textView: TextView = binding.textNotifications
        notificationsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}