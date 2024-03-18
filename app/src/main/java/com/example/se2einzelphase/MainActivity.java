package com.example.se2einzelphase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView text;
    private EditText MNr;
    private TextView response;
    private Button sendMNr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.textView1);
        MNr = findViewById(R.id.inputText);
        response = findViewById(R.id.textView2);
        sendMNr = findViewById(R.id.button1);

        sendMNr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = MNr.getText().toString();
                new TCP(result,response).start();
            }
        });
    }
}