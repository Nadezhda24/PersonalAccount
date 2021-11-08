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
import com.example.personalaccount.model.Chat;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {

    public interface OnChatClickListener{
        void onChatClick(Chat chat, int position);
    }

    private final OnChatClickListener onClickListener;

    private final LayoutInflater inflater;
    private final List<Chat> Chats;

    public ChatAdapter(Context context, List<Chat> Chats, OnChatClickListener onClickListener){
        this.onClickListener = onClickListener;
        this.Chats = Chats;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public ChatAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = inflater.inflate(R.layout.chat, parent, false);
        return new ChatAdapter.ViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(ChatAdapter.ViewHolder holder, int position) {
        Chat Chat = Chats.get(position);
        holder.ChatTitle.setText(Chat.GetChatTitle());
        holder.ChatText.setText(Chat.GetChatText());
        holder.ChatCountUnread.setText(Chat.GetChatCountUnread());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onChatClick(Chat, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return Chats.size();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {

        final TextView ChatTitle, ChatText,ChatCountUnread ;
        final FrameLayout frameLayout;
        ViewHolder(View view){
            super(view);
            ChatTitle = (TextView) view.findViewById(R.id.ChatTitle);
            ChatText = (TextView) view.findViewById(R.id.ChatText);
            ChatCountUnread = (TextView) view.findViewById(R.id.ChatCountUnread);
            frameLayout = (FrameLayout) view.findViewById(R.id.frameLayout);
        }
    }

}
