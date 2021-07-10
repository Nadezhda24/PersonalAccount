package com.example.personalaccount.note;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.example.personalaccount.R;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {
    private final LayoutInflater inflater;
    private final List<Note> Notes;

    public NoteAdapter(Context context, List<Note> Notes){
        this.Notes = Notes;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public NoteAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.note, parent, false);
        return new NoteAdapter.ViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(NoteAdapter.ViewHolder holder, int position) {
        Note Note = Notes.get(position);
        holder.NoteTitle.setText(Note.GetNoteTitle());
        holder.NoteText.setText(Note.GetNoteText());
    }

    @Override
    public int getItemCount() {
        return Notes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        final TextView NoteTitle, NoteText;
        final FrameLayout frameLayout;
        ViewHolder(View view){
            super(view);
            NoteTitle = (TextView) view.findViewById(R.id.NoteTitle);
            NoteText = (TextView) view.findViewById(R.id.NoteText);
            frameLayout = (FrameLayout) view.findViewById(R.id.frameLayout);
        }
    }
}
