package com.geek.dz8;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geek.dz8.databinding.LikeFragmentItemsBinding;

import java.util.ArrayList;

public class LikeFragmentAdapter extends RecyclerView.Adapter<LikeFragmentAdapter.ViewHolder> {

    private ArrayList<LikeFragmentModel> list = new ArrayList<>();

    public void addItems(ArrayList<LikeFragmentModel> list){
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LikeFragmentItemsBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
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
        private LikeFragmentItemsBinding binding;
        public ViewHolder(@NonNull LikeFragmentItemsBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        public void onBind(LikeFragmentModel likeFragmentModel) {
            binding.imgOval.setImageResource(likeFragmentModel.getAvatar());
            binding.likeText.setText(likeFragmentModel.getDescription());
            binding.whenPressLikeTime.setText(likeFragmentModel.getTime());
            binding.likePhoto.setImageResource(likeFragmentModel.getLikePhoto());
        }
    }
}
