package com.summercompany.tareas.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.summercompany.tareas.data.Task
import com.summercompany.tareas.data.TaskDAO

class TaskActivity : AppCompatActivity(){

    lateinit var  binding: ActivityTaskBinding

    lateinit var taskDAO: TaskDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_task)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        taskDAO= TaskDAO(this)

        binding.saveButton.setOnClickListener{
            val title = binding.titleEditText.text.toString()

            val task = Task(-1, title)

            taskDAO.insert(task)
            finish()

        }




    }
}