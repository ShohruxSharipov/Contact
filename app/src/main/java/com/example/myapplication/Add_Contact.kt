package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.contact.R
import com.example.contact.databinding.FragmentAddContactBinding
import com.example.myapplication.DB.AppDatabase.AppDatabase
import com.example.myapplication.DB.Entity.ContactEn
import com.example.myapplication.User.User

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Add_Contact.newInstance] factory method to
 * create an instance of this fragment.
 */
class Add_Contact : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    val appDatabase:AppDatabase by lazy {
        AppDatabase.getInstanse(requireContext())
    }


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
        val binding = FragmentAddContactBinding.inflate(inflater,container,false)
        binding.done.setOnClickListener {
            if (binding.cNumber.text!!.isEmpty() || binding.cName.text!!.isEmpty() || binding.cSurname.text!!.isEmpty()){
                Toast.makeText(requireContext(), "Fill ALL !", Toast.LENGTH_SHORT).show()
            }else{
                val name = binding.cName.text.toString()
                val number = binding.cNumber.text.toString()
                appDatabase.getContactDao().addContact(ContactEn(name = name, number = number))
                parentFragmentManager.beginTransaction().replace(R.id.main_activity,MainFragment()).commit()
            }
        }
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Add_Contact.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Add_Contact().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}