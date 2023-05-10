package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.contact.R
import com.example.contact.databinding.FragmentMainBinding
import com.example.myapplication.DB.AppDatabase.AppDatabase
import com.example.myapplication.User.User

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class MainFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    val appDatabase: AppDatabase by lazy {
        AppDatabase.getInstanse(requireContext())
    }
    var user_list = mutableListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMainBinding.inflate(inflater,container,false)

        val db = appDatabase.getContactDao().getAll()
        val adapter = com.example.myapplication.Adapter.Adapter(db)
        binding.contactList.adapter = adapter

        binding.addContact.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.main_activity,Add_Contact()).commit()
        }

        return binding.root
    }
    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    fun add_list():MutableList<User>{


        return user_list
    }
}