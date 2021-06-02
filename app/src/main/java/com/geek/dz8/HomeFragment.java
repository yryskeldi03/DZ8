package com.geek.dz8;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geek.dz8.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    private ArrayList<HomeFragmentModel> list = new ArrayList<>();
    private HomeFragmentAdapter adapter;
    private MainActivity activity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentHomeBinding.inflate(getLayoutInflater());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        activity = (MainActivity) requireActivity();
        binding = FragmentHomeBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new HomeFragmentAdapter();
        adapter.addItems(createList());
        binding.homeFragmentRecycler.setAdapter(adapter);
    }
    private ArrayList<HomeFragmentModel> createList(){
        for (int i = 0; i < 15; i++) {
            list.add(new HomeFragmentModel("joshua_l The game in Japan was amazing and I want to share some photos","September 19",R.drawable.insta_photo));
        }
        return list;
    }

    @Override
    public void onStart() {
        super.onStart();
        activity.showCamera();
        activity.setToolbarText("Instagram");
    }
}