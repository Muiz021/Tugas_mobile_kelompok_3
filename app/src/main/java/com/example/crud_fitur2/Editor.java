package com.example.crud_fitur2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.crud_fitur2.helper.Helper;

public class Editor extends AppCompatActivity {

    private EditText editName,editNisn,editJenisKelamin,editTempatLahir,editTanggalLahir,editAgama,editAsalSekolah;
    private Button btnSave;
    private Helper db = new Helper(this);
    private String id,nisn,name, jenis_kelamin, tempat_lahir, tanggal_lahir, agama, asal_sekolah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        editNisn = findViewById(R.id.edit_nisn);
        editName = findViewById(R.id.edit_name);
        editJenisKelamin = findViewById(R.id.edit_jk);
        editTempatLahir = findViewById(R.id.edit_tempat_lahir);
        editTanggalLahir = findViewById(R.id.edit_tanggal_lahir);
        editAgama = findViewById(R.id.edit_agama);
        editAsalSekolah = findViewById(R.id.edit_asal_sekolah);

        btnSave = findViewById(R.id.btnSave);

        id = getIntent().getStringExtra("id");
        nisn = getIntent().getStringExtra("nisn");
        name = getIntent().getStringExtra("name");
        jenis_kelamin = getIntent().getStringExtra("jenis_kelamin");
        tempat_lahir = getIntent().getStringExtra("tempat_lahir");
        tanggal_lahir = getIntent().getStringExtra("tanggal_lahir");
        agama = getIntent().getStringExtra("agama");
        asal_sekolah = getIntent().getStringExtra("asal_sekolah");

        if (id == null || id.equals("")){
            setTitle("Tambah User");
        }else{
            setTitle("Edit User");
            editNisn.setText(nisn);
            editName.setText(name);
            editJenisKelamin.setText(jenis_kelamin);
            editTempatLahir.setText(tempat_lahir);
            editTanggalLahir.setText(tanggal_lahir);
            editAgama.setText(agama);
            editAsalSekolah.setText(asal_sekolah);

        }
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if (id == null || id.equals("")){
                        save();
                    }else {
                        edit();
                    }
                }catch (Exception e){
                    Log.e("Saving",e.getMessage());
                }
            }
        });
    }

    private void save(){
        if (String.valueOf(editNisn.getText()).equals("") || String.valueOf(editName.getText()).equals("")||String.valueOf(editJenisKelamin.getText()).equals("")||String.valueOf(editTempatLahir.getText()).equals("")||String.valueOf(editTanggalLahir.getText()).equals("")||String.valueOf(editAgama.getText()).equals("")||String.valueOf(editAsalSekolah.getText()).equals("")){
            Toast.makeText(getApplicationContext(),"Silahkan isi semua data!", Toast.LENGTH_SHORT).show();
        }else{
            db.insert(editNisn.getText().toString(),editName.getText().toString(),editJenisKelamin.getText().toString(),editTempatLahir.getText().toString(),editTanggalLahir.getText().toString(),editAgama.getText().toString(),editAsalSekolah.getText().toString());
            finish();
        }
    }

    private void edit(){
        if (String.valueOf(editNisn.getText()).equals("") || String.valueOf(editName.getText()).equals("")||String.valueOf(editJenisKelamin.getText()).equals("")||String.valueOf(editTempatLahir.getText()).equals("")||String.valueOf(editTanggalLahir.getText()).equals("")||String.valueOf(editAgama.getText()).equals("")||String.valueOf(editAsalSekolah.getText()).equals("")){
            Toast.makeText(getApplicationContext(),"Silahkan isi semua data!", Toast.LENGTH_SHORT).show();
        }else{
            db.update(Integer.parseInt(id),editNisn.getText().toString(),editName.getText().toString(),editJenisKelamin.getText().toString(),editTempatLahir.getText().toString(),editTanggalLahir.getText().toString(),editAgama.getText().toString(),editAsalSekolah.getText().toString());
            finish();
        }
    }
}