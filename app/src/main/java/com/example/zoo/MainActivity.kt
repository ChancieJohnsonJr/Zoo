package com.example.zoo

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zoo.Animal
import com.example.zoo.AnimalAdapter
import com.example.zoo.R
import kotlinx.android.synthetic.main.activity_description.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_recycler.*


class MainActivity : AppCompatActivity() {
    //by List initializes the value whenever the value is first called upon
    val animalList by lazy { popluateList()}
    val adapter by lazy { AnimalAdapter(animalList)}
    //val drawable: Drawable? = ResourcesCompat.getDrawable(resources, R.drawable.zooimage, null)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val adapter = AnimalAdapter(animalList)
        val layoutManager = LinearLayoutManager( this, LinearLayoutManager.VERTICAL,  false)
        val itemDecoration = DividerItemDecoration( this, DividerItemDecoration.VERTICAL)
        rvAnimalList.layoutManager = layoutManager
        rvAnimalList.adapter = adapter
    }

    private fun popluateList() : ArrayList<Animal> {
        val returnList = ArrayList<Animal>()
        returnList.add(Animal("Brown","Large", "260 pounds"))
        returnList.add(Animal("White","Medium","70 pounds"))
        returnList.add(Animal("Green","Small", "12 pounds"))
        returnList.add(Animal("Brown","Small", "19 pounds"))
        returnList.add(Animal("Red",  "Large", "170 pounds"))
        returnList.add(Animal("Orange","Medium","82 pounds"))
        returnList.add(Animal("Blue",  "Small", "15 pounds"))
        returnList.add(Animal("Yellow","Large", "192 pounds"))
        returnList.add(Animal("Black", "Medium","160 pounds"))
        returnList.add(Animal("Purple","Large", "210 pounds"))


        return returnList
    }

    fun onClick(view: View) {
        val color = tvColor.text.toString()
        val size = tvSize.text.toString()
        val weight = tvWeight.text.toString()
        val animalToAdd = Animal(color, size, weight)
        adapter.addAnimalToList(animalToAdd)
    }
}

