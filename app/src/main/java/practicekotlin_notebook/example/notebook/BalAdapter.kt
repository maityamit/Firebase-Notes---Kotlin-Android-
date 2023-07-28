package practicekotlin_notebook.example.notebook

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class BalAdapter(val context: Context, val BalList: ArrayList<BalInputDTO>) :
    RecyclerView.Adapter<BalAdapter.Holder>() {

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bind(BalList[position], context)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.dummy_view, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return BalList.size
    }


    inner class Holder(view: View?) : RecyclerView.ViewHolder(view!!) {
        val recordCategory = view?.findViewById<TextView>(R.id.adapter_text)
        fun bind(bal: BalInputDTO, context: Context) {
            recordCategory?.text = bal.data
        }
    }
}