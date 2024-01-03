package com.cristiangoncas.snackmovement.view.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
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
            if ((
                    destination.id == R.id.fragmentMovements ||
                        destination.id == R.id.fragmentMovementDetail ||
                        destination.id == R.id.fragmentSnackInProgress
                    ) && startingSnack
            ) {
                binding.newSnack.visibility = View.GONE
            } else {
                binding.newSnack.visibility = View.VISIBLE
                startingSnack = false
            }
        }
        binding.newSnack.setOnClickListener {
            startingSnack = true
            val args = FragmentMovementArgs(startingSnack = startingSnack).toBundle()
            navController
                .navigate(R.id.fragmentMovements, args)
        }
    }
}
