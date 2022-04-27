package com.example.personalaccount.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.personalaccount.R;
import com.example.personalaccount.model.ListItem;
import com.example.personalaccount.model.Note;

import java.util.List;

public class ListItemAdapter extends RecyclerView.Adapter<ListItemAdapter.ViewHolder> {
    private final LayoutInflater inflater;
    private List<ListItem> Items;

    public ListItemAdapter(Context context, List<ListItem> Items){
        this.Items = Items;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public ListItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list, parent, false);
        return new ListItemAdapter.ViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(ListItemAdapter.ViewHolder holder, int position) {
        ListItem Item = Items.get(position);
        holder.Item.setText(Item.GetItem());
    }

    @Override
    public int getItemCount() {
        return Items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView Item;
        final FrameLayout frameLayout;
        ViewHolder(View view){
            super(view);
            Item = (TextView) view.findViewById(R.id.ListItem);
            frameLayout = (FrameLayout) view.findViewById(R.id.frameLayout);
        }
    }
}
