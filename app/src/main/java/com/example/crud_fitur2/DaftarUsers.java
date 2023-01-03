package com.example.crud_fitur2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.example.crud_fitur2.adapter.Adapter;
import com.example.crud_fitur2.helper.Helper;
import com.example.crud_fitur2.model.Data;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DaftarUsers extends AppCompatActivity {

    ListView listView;
    AlertDialog.Builder dialog;
    List<Data> lists = new ArrayList<>();
    Adapter adapter;
    Helper db = new Helper(this);
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_users);

        db = new Helper(getApplicationContext());
        btnAdd = findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DaftarUsers.this,Editor.class);
                startActivity(intent);
            }
        });
        listView = findViewById(R.id.list_item);
        adapter = new Adapter(DaftarUsers.this, lists);
        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                final String id = lists.get(i).getId();
                final String nisn = lists.get(i).getNisn();
                final String name = lists.get(i).getName();
                final String jenis_kelamin = lists.get(i).getJenis_kelamin();
                final String tempat_lahir = lists.get(i).getTempat_lahir();
                final String tanggal_lahir = lists.get(i).getTanggal_lahir();
                final String agama = lists.get(i).getAgama();
                final String asal_sekolah = lists.get(i).getAsal_sekolah();

                final CharSequence[] dialogItem = {"Edit","Hapus"};
                dialog = new AlertDialog.Builder(DaftarUsers.this);
                dialog.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        switch (i){
                            case 0:
                                Intent intent = new Intent(DaftarUsers.this,Editor.class);
                                intent.putExtra("id",id);
                                intent.putExtra("nisn",nisn);
                                intent.putExtra("name",name);
                                intent.putExtra("jenis_kelamin", jenis_kelamin);
                                intent.putExtra("tempat_lahir", tempat_lahir);
                                intent.putExtra("tanggal_lahir",tanggal_lahir);
                                intent.putExtra("agama",agama);
                                intent.putExtra("asal_sekolah",asal_sekolah);

                                startActivity(intent);
                                break;
                            case 1:
                                db.delete(Integer.parseInt(id));
                                lists.clear();
                                getData();
                                break;
                        }
                    }
                }).show();
                return false;
            }
        });
        getData();
    }

    private void getData(){
        ArrayList<HashMap<String,String>> rows = db.getAll();
        for (int i = 0; i<rows.size();i++){
            String id = rows.get(i).get("id");
            String nisn = rows.get(i).get("nisn");
            String name = rows.get(i).get("name");
            String jenis_kelamin = rows.get(i).get("jenis_kelamin");
            String tempat_lahir = rows.get(i).get("tempat_lahir");
            String tanggal_lahir = rows.get(i).get("tanggal_lahir");
            String agama = rows.get(i).get("agama");
            String asal_sekolah = rows.get(i).get("asal_sekolah");

            Data data = new Data();
            data.setId(id);
            data.setNisn(nisn);
            data.setName(name);
            data.setJenis_kelamin(jenis_kelamin);
            data.setTempat_lahir(tempat_lahir);
            data.setTanggal_lahir(tanggal_lahir);
            data.setAgama(agama);
            data.setAsal_sekolah(asal_sekolah);
            lists.add(data);
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();
        lists.clear();
        getData();
    }
}