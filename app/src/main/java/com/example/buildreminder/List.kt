package com.example.buildreminder

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.medicine.R
import com.example.medicine.databinding.ActivityListBinding
import java.text.SimpleDateFormat
import java.util.*

class List : AppCompatActivity() {
    private lateinit var binding: ActivityListBinding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var adapter: MedicineAdapter
    private var medicines = mutableListOf<Medicine>()

    @SuppressLint("SetTextI18n", "SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = getSharedPreferences("MedicinePrefs", Context.MODE_PRIVATE)

        binding.btnNext2.setOnClickListener {
            val intent2 = Intent(this, Out::class.java)
            startActivity(intent2)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        loadMedicines()

        binding.calendarView.date = Calendar.getInstance().timeInMillis

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        adapter = MedicineAdapter(medicines) { position ->
            removeMedicine(position)
        }

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun loadMedicines() {
        val medicineCount = sharedPreferences.getInt("medicineCount", 0)
        val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm")
        for (i in 0 until medicineCount) {
            val title = sharedPreferences.getString("title_$i", "Unknown Title")
            val message = sharedPreferences.getString("message_$i", "Unknown Message")
            val date = sharedPreferences.getLong("date_$i", 0L)
            val formattedDate = dateFormat.format(Date(date))

            medicines.add(Medicine(title!!, message!!, formattedDate))
        }
    }

    private fun removeMedicine(position: Int) {
        medicines.removeAt(position)
        adapter.notifyItemRemoved(position)
        saveMedicines()
    }

    private fun saveMedicines() {
        val editor = sharedPreferences.edit()
        editor.putInt("medicineCount", medicines.size)
        for (i in medicines.indices) {
            val medicine = medicines[i]
            editor.putString("title_$i", medicine.title)
            editor.putString("message_$i", medicine.message)
            editor.putLong("date_$i", SimpleDateFormat("dd/MM/yyyy HH:mm").parse(medicine.date).time)
        }
        editor.apply()
    }

    override fun onResume() {
        super.onResume()
        // Fetch the latest medicines data here if needed
    }
}