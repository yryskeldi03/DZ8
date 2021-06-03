package com.geek.dz8;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geek.dz8.databinding.FragmentFirstBinding;
import com.geek.dz8.databinding.FragmentSecondBinding;

import java.util.ArrayList;

public class SecondFragment extends Fragment {
    private FragmentSecondBinding binding;
    private SecondFragmentAdapter adapter;
    private ArrayList<Integer> list = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentSecondBinding.inflate(getLayoutInflater());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new SecondFragmentAdapter();
        int numberOfColumns = 3;
        binding.recyclerPhoto.setLayoutManager(new GridLayoutManager(requireContext(),numberOfColumns));
        adapter.addPhoto(addPhotoList());
        binding.recyclerPhoto.setAdapter(adapter);
    }

    private ArrayList<Integer> addPhotoList() {
        for (int i = 0; i < 30; i++) {
            list.add(R.drawable.future);
        }
        return list;
    }
}