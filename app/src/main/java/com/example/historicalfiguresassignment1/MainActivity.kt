package com.example.historicalfiguresassignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    //List of Historical figures along with there ages
    enum class HistoricalFigures (val age: Int, val description: String ){
        Figure1(56,"You are the same age as Julius Caesar when he died"),
        Figure2(39,"You are 39 which is the same age as Cleopatra VII when she died"),
        Figure3(32,"Your age is the same age when Alexander the Great died"),
        Figure4(52,"You are the same age as William Shakespeare when he died"),
        Figure5(67,"You are 67 which is the same age as Leonardo da Vinci when he died"),
        Figure6(51,"You ae the same age as Napoleon Bonaparte when he died"),
        Figure7(78,"You are 78 which is the same age Mahatma Gandhi when he died"),
        Figure8(84,"Your age is the same age as Isaac Newton when he died"),
        Figure9(95,"You are the same age as Nelson Mandela when he died"),
        Figure10(69,"You are 69 which is the same age as Elizabeth I of England"),


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Getting layout components
        val edtAgeYear = findViewById<EditText>(R.id.edtAge)
        val btnResult = findViewById<Button>(R.id.btnResult)
        val btnClear = findViewById<Button>(R.id.btnClear)
        val txtResult = findViewById<TextView>(R.id.txtResult)

        //if user presses the Display button Result button
        btnResult?.setOnClickListener()
        {
            val ageYear = edtAgeYear.text.toString().toInt()

            if (ageYear != null && ageYear in 20..100){
                //Grabbing the values of the age in the list of HistoricalFigures
                val figureYears = HistoricalFigures.values().map{it.age}

                val figures = when(ageYear){

                    in figureYears->{
                        val figure = HistoricalFigures.values().find { it.age == ageYear }
                        listOf("In $ageYear: ${figure?.description?:"figure"}")

                    }
                    //map function will transform each enum constant into its corresponding age values
                    //this statement will be run if the age year is one age before the historical figure
                    in figureYears.map { it - 1 } ->{
                        val figure = HistoricalFigures.values().find { it.age == ageYear + 1 }
                        listOf("Your age year is one age before the historical figure of" +
                         "${figure?.description ?: "figure"}")
                    }
                    //This statement will be run if the age year is one year after the historical figure
                    in figureYears.map { it + 1 } -> {
                        val figure = HistoricalFigures.values().find { it.age == ageYear - 1 }
                        listOf("Your age year is one age after the historical figure of" +
                        "${figure?.description ?:"figure"}")
                    }
                    //this statement will be run if the age year is not the same or class to the age of
                    else -> listOf("No historical figures found for $ageYear.")

                }
                txtResult.text = figures.joinToString ("\n")
            }
            else
            {

               txtResult.text ="No figure has been found from the input of your age year"
            }
        }
        //if user presses the Clear button
        btnClear?.setOnClickListener(){
            edtAgeYear.text.clear()
            txtResult.text=""
        }

    }
}