package com.example.povtoreniesfigmya;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.povtoreniesfigmya.databinding.ActivityMain8Binding;
import com.example.povtoreniesfigmya.databinding.ActivityMainBinding;

public class MainActivity8 extends AppCompatActivity {

    ActivityMain8Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain8Binding.inflate(getLayoutInflater());
       // EdgeToEdge.enable(this);
        //setContentView(R.layout.activity_main8);
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        replaceFragment(new HomeFragment());


        binding.boo.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.home) {
                    replaceFragment(new HomeFragment());
            } else if (item.getItemId() == R.id.recept) {
                    replaceFragment(new ReceptFragment());
            } else if (item.getItemId() == R.id.profile) {
                    replaceFragment(new ProfileFragment());
            } else if (item.getItemId() == R.id.saved) {
                    replaceFragment(new SavedFragment());
            }
            return true;
        });
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment).commit();
    }
}