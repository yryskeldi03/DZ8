package com.geek.dz8;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geek.dz8.databinding.HomeFragmentItemsBinding;

import java.util.ArrayList;

public class HomeFragmentAdapter extends RecyclerView.Adapter<HomeFragmentAdapter.ViewHolder> {
    private ArrayList<HomeFragmentModel> list = new ArrayList<>();

    public void addItems(ArrayList<HomeFragmentModel> list){
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(HomeFragmentItemsBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
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
        private HomeFragmentItemsBinding binding;
        public ViewHolder(@NonNull HomeFragmentItemsBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        public void onBind(HomeFragmentModel model) {
            binding.instaPhoto.setImageResource(model.getImage());
            binding.tvDescription.setText(model.getDescription());
            binding.tvDate.setText(model.getDate());
        }
    }
}
