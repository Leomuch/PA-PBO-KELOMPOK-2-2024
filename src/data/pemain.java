package data;

import java.time.LocalDate;

public class pemain {
    private int idPemain;
    private String namaPemain;
    private String asalKlub;
    private LocalDate tanggalLahir;
    private int umur;

    public pemain(int idPemain, String namaPemain, String asalKlub, LocalDate tanggalLahir, int umur){
        this.idPemain = idPemain;
        this.namaPemain = namaPemain;
        this.asalKlub = asalKlub;
        this.tanggalLahir = tanggalLahir;
        this.umur = umur;
    }
    public int getIdPemain() {
        return idPemain;
    }
    public String getNamaPemain() {
        return namaPemain;
    }
    public String getAsalKlub() {
        return asalKlub;
    }
    public int getUmur() {
        return umur;
    }
    public LocalDate getTanggalLahir() {
        return tanggalLahir;
    }
    public void setIdPemain(int idPemain) {
        this.idPemain = idPemain;
    }
    public void setNamaPemain(String namaPemain) {
        this.namaPemain = namaPemain;
    }
    public void setAsalKlub(String asalKlub) {
        this.asalKlub = asalKlub;
    }
    public void setUmur(int umur) {
        this.umur = umur;
    }
    public void setTanggalLahir(LocalDate tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }
}