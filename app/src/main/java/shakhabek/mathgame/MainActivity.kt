package shakhabek.mathgame

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var edtAnswer: EditText
    private lateinit var tvQuestions: TextView
    private lateinit var btnJavob: Button
    private lateinit var myScore: TextView

    var number1 = 0
    var number2 = 0
    var amal = 0
    var tJavob = 0
    var totalScore = 0
    var correctScore = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtAnswer = findViewById(R.id.answer)
        tvQuestions = findViewById(R.id.question)
        btnJavob = findViewById(R.id.btn_Javob)
        myScore = findViewById(R.id.tv_ball)
        randomMisolYoz()


        btnJavob.setOnClickListener {
            if (edtAnswer.text.toString().isEmpty()) {
                Toast.makeText(this, "Write Answer", Toast.LENGTH_SHORT).show()
            } else {

                if (tJavob.toString().length == edtAnswer.text.toString().length) {
                }
                if (tJavob == edtAnswer.text.toString().toInt()) {
                    correctScore++
                    Toast.makeText(this, "Tog`ri Javob", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "No tog`ri javob", Toast.LENGTH_SHORT).show()
                }
                totalScore++
                randomMisolYoz()
                edtAnswer.text.clear()


            }

        }


    }


    @SuppressLint("SetTextI18n")
    fun randomMisolYoz() {
        number1 = Random.nextInt(20)
        number2 = Random.nextInt(20)
        amal = Random.nextInt(4)
        when (amal) {
            0 -> {
                tvQuestions.text = "$number1+$number2"
                tJavob = number1 + number2
            }
            1 -> {
                if (number1 < number2) {
                    randomMisolYoz()
                    return
                }
                tvQuestions.text = "$number1-$number2"
                tJavob = number1 - number2
            }
            2 -> {
                tvQuestions.text = "$number1*$number2"
                tJavob = number1 * number2
            }
            3 -> {
                try {
                    if (number1 % number2 != 0) {
                        randomMisolYoz()
                        return
                    }
                    tvQuestions.text = "$number1/$number2"
                    tJavob = number1 / number2
                } catch (e: Exception) {
                    randomMisolYoz()
                    return
                }
            }
        }

        myScore.text = "$correctScore / $totalScore"
    }

//    fun myCheecking() {
//        btnJavob.setOnClickListener {
//            if (tJavob == edtAnswer.text.toString().toInt()) {
//                Toast.makeText(this, "Tog`ri Javob", Toast.LENGTH_SHORT).show()
//                randomMisolYoz()
//                edtAnswer.text.clear()
//                val mediaPlayer = MediaPlayer.create(this, R.raw.tru)
//                mediaPlayer.start()
//            } else {
//                Toast.makeText(this, "No tog`ri javob", Toast.LENGTH_SHORT).show()
//                randomMisolYoz()
//                edtAnswer.text.clear()
//                val mediaPlayer = MediaPlayer.create(this, R.raw.fals)
//                mediaPlayer.start()
//            }
//        }
//    }

}