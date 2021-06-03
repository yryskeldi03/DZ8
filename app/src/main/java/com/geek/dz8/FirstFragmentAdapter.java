package com.geek.dz8;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geek.dz8.databinding.ProfleFragmentItemsBinding;

import java.util.ArrayList;

public class FirstFragmentAdapter extends RecyclerView.Adapter<FirstFragmentAdapter.ViewHolder> {
    private ArrayList<Integer> list = new ArrayList<>();

    public void addPhoto(ArrayList<Integer> list){
        this.list.addAll(list);
    }

    @Override
    public FirstFragmentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(ProfleFragmentItemsBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ProfleFragmentItemsBinding binding;
        public ViewHolder(@NonNull ProfleFragmentItemsBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        public void onBind(Integer integer) {
            binding.imgPost.setImageResource(integer);
        }
    }
}
