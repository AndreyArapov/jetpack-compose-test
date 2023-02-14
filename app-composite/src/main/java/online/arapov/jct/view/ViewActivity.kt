package online.arapov.jct.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import online.arapov.jct.Image
import online.arapov.jct.R

class ViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rv = findViewById<RecyclerView>(R.id.rv)
        val adapter = ImageAdapter()
        rv.adapter = adapter

        adapter.submitList(Image.LIST_IMAGES)
    }
}