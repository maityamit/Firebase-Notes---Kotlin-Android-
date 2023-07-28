package practicekotlin_notebook.example.notebook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val createNewNotesACT = findViewById<Button>(R.id.create_newNotes)
        val opensaveNotesACT  = findViewById<Button>(R.id.show_allTheNotes)
        createNewNotesACT.setOnClickListener{
            val intent = Intent(this, CreateNewNotes::class.java)
            startActivity(intent)
        }
        opensaveNotesACT.setOnClickListener{
            val intent = Intent(this, ViewAllNotes::class.java)
            startActivity(intent)
        }
    }
}