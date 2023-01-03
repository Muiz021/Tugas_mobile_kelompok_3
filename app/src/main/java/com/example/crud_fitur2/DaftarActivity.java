package com.example.crud_fitur2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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

public class DaftarActivity extends AppCompatActivity {

    TextView textView;
    EditText EditTextEmail,EditTextPassword;
    Button daftarAkun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        EditTextEmail = findViewById(R.id.email);
        EditTextPassword = findViewById(R.id.password);
        daftarAkun = findViewById(R.id.btnDaftar);

        textView = findViewById(R.id.signIn);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DaftarActivity.this, MasukActivity.class);
                startActivity(intent);
                finish();
            }
        });

        daftarAkun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email,password;
                email = String.valueOf(EditTextEmail.getText());
                password = String.valueOf(EditTextPassword.getText());

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(DaftarActivity.this, "Masukan Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(DaftarActivity.this, "Masukan Password", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
    }
}