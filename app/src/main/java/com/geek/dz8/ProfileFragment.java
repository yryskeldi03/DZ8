package com.geek.dz8;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geek.dz8.databinding.FragmentProfileBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {
    private MainActivity activity;
    private FragmentProfileBinding binding;
    private ViewPagerAdapter viewPagerAdapter;
    private int[] icon = {R.drawable.second, R.drawable.shape};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        activity = (MainActivity) requireActivity();
        binding = FragmentProfileBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        activity.setToolbarText("jacob_w");
        activity.hideCamera();
        viewPagerAdapter = new ViewPagerAdapter(getActivity());
        viewPagerAdapter.addItem(new FirstFragment());
        viewPagerAdapter.addItem(new SecondFragment());
        binding.viewPager.setAdapter(viewPagerAdapter);
        new TabLayoutMediator(binding.tabs, binding.viewPager, (new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setIcon(icon[position]);
            }
        })).attach();
    }

}