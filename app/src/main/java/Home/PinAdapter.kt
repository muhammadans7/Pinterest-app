package Home

import com.example.pinterest.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PinAdapter(private val pinList: List<Pin>) : RecyclerView.Adapter<PinAdapter.PinViewHolder>() { // Use your Pin class here

    class PinViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pinImage: ImageView = itemView.findViewById(R.id.pinImage)
        val pinTitle: TextView = itemView.findViewById(R.id.pinTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PinViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pin, parent, false)
        return PinViewHolder(view)
    }

    override fun onBindViewHolder(holder: PinViewHolder, position: Int) {
        val pin = pinList[position]
        holder.pinTitle.text = pin.title
        holder.pinImage.setImageResource(pin.imageResId)
    }

    override fun getItemCount(): Int {
        return pinList.size
    }
}

