package com.examples.coding.containerviewsdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import com.example.zoo.Animal
import com.example.zoo.Key_ANIMAL
import com.example.zoo.R
import kotlinx.android.synthetic.main.activity_description.*
import kotlinx.android.synthetic.main.activity_species.*
import kotlinx.android.synthetic.main.activity_description.tvColor
import kotlinx.android.synthetic.main.activity_description.tvSize
import kotlinx.android.synthetic.main.activity_description.tvWeight

class PersonDetailsActivity : AppCompatActivity() {
    val list by lazy { initList() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)

        val passedPerson = intent?.getParcelableExtra<Animal>(Key_ANIMAL)
        //Elvis operator (?:) - tenerary operator - checks if value is null, if is null return
        // value to the right
        // passedPerson.getFirstName() != null ? passedPerson.getFirstName() : "no first name"
        tvColor.text = passedPerson?.color ?: "No Color"
        tvSize.text = passedPerson?.size ?: "No Size"
        tvWeight.text = passedPerson?.weight ?: "No Weight"
        initListView()
    }

    fun initListView() {
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list)
        lvListView.adapter = adapter
        lvListView.setOnItemClickListener { _, _, i, _ ->
            val selectedString = list[i]
            val intent = Intent("MAKE>THE>INTENT")
            intent.putExtra("KEY", selectedString)
            startActivity(intent)

        }
    }

    fun initList() : ArrayList<String>{
        val stringList = ArrayList<String>()

        stringList.add("Mammal")
        stringList.add("Reptile")
        stringList.add("Amphibian")
        stringList.add("Fish")
        stringList.add("Bird")

        return stringList
    }
}

