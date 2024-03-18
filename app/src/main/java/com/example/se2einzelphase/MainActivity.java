package com.example.se2einzelphase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView text;
    private EditText MNr;
    private TextView response;
    private Button sendMNr;
    private Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.textView1);
        MNr = findViewById(R.id.inputText);
        response = findViewById(R.id.textView2);
        sendMNr = findViewById(R.id.button1);
        calculate = findViewById(R.id.button2);

        sendMNr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = MNr.getText().toString();
                new TCP(result,response).start();
            }
        });
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = MNr.getText().toString();
                List<String> result = CommonAdviserCalculator.findDigitsWithCommonDivisor(input);
                StringBuilder stringBuilder = new StringBuilder();
                for (String s : result) {
                    stringBuilder.append(s).append("\n");
                }
                response.setText(stringBuilder.toString());
            }
        });
    }
}