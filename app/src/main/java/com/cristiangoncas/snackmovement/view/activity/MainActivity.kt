package com.cristiangoncas.snackmovement.view.activity

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.cristiangoncas.snackmovement.R
import com.cristiangoncas.snackmovement.databinding.ActivityMainBinding
import com.cristiangoncas.snackmovement.view.fragment.FragmentMovementArgs

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var startingSnack: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val host: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment?
                ?: return
        val navController = host.navController
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id != R.id.fragmentHome &&
                destination.id != R.id.fragmentMovements &&
                destination.id != R.id.fragmentStatistics
            ) {
                binding.bottomMenu.visibility = View.GONE
            } else {
                binding.bottomMenu.visibility = View.VISIBLE
            }
            if (
                (destination.id == R.id.fragmentMovements ||
                        destination.id == R.id.fragmentMovementDetail ||
                        destination.id == R.id.fragmentSnackInProgress) &&
                startingSnack
            ) {
//                binding.newSnack.visibility = View.GONE
            } else {
//                binding.newSnack.visibility = View.VISIBLE
                startingSnack = false
            }
        }

        binding.bottomMenu.setupWithNavController(navController)
        binding.newSnack.setOnClickListener {
            startingSnack = true
            val args = FragmentMovementArgs(startingSnack = startingSnack).toBundle()
            navController
                .navigate(R.id.fragmentMovements, args)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return true
    }
    override fun onBackPressed() {
        if (!findNavController(R.id.nav_host_fragment).navigateUp())
            super.onBackPressed()
    }
}
