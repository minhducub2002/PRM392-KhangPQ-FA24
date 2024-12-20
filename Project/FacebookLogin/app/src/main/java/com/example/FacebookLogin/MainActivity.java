package com.example.FacebookLogin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button loginButton;
    private EditText account;
    private EditText password;

    private void bindingView() {
        loginButton = findViewById(R.id.login);
        account = findViewById(R.id.account);
        password = findViewById(R.id.password);
    }

    private void bindingAction() {
        loginButton.setOnClickListener(this::onBtnChangeClick);
    }

    private void onBtnChangeClick(View view) {
        String acc = account.getText().toString();
        String pass = password.getText().toString();

        Toast toast;
        if (acc.equals("admin") && pass.equals("123456")) {
            toast = Toast.makeText(this, "Login success!", Toast.LENGTH_SHORT);
        } else {
            toast = Toast.makeText(this, "Login fail!", Toast.LENGTH_SHORT);
        }
        toast.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        bindingView();
        bindingAction();
    }
}