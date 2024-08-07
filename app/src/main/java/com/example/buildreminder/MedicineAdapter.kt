package com.example.buildreminder


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.medicine.R

// تأكد من استخدام List من حزمة kotlin.collections
import kotlin.collections.List

class MedicineAdapter(
    private val medicines: List<Medicine>,
    private val onDeleteClick: (Int) -> Unit
) : RecyclerView.Adapter<MedicineAdapter.MedicineViewHolder>() {

    inner class MedicineViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.medicineTitle)
        val messageTextView: TextView = itemView.findViewById(R.id.medicineMessage)
        val dateTextView: TextView = itemView.findViewById(R.id.medicineDate)
        val deleteButton: Button = itemView.findViewById(R.id.deleteButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicineViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_medicine, parent, false)
        return MedicineViewHolder(view)
    }

    override fun onBindViewHolder(holder: MedicineViewHolder, position: Int) {
        val medicine = medicines[position]
        holder.titleTextView.text = medicine.title
        holder.messageTextView.text = medicine.message
        holder.dateTextView.text = medicine.date

        holder.deleteButton.setOnClickListener {
            onDeleteClick(position)
        }
    }

    override fun getItemCount(): Int = medicines.size
}