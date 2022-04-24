package com.pramod.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.RadioButton
import android.widget.Toast
import com.pramod.quiz.R
import com.pramod.quiz.R.menu
import com.pramod.quiz.R.menu.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var radioButton: RadioButton
      public  var score = "Hello"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setQuestionView()
        button1.setOnClickListener{
            quiz()
        }
    }


    fun quiz(){

        val gues = question.text.toString().trim()
        val radioq = radio0.text.toString().trim()

        val selectedOption: Int = radioGroup1.checkedRadioButtonId

         radioButton = findViewById(selectedOption)
         val  radio = radioButton.text.toString()
        if(radio.isEmpty())
        {
            Toast.makeText(getApplicationContext(), "Please select Gender", Toast.LENGTH_SHORT).show();
            Log.d("QAOD", "Gender is Null");
        }
        else
        {
            Log.d("QAOD", "Gender is Selected");
        }


        Toast.makeText(applicationContext,radio, Toast.LENGTH_LONG).show()

        val intent = Intent(this, QuizActivity::class.java)
        val b = Bundle()

      //  b.putInt("score", score); //Your score
        //intent.putExtras(b); //Put your score to your next Intent
        startActivity(intent)
        finish()



    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.game_menu,menu)

        return true

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                // Action goes here
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setQuestionView(){
        question.text="Q 1 Who is java develop?"
        radio0.text="James Gousline"
        radio1.text="Radio Guid"
        radio2.text="Andy"
        radio3.text="Python"


    }
}

