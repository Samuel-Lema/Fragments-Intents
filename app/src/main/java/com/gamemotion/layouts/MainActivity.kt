package com.gamemotion.layouts

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast
import org.jetbrains.anko.browse

import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.browse
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    private lateinit var btnStart: Button

    private var horizontal: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.setTitle("Layout ")

        this.btnStart = findViewById(R.id.btnStart)

        // Si existe el elemento 'TextV' es que esta en vertical. Si no existe esta en horizontal
        if (textV == null) {

            horizontal = true
        }

        // Listener del botón. Si esta en Horizontal muestra -> "Muestro texto cuando esta horizontal"
        // Si esta en Vertical muestro la otra activity (Activity Other)

        btnStart.setOnClickListener() {

            if (horizontal) {

                // Muestro un Toast que dice que esta en horizontal

                Toast.makeText(applicationContext, "Muestro texto cuando esta horizontal", Toast.LENGTH_SHORT).show()

                //Lanzo el fragment. Y le mando 2 parametros

                supportFragmentManager
                    .beginTransaction()
                    .add(R.id.espacio,FragmentoDescripcion.newInstance("Texto1","Texto2") , "espacio")
                    .commit()
            } else {

                val intent = Intent(this, OtherActivity::class.java)

                val valor = intent.getIntExtra("id", 0)
                Toast.makeText(applicationContext, valor.toString(), Toast.LENGTH_SHORT).show()

                startActivity(intent)
            }
        }
    }
}
