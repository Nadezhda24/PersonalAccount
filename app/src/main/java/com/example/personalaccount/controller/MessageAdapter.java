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
import com.example.personalaccount.model.Message;
import com.example.personalaccount.model.Note;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder>{
    private final LayoutInflater inflater ;
    private final List<Message> Messages;

    public MessageAdapter(Context context, List<Message> Messages){
        this.Messages = Messages;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public MessageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.message_outgoing, parent, false);
        return new MessageAdapter.ViewHolder(view);
    }


    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(MessageAdapter.ViewHolder holder, int position) {
        Message Message = Messages.get(position);
        holder.Text.setText(Message.GetText());
        holder.Time.setText(Message.GetTime());
        holder.UserName.setText(Message.GetUserName());

    }

    @Override
    public int getItemCount() {
        return Messages.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        final TextView UserName, Text, Time;
        final FrameLayout frameLayout;
        ViewHolder(View view){
            super(view);
            UserName = (TextView) view.findViewById(R.id.MessageUser);
            Text = (TextView) view.findViewById(R.id.MessageText);
            Time = (TextView) view.findViewById(R.id.Date);
            frameLayout = (FrameLayout) view.findViewById(R.id.frameLayout);
        }
    }

}
