package com.example.firstroomdbproject.view_layer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.firstroomdbproject.database.AppDatabase
import com.example.firstroomdbproject.database.entities.User
import com.example.firstroomdbproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = AppDatabase.getInstance(applicationContext)
        binding.apply {

            //insert into DB------------------------------------------------------------------
            insert.setOnClickListener {
                db.userDao().insertUser(
                    User(
                        edtFirstName.text.toString(),
                        edtLastName.text.toString(),
                        "lastname",
                        "full name"
                    )
                )
                Toast.makeText(this@MainActivity, "Added", Toast.LENGTH_SHORT).show()
                edtFirstName.text?.clear()
                edtLastName.text?.clear()
            }

            //Select from DB -----------------------------------------------------------------
            select.setOnClickListener {
                val list = db.userDao().getUsers()
                txtFirstName.text = list[0].firstName
                txtLastName.text = list[0].lastName
            }

            //Update from DB ----------------------------------------------------------------
            update.setOnClickListener {
                db.userDao().updateUser(
                    User(
                        edtFirstName.text.toString(),
                        edtLastName.text.toString(),
                        "lastname",
                        "fullname"
                    )
                )
                edtFirstName.text?.clear()
                edtLastName.text?.clear()
            }

            //Delete from DB-----------------------------------------------------------------
            delete.setOnClickListener {
                db.userDao().deleteById(2)
                txtFirstName.text = ""
                txtLastName.text = ""
            }
        }
    }
}