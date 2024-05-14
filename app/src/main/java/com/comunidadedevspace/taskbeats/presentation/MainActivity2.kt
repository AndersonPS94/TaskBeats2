package com.comunidadedevspace.taskbeats.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.comunidadedevspace.taskbeats.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavView = findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        val floatingActionButton =findViewById<FloatingActionButton>(R.id.floatingActionButton)

        floatingActionButton.setOnClickListener {
            openTaskListDetail()
        }

        val taskListFragment = TaskListFragment.newInstance()
        val newsListFragment = NewsListFragment.newInstance()

        supportFragmentManager.commit {
            replace(R.id.fragment_container_view, taskListFragment)
            setReorderingAllowed(true)
        }

        bottomNavView.setOnItemReselectedListener { menuItem ->
            val fragment = when (menuItem.itemId) {
                R.id.task_list -> taskListFragment
                R.id.news_list -> newsListFragment
                else -> taskListFragment
            }

            supportFragmentManager.commit {
                replace(R.id.fragment_container_view, fragment)
                setReorderingAllowed(true)
            }
            true

        }

    }
    private fun openTaskListDetail ()
    {
        val intent = TaskDetailActivity.start(this, null)
        startActivity(intent)
    }
}

