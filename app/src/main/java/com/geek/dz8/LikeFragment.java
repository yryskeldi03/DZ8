package com.geek.dz8;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geek.dz8.databinding.FragmentLikeBinding;

import java.util.ArrayList;

public class LikeFragment extends Fragment {
    private FragmentLikeBinding binding;
    private LikeFragmentAdapter adapter;
    private MainActivity activity;
    private ArrayList<LikeFragmentModel> list = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentLikeBinding.inflate(getLayoutInflater());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentLikeBinding.inflate(inflater,container,false);
        activity = (MainActivity) requireActivity();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new LikeFragmentAdapter();
        adapter.addItems(createList());
        binding.likeFragmentRecycler.setAdapter(adapter);
        activity.setToolbarText("Following");
        activity.hideCamera();
    }

    private ArrayList<LikeFragmentModel> createList() {
        for (int i = 0; i < 20; i++) {
            list.add(new LikeFragmentModel(R.drawable.oval_photo,R.drawable.like_photo,"karennne liked your photo.","1h"));
        }
        return list;
    }
}