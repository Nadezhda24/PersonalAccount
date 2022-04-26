package com.example.personalaccount.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.personalaccount.R;
import com.example.personalaccount.controller.MessageAdapter;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        getSupportActionBar().setTitle("Чат");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(108,164,208)));


        EditText text = (EditText) findViewById(R.id.NewMessage);
        ImageView send = (ImageView) findViewById(R.id.SendMessage);
        ImageView addFile = (ImageView) findViewById(R.id.AddFile);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.RecyclerViewMessages);

        MessageAdapter messageadapter = new MessageAdapter();
        messageadapter.setIncomingLayout(R.layout.message_outgoing);
        messageadapter.setOutgoingLayout(R.layout.message_outgoing);
        messageadapter.setMessageTextId(R.id.MessageText);
        messageadapter.setUserNameId(R.id.MessageUser);
        messageadapter.setMessageTimeId(R.id.Date);
        messageadapter.appendTo(recyclerView, this);

        messageadapter.addMessage(
                new MessageAdapter.Message("Самое большое сообщение, которое не влазиет в одну строку, потому что мне надо проверить насколько много текста я могу записать в сообщение, поэтому бдует стих:\n" +
                        " У лукоморья дуб зелёный;\n" +
                        "Златая цепь на дубе том:\n" +
                        "И днём и ночью кот учёный\n" +
                        "Всё ходит по цепи кругом;\n" +
                        "Идёт направо — песнь заводит,\n" +
                        "Налево — сказку говорит.\n" +
                        "Там чудеса: там леший бродит,\n" +
                        "Русалка на ветвях сидит;", "Пушкин А.С.", true)
        );

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String new_message = text.getText().toString();
                messageadapter.addMessage(
                        new MessageAdapter.Message(new_message, "Студент", false));
            }
        });



    }
}