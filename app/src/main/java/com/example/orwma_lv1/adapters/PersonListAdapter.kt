package com.example.orwma_lv1.adapters

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.orwma_lv1.R
import com.example.orwma_lv1.models.Person

class PersonListAdapter(private val personList:List<Person> = mutableListOf()) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = (
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.person_sample,parent,false))
            )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).onBind(personList[position])
    }

    override fun getItemCount(): Int = (personList.size)

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        var tvName:TextView = itemView.findViewById(R.id.tvName)
        var tvDate:TextView = itemView.findViewById(R.id.tvDate)
        var tvDescription:TextView = itemView.findViewById(R.id.tvDescription)
        var ivPerson:ImageView = itemView.findViewById(R.id.ivPerson)

        fun onBind(person:Person){
            tvName.text = person.name
            tvDate.text = person.date
            tvDescription.text = person.description
            ivPerson.setImageResource(person.image)
            ivPerson.setOnClickListener {
                ivPerson.setImageResource(0)
            }
        }

    }
}