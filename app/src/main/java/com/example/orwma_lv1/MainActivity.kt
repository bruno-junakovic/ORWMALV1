package com.example.orwma_lv1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.core.view.isEmpty
import androidx.core.view.isNotEmpty
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.orwma_lv1.adapters.PersonListAdapter
import com.example.orwma_lv1.models.Person
import com.example.orwma_lv1.utilities.toast

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView : RecyclerView
    private var adapter = PersonListAdapter()
    var personList = mutableListOf<Person>()
    var quoteList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupPersonList()
        adapter = PersonListAdapter(personList)
        setupRecycler()
        quotesList()

        val rgRadioGroup : RadioGroup = findViewById(R.id.rgRadioGroup)
        val rbElon : RadioButton = findViewById(R.id.rbElon)
        val rbNeil : RadioButton = findViewById(R.id.rbNeil)
        val rbMuhammad : RadioButton = findViewById(R.id.rbMuhammad)
        val buEditDescription : Button = findViewById(R.id.buEditDescription)

        buEditDescription.setOnClickListener {
            if(rgRadioGroup.isNotEmpty())(editDescription(rbCheck(rgRadioGroup),rbElon,rbNeil,rbMuhammad))
        }

        val buInspiration = findViewById<Button>(R.id.buInspiration)
        buInspiration.setOnClickListener {
            toast(randomQuote())
        }

    }

    private fun setupRecycler(){
        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun setupPersonList(){
        var elonMusk = Person("Elon Musk", "1971 -", "Elon Reeve Musk FRS is a business magnate, industrial designer and engineer. He is the founder, CEO, CTO and chief designer of SpaceX; early investor, CEO and product architect of Tesla, Inc.", R.drawable.elon)
        var neilDeGrasseTyson = Person("Neil deGrasse Tyson", "1958 -", "Neil deGrasse Tyson is an American astrophysicist, planetary scientist, author, and science communicator. Since 1996, he has been the Frederick P. Rose Director of the Hayden Planetarium at the Rose Center for Earth and Space in New York City.", R.drawable.neil)
        var muhammadAli = Person("Muhammad Ali","1942 - 2016","Muhammad Ali was an American professional boxer, activist and philanthropist. Nicknamed \"the Greatest\", he is widely regarded as one of the most significant and celebrated figures of the 20th century and as one of the greatest boxers of all time.", R.drawable.muhammad)
        personList.add(elonMusk)
        personList.add(neilDeGrasseTyson)
        personList.add(muhammadAli)

    }

    private fun randomQuote() :String{
        return quoteList.random()
    }

    private fun quotesList(){
        quoteList.add(getString(R.string.elon_quote1))
        quoteList.add(getString(R.string.elon_quote2))
        quoteList.add(getString(R.string.neil_quote1))
        quoteList.add(getString(R.string.neil_quote2))
        quoteList.add(getString(R.string.muhammad_quote1))
        quoteList.add(getString(R.string.muhammad_quote2))
    }

    private fun rbCheck(rgRadioGroup: RadioGroup) : RadioButton {
        return findViewById<RadioButton>(rgRadioGroup.checkedRadioButtonId)
    }

    private fun editDescription(rbSelected : RadioButton,rbElon:RadioButton, rbNeil : RadioButton, rbMuhammad : RadioButton){
        var etEditDescription :EditText = findViewById(R.id.etEditDescription)

        if (rbSelected == rbElon){
            personList[0].description = etEditDescription.text.toString()
        }else if(rbSelected == rbNeil){
            personList[1].description = etEditDescription.text.toString()
        }
        else{
            personList[2].description = etEditDescription.text.toString()
        }
        setupRecycler()
    }


}