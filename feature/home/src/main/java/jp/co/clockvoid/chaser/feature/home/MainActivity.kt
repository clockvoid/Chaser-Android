package jp.co.clockvoid.chaser.feature.home

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import dagger.android.support.DaggerAppCompatActivity
import jp.co.clockvoid.chaser.feature.home.databinding.ActivityMainBinding

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView(this, R.layout.activity_main) as ActivityMainBinding
        NavigationUI.setupWithNavController(binding.homeBottomNavigation, findNavController(R.id.navHostFragment))
    }
}
