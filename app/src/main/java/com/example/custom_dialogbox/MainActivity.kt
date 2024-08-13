package com.example.custom_dialogbox

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val dialogButton: Button = findViewById(R.id.dialog_button)

        val dialog = Dialog(this)
        dialog.setContentView(R.layout.custom_alert_box)
        dialog.window?.setBackgroundDrawable(AppCompatResources.getDrawable(this,R.drawable.background_alerbox))

        val happyButton: Button = dialog.findViewById(R.id.happyButton)
        val doubtButton: Button = dialog.findViewById(R.id.doubtButton)

        happyButton.setOnClickListener {
            Toast.makeText(this,"Clicked on  Happy Button",Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        doubtButton.setOnClickListener {
            Toast.makeText(this,"Clicked on Doubt button",Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }

        dialogButton.setOnClickListener {
            dialog.show()
        }


    }
}