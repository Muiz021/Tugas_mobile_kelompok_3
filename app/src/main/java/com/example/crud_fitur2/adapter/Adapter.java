package com.example.crud_fitur2.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.crud_fitur2.R;
import com.example.crud_fitur2.model.Data;

import java.util.List;

public class Adapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Data> lists;

    public Adapter(Activity activity,List<Data> lists){
        this.activity = activity;
        this.lists = lists;
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int i) {
        return lists.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (inflater == null){
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if (view == null && inflater != null){
            view = inflater.inflate(R.layout.list_users,null);
        }

        if (view != null){
            TextView nisn = view.findViewById(R.id.text_nisn);
            TextView name = view.findViewById(R.id.text_name);
            TextView jenis_kelamin = view.findViewById(R.id.text_jk);
            TextView tempat_lahir = view.findViewById(R.id.text_tempat_lahir);
            TextView tanggal_lahir = view.findViewById(R.id.text_tanggal_lahir);
            TextView agama = view.findViewById(R.id.text_agama);
            TextView asal_sekolah = view.findViewById(R.id.text_asal_sekolah);
            Data data = lists.get(i);

            nisn.setText(data.getNisn());
            name.setText(data.getName());
            jenis_kelamin.setText(data.getJenis_kelamin());
            tempat_lahir.setText(data.getJenis_kelamin());
            tanggal_lahir.setText(data.getTanggal_lahir());
            agama.setText(data.getAgama());
            asal_sekolah.setText(data.getAsal_sekolah());
        }
        return view;
    }
}