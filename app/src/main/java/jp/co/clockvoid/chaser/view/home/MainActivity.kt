package jp.co.clockvoid.chaser.view.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import dagger.hilt.android.AndroidEntryPoint
import jp.co.clockvoid.chaser.R
import jp.co.clockvoid.chaser.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        ) as ActivityMainBinding
        binding.homeBottomNavigation.menu
            .removeItem(R.id.cigaretteFragment)
        binding.homeBottomNavigation.selectedItemId = R.id.alcoholFragment
        val navHostFragment = navHostFragment as NavHostFragment
        val inflater = navHostFragment.navController.navInflater
        val navGraph = inflater.inflate(R.navigation.nav_graph_home).apply {
            startDestination = R.id.alcoholFragment
        }
        navHostFragment.navController.graph = navGraph
        NavigationUI.setupWithNavController(
            binding.homeBottomNavigation, findNavController(
                R.id.navHostFragment
            )
        )
    }
}
