package com.example.gostylecoupon

import android.os.AsyncTask
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gostylecoupon.UsersRecyclerAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.gostylecoupon.DatabaseActivity
import com.example.gostylecoupon.User



class UsersListActivity : AppCompatActivity() {
    private val activity = this@UsersListActivity
    private lateinit var textViewName: AppCompatTextView
    private lateinit var recyclerViewUsers: RecyclerView
    private lateinit var listUsers: MutableList
    private lateinit var usersRecyclerAdapter: UsersRecyclerAdapter
    private lateinit var databaseActivity: DatabaseActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users_list)
        supportActionBar!!.title = ""
        initViews()
        initObjects()
    }
    /**
     * This method is to initialize views
     */
    private fun initViews() {
        textViewName = findViewById(R.id.textViewName) as AppCompatTextView
        recyclerViewUsers = findViewById(R.id.recyclerViewUsers) as RecyclerView
    }
    /**
     * This method is to initialize objects to be used
     */
    private fun initObjects() {
        listUsers = ArrayList()
        usersRecyclerAdapter = UsersRecyclerAdapter(listUsers)
        val mLayoutManager = LinearLayoutManager(applicationContext)
        recyclerViewUsers.layoutManager = mLayoutManager
        recyclerViewUsers.itemAnimator = DefaultItemAnimator()
        recyclerViewUsers.setHasFixedSize(true)
        recyclerViewUsers.adapter = usersRecyclerAdapter
        databaseActivity = DatabaseActivity(activity)
        val emailFromIntent = intent.getStringExtra("EMAIL")
        textViewName.text = emailFromIntent
        var getDataFromSQLite = GetDataFromSQLite()
        getDataFromSQLite.execute()
    }
    /**
     * This class is to fetch all user records from SQLite
     */
    inner class GetDataFromSQLite : AsyncTask<Void, Void, List>() {
        override fun doInBackground(vararg p0: Void?): List {
            return databaseActivity.getAllUser()
        }
        override fun onPostExecute(result: List?) {
            super.onPostExecute(result)
            listUsers.clear()
            listUsers.addAll(result!!)
        }
    }
}