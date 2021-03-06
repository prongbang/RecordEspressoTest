package com.krungsri.recordespressotest.ui.main

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.krungsri.recordespressotest.R

class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
	}

	companion object {
		fun navigate(activity: Activity) {
			activity.startActivity(Intent(activity, MainActivity::class.java))
		}
	}
}