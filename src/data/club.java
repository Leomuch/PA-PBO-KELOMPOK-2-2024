package data;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public abstract class club implements interfacePemain {
    private statistik state;
    private kontrakPemain contract;
    private int idClub;
    private String namaPemain;
    private int idPemain;

    public club(int idClub, String namaPemain, int idPemain){
        this.idClub = idClub;
        this.namaPemain = namaPemain;
        this.idPemain = idPemain;
    }
    
    public abstract void updatePemain(BufferedReader br, SimpleDateFormat formatter) throws IOException, ParseException;
    public statistik getState() {
        return state;
    }
    public kontrakPemain getContract() {
        return contract;
    }
    
    public int getIdClub() {
        return idClub;
    }
    
    public String getNamaPemain() {
        return namaPemain;
    }
    
    public int getIdPemain() {
        return idPemain;
    }

    public void setIdClub(int idClub) {
        this.idClub = idClub;
    }

    public void setNamaPemain(String namaPemain) {
        this.namaPemain = namaPemain;
    }

    public void setIdPemain(int idPemain) {
        this.idPemain = idPemain;
    }
}
