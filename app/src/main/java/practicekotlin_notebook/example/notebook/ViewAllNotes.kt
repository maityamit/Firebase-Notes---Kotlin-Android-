package practicekotlin_notebook.example.notebook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class ViewAllNotes : AppCompatActivity() {

    var firedatabase : FirebaseDatabase? = null
    var BalList : ArrayList<BalInputDTO> ? = null
    var ref : DatabaseReference? = null
    var mRecyclerView : RecyclerView? =null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_all_notes)
        firedatabase = FirebaseDatabase.getInstance()


        mRecyclerView = findViewById(R.id.recyler_View)
        mRecyclerView?.setHasFixedSize(true)
        mRecyclerView?.layoutManager = LinearLayoutManager(this)
        BalList = arrayListOf<BalInputDTO>()
        ref = FirebaseDatabase.getInstance().getReference()
        ref?.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(p0: DataSnapshot) {
                if(p0!!.exists()){
                    for (h in p0.children){
                        val bal = h.getValue(BalInputDTO::class.java)
                        BalList?.add(bal!!)
                    }
                    val adapter = BalAdapter(this@ViewAllNotes, BalList!!)
                    mRecyclerView?.setAdapter(adapter)
                }
            }
        })
    }
}