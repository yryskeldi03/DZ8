package com.geek.dz8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.geek.dz8.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initNavController();
        setCameraClick();
    }

    private void setCameraClick() {
        binding.camera.setOnClickListener(v ->
                startActivity(new Intent("android.media.action.IMAGE_CAPTURE")));
    }

    private void initNavController() {
        navController = Navigation.findNavController(this, R.id.fragmentContainerView);
        NavigationUI.setupWithNavController(binding.bottomNav, navController);
    }

    public void hideCamera(){
        binding.camera.setVisibility(View.GONE);
    }

    public void showCamera() {
        binding.camera.setVisibility(View.VISIBLE);
    }

    public void setToolbarText(String s) {
        binding.title.setText(s);
    }
}