package com.mentoriaandroid.aulacomponentesinterfaceviewbinding

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mentoriaandroid.aulacomponentesinterfaceviewbinding.databinding.ActivityNovaBinding
import com.mentoriaandroid.aulacomponentesinterfaceviewbinding.databinding.ActivityToolbarActionbarBinding

class NovaActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityNovaBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        inicializarToolbar()
    }

    private fun inicializarToolbar() {

        binding.includeToolBar.clLogo.visibility = View.GONE
        binding.includeToolBar.tbPrincipal.title = "Upload Vídeo"
        setSupportActionBar( binding.includeToolBar.tbPrincipal )

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
}