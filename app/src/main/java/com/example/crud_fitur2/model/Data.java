package com.example.crud_fitur2.model;

public class Data {
    private String id,nisn,name,jenis_kelamin,tempat_lahir,tanggal_lahir,agama, asal_sekolah;

  public Data(){

  }

    public Data(String id, String nisn, String name, String jenis_kelamin, String tempat_lahir, String tanggal_lahir, String agama, String asal_sekolah){
        this.id = id;
        this.nisn = nisn;
        this.name = name;
        this.jenis_kelamin = jenis_kelamin;
        this.tempat_lahir = tempat_lahir;
        this.tanggal_lahir = tanggal_lahir;
        this.agama = agama;
        this.asal_sekolah = asal_sekolah;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNisn() {
        return nisn;
    }

    public void setNisn(String nisn) {
        this.nisn = nisn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getTempat_lahir() {
        return tempat_lahir;
    }

    public void setTempat_lahir(String tempat_lahir) {
        this.tempat_lahir = tempat_lahir;
    }

    public String getTanggal_lahir() {
        return tanggal_lahir;
    }

    public void setTanggal_lahir(String tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getAsal_sekolah() {
        return asal_sekolah;
    }

    public void setAsal_sekolah(String asal_sekolah) {
        this.asal_sekolah = asal_sekolah;
    }

}
