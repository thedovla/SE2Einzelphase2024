package com.example.se2einzelphase;

import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCP extends Thread {
    private String MNr;
    private TextView responseTextView;
    public TCP(String MNr, TextView responseTextView) {
        this.MNr = MNr;
        this.responseTextView = responseTextView;
    }
    public void run() {
        try {
            Socket socket = new Socket("se2-submission.aau.at", 20080);
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            BufferedReader serverInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            outputStream.writeBytes(MNr + '\n');
            final String response = serverInput.readLine();
            socket.close();

            responseTextView.post(new Runnable() {
                @Override
                public void run() {
                    responseTextView.setText(response);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
