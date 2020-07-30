package jp.co.clockvoid.chaser.view.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import dagger.hilt.android.AndroidEntryPoint
import jp.co.clockvoid.chaser.R
import jp.co.clockvoid.chaser.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        ) as ActivityMainBinding
        NavigationUI.setupWithNavController(binding.homeBottomNavigation, findNavController(
            R.id.navHostFragment
        ))
    }
}
