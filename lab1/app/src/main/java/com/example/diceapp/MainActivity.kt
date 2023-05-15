package com.example.diceapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Starting Dice Roll
        rollDice()

        //RollButton assign
        val rollButton: Button = findViewById(R.id.button2)
        rollButton.setOnClickListener {
            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
            //Calling dice roll logic function
            rollDice()
        }
    }

    //Roll the dice and update the screen with the result.
    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()

        //Assign image and result
        val diceImage: ImageView = findViewById(R.id.imageView)
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_1
        }

        diceImage.setImageResource(drawableResource)
    }
}

/**
 * This activity returns random result in current range ( 1 - (end value))
 */
class Dice(private val numSides: Int) {
    // Roll method that returns random value
    fun roll(): Int {
        return (1..numSides).random()
    }
}