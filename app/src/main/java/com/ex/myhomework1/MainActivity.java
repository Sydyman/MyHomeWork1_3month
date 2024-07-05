package com.ex.myhomework1;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText EditText;
    private EditText messageEditText;
    private Button sendEmailButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailEditText = findViewById(R.id.emailEditText);
        EditText = findViewById(R.id.ThemeEditText2);
        messageEditText = findViewById(R.id.messageEditText);
        sendEmailButton = findViewById(R.id.Button);

        sendEmailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });
    }

    private void sendEmail() {
        String email = emailEditText.getText().toString();
        String theme = EditText.getText().toString();
        String message = messageEditText.getText().toString();

        Uri uri = Uri.parse("mailto:" + email)
                .buildUpon()
                .appendQueryParameter("theme", theme)
                .appendQueryParameter("sms", message)
                .build();

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, uri);
        startActivity(emailIntent);


    }
}
