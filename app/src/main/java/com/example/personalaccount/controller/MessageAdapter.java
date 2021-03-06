package com.example.personalaccount.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.personalaccount.R;
import com.example.personalaccount.model.Message;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder>{

    private final int INPUT = 1;
    private final int OUTPUT = 0;


    private final LayoutInflater inflater ;
    private final List<Message> Messages;


    public MessageAdapter(Context context, List<Message> Messages){
        this.Messages = Messages;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public MessageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType)
        {
            case OUTPUT:
                return new MessageAdapter.ViewHolderOutput(inflater.inflate(R.layout.message, parent, false));
            case INPUT:
                return new MessageAdapter.ViewHolderInput(inflater.inflate(R.layout.message_outgoing, parent, false));
            default:
                throw new IllegalStateException("Unexpected value: " + viewType);
        }
    }

    public int getItemViewType(int position)
    {
        int type = 0;
        switch (Messages.get(position).GetInput()){
            case 0: type = OUTPUT; break;
            case 1: type = INPUT; break;
            default: type = -1;
        }
        return type;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(MessageAdapter.ViewHolder holder, int position) {
        Message Message = Messages.get(position);

        switch (holder.getItemViewType()) {
            case OUTPUT:
                ViewHolderOutput output = (ViewHolderOutput) holder;
                output.Text.setText(Message.GetText());
                output.Time.setText(Message.GetTime());
                if (Message.GetIsRead() == 0) output.imageView.setImageResource(R.drawable.circle);
                output.recyclerView.setLayoutManager(new LinearLayoutManager(inflater.getContext()));
                FileAdapter FileAdapter_input = new FileAdapter(inflater.getContext(),Message.GetFiles());
                output.recyclerView.setAdapter(FileAdapter_input);
        break;
            case INPUT:
                ViewHolderInput input = (ViewHolderInput) holder;
                input.Text.setText(Message.GetText());
                input.Time.setText(Message.GetTime());
                input.UserName.setText(Message.GetUserName());
                input.recyclerView.setLayoutManager(new LinearLayoutManager(inflater.getContext()));
                FileAdapter FileAdapter_output = new FileAdapter(inflater.getContext(),Message.GetFiles());
                input.recyclerView.setAdapter(FileAdapter_output);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return Messages.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        final TextView Text, Time;
        final FrameLayout frameLayout;
        final RecyclerView recyclerView;

        ViewHolder(View view){
            super(view);
            Text = (TextView) view.findViewById(R.id.MessageText);
            Time = (TextView) view.findViewById(R.id.Date);
            frameLayout = (FrameLayout) view.findViewById(R.id.frameLayout);
            recyclerView  = (RecyclerView) view.findViewById(R.id.recyclerViewFiles);
        }
    }


    public static class ViewHolderInput extends ViewHolder{

        final TextView UserName;

        ViewHolderInput(View view) {
            super(view);
            UserName = (TextView) view.findViewById(R.id.MessageUser);
        }
    }

    public static class ViewHolderOutput extends ViewHolder{

        final ImageView imageView;

        ViewHolderOutput(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.IsRead);
        }
    }

}
