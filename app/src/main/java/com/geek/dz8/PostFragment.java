package com.geek.dz8;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geek.dz8.databinding.FragmentPostBinding;
import com.geek.dz8.databinding.FragmentProfileBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class PostFragment extends Fragment {
    private FragmentPostBinding binding;
    private ViewPagerAdapter viewPagerAdapter;
    private int[] icon = {R.drawable.shape,R.drawable.second};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentPostBinding.inflate(getLayoutInflater());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPostBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPagerAdapter = new ViewPagerAdapter(getActivity());
        viewPagerAdapter.addItem(new FirstFragment());
        viewPagerAdapter.addItem(new SecondFragment());
        binding.viewPager.setAdapter(viewPagerAdapter);
        new TabLayoutMediator(binding.tabs, binding.viewPager, (new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(icon[position]);
            }
        })).attach();
    }
}