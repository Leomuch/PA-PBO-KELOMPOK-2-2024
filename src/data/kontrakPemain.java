package data;

import java.util.Date;

public class kontrakPemain{
    private Date tanggalMulaiKontrak;
    private Date tanggalAkhirKontrak;
    private double nilaiKontrak;
    private double klausulPelepasan;

    public kontrakPemain(Date tanggalMulaiKontrak, Date tanggalAkhirKontrak, double nilaiKontrak, double klausulPelepasan){
        this.tanggalMulaiKontrak = tanggalMulaiKontrak;
        this.tanggalAkhirKontrak = tanggalAkhirKontrak;
        this.nilaiKontrak = nilaiKontrak;
        this.klausulPelepasan = klausulPelepasan;
    }

    public Date getTanggalMulaiKontrak() {
        return tanggalMulaiKontrak;
    }

    public Date getTanggalAkhirKontrak() {
        return tanggalAkhirKontrak;
    }

    public double getNilaiKontrak() {
        return nilaiKontrak;
    }

    public double getKlausulPelepasan() {
        return klausulPelepasan;
    }

    public void setTanggalMulaiKontrak(Date tanggalMulaiKontrak) {
        this.tanggalMulaiKontrak = tanggalMulaiKontrak;
    }

    public void setTanggalAkhirKontrak(Date tanggalAkhirKontrak) {
        this.tanggalAkhirKontrak = tanggalAkhirKontrak;
    }

    public void setNilaiKontrak(double nilaiKontrak) {
        this.nilaiKontrak = nilaiKontrak;
    }

    public void setKlausulPelepasan(double klausulPelepasan) {
        this.klausulPelepasan = klausulPelepasan;
    }
}
