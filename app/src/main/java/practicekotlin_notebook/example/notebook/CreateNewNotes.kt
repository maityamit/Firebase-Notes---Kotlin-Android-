package practicekotlin_notebook.example.notebook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase


class CreateNewNotes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_notes)
        val submitButton= findViewById<Button>(R.id.submit_enter_text)
        val enterEditeText  = findViewById<EditText>(R.id.enter_the_text)
        submitButton.setOnClickListener{
            val getString = enterEditeText.text.toString()
            Helper(getString)
            enterEditeText.getText().clear();
        }
    }
    fun Helper(str : String){
        val database: FirebaseDatabase = FirebaseDatabase.getInstance()
        val dataRef: DatabaseReference = database.getReference()
        val newRef: DatabaseReference = dataRef.push()
        newRef.child("data").setValue(str).addOnSuccessListener {
            Toast.makeText(applicationContext, "Added Data", Toast.LENGTH_LONG).show()
        }
    }
}