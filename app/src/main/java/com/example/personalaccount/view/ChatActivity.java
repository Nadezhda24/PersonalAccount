package com.example.personalaccount.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.personalaccount.R;
import com.example.personalaccount.controller.MessageAdapter;
import com.example.personalaccount.controller.NoteAdapter;
import com.example.personalaccount.model.Message;
import com.example.personalaccount.model.Note;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ChatActivity extends AppCompatActivity {
    ArrayList<Message> Messages = new ArrayList<Message>();
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

        setInitialData();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MessageAdapter MessageAdapter = new MessageAdapter(this, Messages);

        recyclerView.setAdapter(MessageAdapter);


       /* MessageAdapter1 messageadapter = new MessageAdapter1();
        messageadapter.setIncomingLayout(R.layout.message);
        messageadapter.setOutgoingLayout(R.layout.message_outgoing);
        messageadapter.setMessageTextId(R.id.MessageText);
        messageadapter.setUserNameId(R.id.MessageUser);
        messageadapter.setMessageTimeId(R.id.Date);
        messageadapter.appendTo(recyclerView, this);

        messageadapter.addMessage(
                new MessageAdapter1.Message("Самое большое сообщение, которое не влазиет в одну строку, потому что мне надо проверить насколько много текста я могу записать в сообщение, поэтому бдует стих:\n" +
                        " У лукоморья дуб зелёный;\n" +
                        "Златая цепь на дубе том:\n" +
                        "И днём и ночью кот учёный\n" +
                        "Всё ходит по цепи кругом;\n" +
                        "Идёт направо — песнь заводит,\n" +
                        "Налево — сказку говорит.\n" +
                        "Там чудеса: там леший бродит,\n" +
                        "Русалка на ветвях сидит;", "Пушкин А.С.", true)
        );

        messageadapter.addMessage(
                new MessageAdapter1.Message("Самое большое сообщение, которое не влазиет в одну строку, потому что мне надо проверить насколько много текста я могу записать в сообщение, поэтому бдует стих:\n" +
                        " У лукоморья дуб зелёный;\n" +
                        "Златая цепь на дубе том:\n" +
                        "И днём и ночью кот учёный\n" +
                        "Всё ходит по цепи кругом;\n" +
                        "Идёт направо — песнь заводит,\n" +
                        "Налево — сказку говорит.\n" +
                        "Там чудеса: там леший бродит,\n" +
                        "Русалка на ветвях сидит;", "Пушкин А.С.", false)
        );

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String new_message = text.getText().toString();
                messageadapter.addMessage(
                        new MessageAdapter1.Message(new_message, "", false));
                text.setText("");
            }
        });
*/

    }

    private void setInitialData(){
        DateFormat fmt = SimpleDateFormat.getTimeInstance(DateFormat.SHORT);

        Messages.add(new Message("Пушкин А.С.",  fmt.format(new Date()), "Самое большое сообщение, которое не влазиет в одну строку, потому что мне надо проверить насколько много текста я могу записать в сообщение, поэтому бдует стих:\n" +
                " У лукоморья дуб зелёный;\n" +
                "Златая цепь на дубе том:\n" +
                "И днём и ночью кот учёный\n" +
                "Всё ходит по цепи кругом;\n" +
                "Идёт направо — песнь заводит,\n" +
                "Налево — сказку говорит.\n" +
                "Там чудеса: там леший бродит,\n" +
                "Русалка на ветвях сидит;", 1) );
    }
}