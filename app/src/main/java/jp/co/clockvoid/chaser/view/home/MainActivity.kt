package jp.co.clockvoid.chaser.view.home

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import dagger.hilt.android.AndroidEntryPoint
import jp.co.clockvoid.chaser.R
import jp.co.clockvoid.chaser.data.repository.PreferenceStorage
import jp.co.clockvoid.chaser.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

data class BottomNavigationBarItems(@IdRes val itemId: Int, val isVisible: Boolean)

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var preferenceStorage: PreferenceStorage
    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        ) as ActivityMainBinding
    }

    override fun onStart() {
        super.onStart()

        val menuItems = listOf(
            BottomNavigationBarItems(R.id.cigaretteFragment, preferenceStorage.isCigaretteVisible),
            BottomNavigationBarItems(R.id.alcoholFragment, preferenceStorage.isAlcoholVisible),
            BottomNavigationBarItems(R.id.caffeineFragment, preferenceStorage.isCaffeineVisible)
        )

        binding.homeBottomNavigation.menu.clear()
        menuInflater.inflate(R.menu.home_bottom_navigation_menu, binding.homeBottomNavigation.menu)

        binding.homeBottomNavigation.isGone = menuItems.filter { it.isVisible }.size == 1

        menuItems.forEach { item ->
            if (item.isVisible.not()) {
                binding.homeBottomNavigation.menu
                    .removeItem(item.itemId)
            }
        }

        val navHostFragment = navHostFragment as NavHostFragment
        val inflater = navHostFragment.navController.navInflater
        val navGraph = inflater.inflate(R.navigation.nav_graph_home).apply {
            val firstVisibleItem = menuItems.find { item -> item.isVisible }
            val lastShownItem = preferenceStorage.lastShownFragment
            requireNotNull(firstVisibleItem)
            startDestination = if (lastShownItem == -1) firstVisibleItem.itemId else lastShownItem
        }
        navHostFragment.navController.graph = navGraph
        NavigationUI.setupWithNavController(
            binding.homeBottomNavigation, findNavController(
                R.id.navHostFragment
            )
        )
    }

    override fun onStop() {
        super.onStop()

        preferenceStorage.lastShownFragment = binding.homeBottomNavigation.selectedItemId
    }

    override fun onDestroy() {
        super.onDestroy()

        _binding = null
    }
}
