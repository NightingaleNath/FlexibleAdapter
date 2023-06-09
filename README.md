# **FlexibleAdapter**

[![](https://jitpack.io/v/NightingaleNath/FlexibleAdapter.svg)](https://jitpack.io/#NightingaleNath/FlexibleAdapter)

# **Description**

FlexibleAdapter is a powerful RecyclerView adapter library for Android that provides advanced features and customization options. It simplifies the development of flexible and efficient RecyclerViews by offering a range of functionalities, including multi-selection, expandable items, swipe gestures, drag and drop support, and easy customization.

To get a Git project into your build:

Step 1. Add the JitPack repository to your build file

```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

Step 2. Add the dependency

```
dependencies {
	    implementation 'com.github.NightingaleNath:FlexibleAdapter:<latest-version>'
	}
```

**USAGE**

1. activity_main.xml
```
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="16dp">

    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/recyclerView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:listitem="@layout/item_layout"
        tools:itemCount="20"/>

</RelativeLayout>

```

2. sample item_layout.xml

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="vertical"
    android:padding="16dp">

    <TextView
        android:id="@+id/titleTextView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:textSize="18sp"
        android:textStyle="bold" />

    <TextView
        android:id="@+id/descriptionTextView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:textSize="14sp" />

</LinearLayout>

```

3. MainActivity.kt - can be any activity or fragment:

```
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
```

## Author

Developed and Maintained by ([Nathaniel Nkrumah](https://github.com/NightingaleNath/FlexibleAdapter))



