package com.gardenlab.doitmission12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.text);
        editText = findViewById(R.id.editText);
        Button btnSend = findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent serviceIntent = new Intent(getApplicationContext(),MyService.class);
                serviceIntent.putExtra("String",editText.getText().toString());
                startService(serviceIntent);
            }
        });

        Intent intent = getIntent();
        processIntent(intent);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        processIntent(intent);
        super.onNewIntent(intent);
    }

    public void processIntent(Intent intent) {
        String msg = intent.getStringExtra("String");
        Log.d("Process","Recieve from Reciever: "+msg);
        text.setText(msg);
    }
}
