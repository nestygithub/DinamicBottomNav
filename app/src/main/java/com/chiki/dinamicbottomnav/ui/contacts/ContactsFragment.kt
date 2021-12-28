package com.chiki.dinamicbottomnav.ui.contacts

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.chiki.dinamicbottomnav.R
import com.chiki.dinamicbottomnav.databinding.ContactsFragmentBinding
import com.chiki.dinamicbottomnav.databinding.FragmentDashboardBinding
import com.chiki.dinamicbottomnav.ui.dashboard.DashboardViewModel

class ContactsFragment : Fragment() {

    //ViewModel
    private lateinit var contactsViewModel: ContactsViewModel

    //Binding
    private var _binding: ContactsFragmentBinding? = null
    private val binding get() = _binding!!

    //Lifecycle
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        contactsViewModel = ViewModelProvider(this)[ContactsViewModel::class.java]        //Initialize ViewModel

        _binding = ContactsFragmentBinding.inflate(inflater, container, false)         //Initialize Binding
        val root: View = binding.root

        val textView: TextView = binding.textContacts
        contactsViewModel.text.observe(viewLifecycleOwner){
            textView.text = it
        }
        return root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}