package com.example.aboutmep2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.aboutmep2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName1: MyName = MyName("Joe Lynne") //jave= private myName myName = new myNmae()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //setContentView(R.layout.activity_main)

        binding.myName= myName1 //1st myname refer to xml file, 2nd is refer to the top val

        binding.doneButton.setOnClickListener {
            addnickname(it)
        }
        binding.nicknameText.setOnClickListener {
            updateNickname(it)
        }
    }
    private fun addnickname(view : View) {

        //val editText = findViewById<EditText>(R.id.nickname_edit)
        //val nicknameTextView = findViewById<TextView>(R.id.nickname_text)
        myName1?.nickname = binding.nicknameEdit.text.toString()
        binding.invalidateAll()

        binding.nicknameEdit.visibility= View.GONE

        view.visibility = View.GONE

        binding.nicknameText.visibility = View.VISIBLE

        // Hide the keyboard.
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
    private fun updateNickname (view: View) {
        //val editText = findViewById<EditText>(R.id.nickname_edit)
        //val doneButton = findViewById<Button>(R.id.done_button)

        binding.nicknameEdit.visibility = View.VISIBLE
        binding.doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE

        // Set the focus to the edit text.
        binding.nicknameEdit.requestFocus()

        // Show the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(binding.nicknameEdit, 0)
    }
}