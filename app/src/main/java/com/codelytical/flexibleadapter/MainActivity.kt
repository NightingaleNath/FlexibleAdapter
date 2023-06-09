package com.codelytical.flexibleadapter

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

	private lateinit var recyclerView: RecyclerView
	private lateinit var adapter: FlexibleAdapter<Item>

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		recyclerView = findViewById(R.id.recyclerView)
		recyclerView.layoutManager = LinearLayoutManager(this)

		val items = listOf(
			Item("Title 1", "Description 1"),
			Item("Title 2", "Description 2"),
			Item("Title 3", "Description 3")
		)

		adapter = FlexibleAdapter(items, R.layout.item_layout,
			bindHolder = { holder, item ->
				val titleTextView = holder.itemView.findViewById<TextView>(R.id.titleTextView)
				val descriptionTextView = holder.itemView.findViewById<TextView>(R.id.descriptionTextView)

				titleTextView.text = item.title
				descriptionTextView.text = item.description
			},
			onItemClick = { item ->
				// Handle item click
				Toast.makeText(this, "${item.title} ${item.description}", Toast.LENGTH_SHORT).show()
			}
		)

		recyclerView.adapter = adapter

	}
}