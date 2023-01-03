package com.example.crud_fitur2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.crud_fitur2.helper.Helper;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MasukActivity extends AppCompatActivity {

    TextView signUp;
    EditText EditTextUsername,EditTextPassword;
    Button btnMasuk;

    String username = "muis";
    String password = "123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masuk);

        signUp = findViewById(R.id.signUp);
        EditTextUsername = findViewById(R.id.username);
        EditTextPassword = findViewById(R.id.password);
        btnMasuk = findViewById(R.id.btnMasuk);

        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (EditTextUsername.getText().toString().equalsIgnoreCase(username) && EditTextPassword.getText().toString().equalsIgnoreCase(password)){
                    Intent intent = new Intent(MasukActivity.this, Editor.class);
                    startActivity(intent);
                    Toast.makeText(MasukActivity.this, "Kamu berhasil login", Toast.LENGTH_SHORT).show();
                }
            }
        });



        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MasukActivity.this, DaftarActivity.class);
                startActivity(intent);
            }
        });
    }
}