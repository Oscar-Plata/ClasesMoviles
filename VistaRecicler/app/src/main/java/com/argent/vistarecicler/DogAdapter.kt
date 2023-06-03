package com.argent.vistarecicler
import Dog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DogAdapter(val dogList: ArrayList<Dog>) :
    RecyclerView.Adapter<DogAdapter.DogViewHolder>() {

    var onItemClick:((Dog)->Unit)?=null
    // Describes an item view and its place within the RecyclerView
    class DogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val dogTextView: TextView = itemView.findViewById(R.id.dog_text)
        private val dogImage: ImageView = itemView.findViewById(R.id.dog_image)

        fun bind(word: String,image: Int) {
            dogTextView.text = word
            dogImage.setImageResource(image)
        }
    }

    // Returns a new ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.dog_item, parent, false)

        return DogViewHolder(view)
    }

    // Returns size of data list
    override fun getItemCount(): Int {
        return dogList.size
    }

    // Displays data at a certain position
    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        var dogItem=dogList[position]
        holder.bind(dogItem.nombre!!,dogItem.imagen)
        holder.itemView.setOnClickListener{
            onItemClick?.invoke(dogItem)
        }
    }
}