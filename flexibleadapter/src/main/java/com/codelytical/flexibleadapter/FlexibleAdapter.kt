package com.codelytical.flexibleadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class FlexibleAdapter<T>(
	private val items: List<T>,
	private val layoutResId: Int,
	private val bindHolder: (holder: FlexibleAdapter<T>.ViewHolder, item: T) -> Unit,
	private val onItemClick: ((item: T) -> Unit)? = null
) : RecyclerView.Adapter<FlexibleAdapter<T>.ViewHolder>() {

	// Create the ViewHolder for the item view
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		val view = try {
			// Inflate the item layout using the provided layout resource ID
			LayoutInflater.from(parent.context).inflate(layoutResId, parent, false)
		} catch (e: Exception) {
			// Handle the error, either throw an exception or provide a default layout
			throw IllegalArgumentException("Invalid layout resource ID: $layoutResId")
		}
		return ViewHolder(view)
	}

	// Bind data to the ViewHolder
	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		val item = items[position]
		bindHolder(holder, item)
		holder.itemView.setOnClickListener {
			onItemClick?.invoke(item)
		}
	}

	// Get the total number of items
	override fun getItemCount(): Int {
		return items.size
	}

	// ViewHolder class for the item view
	inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
