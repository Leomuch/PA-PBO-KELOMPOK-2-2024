package data;

import java.time.LocalDate;
import java.util.Date;

public class kontrakPemain{
    private LocalDate tanggalMulaiKontrak;
    private LocalDate tanggalAkhirKontrak;
    private double nilaiKontrak;
    private double klausulPelepasan;
    private int idPemain;
    private String namaPemain;

    public kontrakPemain(LocalDate tanggalMulaiKontrak, LocalDate tanggalAkhirKontrak, double nilaiKontrak, double klausulPelepasan, int idPemain, String namaPemain){
        this.tanggalMulaiKontrak = tanggalMulaiKontrak;
        this.tanggalAkhirKontrak = tanggalAkhirKontrak;
        this.nilaiKontrak = nilaiKontrak;
        this.klausulPelepasan = klausulPelepasan;
        this.idPemain = idPemain;
        this.namaPemain = namaPemain;
    }

    public LocalDate getTanggalMulaiKontrak() {
        return tanggalMulaiKontrak;
    }

    public LocalDate getTanggalAkhirKontrak() {
        return tanggalAkhirKontrak;
    }

    public double getNilaiKontrak() {
        return nilaiKontrak;
    }

    public double getKlausulPelepasan() {
        return klausulPelepasan;
    }

    public int getIdPemain() {
        return idPemain;
    }

    public String getNamaPemain() {
        return namaPemain;
    }

    public void setTanggalMulaiKontrak(LocalDate tanggalMulaiKontrak) {
        this.tanggalMulaiKontrak = tanggalMulaiKontrak;
    }

    public void setTanggalAkhirKontrak(LocalDate tanggalAkhirKontrak) {
        this.tanggalAkhirKontrak = tanggalAkhirKontrak;
    }

    public void setNilaiKontrak(double nilaiKontrak) {
        this.nilaiKontrak = nilaiKontrak;
    }

    public void setKlausulPelepasan(double klausulPelepasan) {
        this.klausulPelepasan = klausulPelepasan;
    }

    public void setIdPemain(int idPemain) {
        this.idPemain = idPemain;
    }

    public void setNamaPemain(String namaPemain) {
        this.namaPemain = namaPemain;
    }
}
