package data;

public class statistik{
    String posisi;
    private int gol;
    private int assist;
    private int match;
    private int idPemain;
    String namaPemain;

    public statistik(String posisi, int gol, int assist, int match, int idPemain, String namaPemain) {
        this.posisi = posisi;
        this.gol = gol;
        this.assist = assist;
        this.match = match;
        this.idPemain = idPemain;
        this.namaPemain = namaPemain;
    }

    public int getIdPemain() {
        return idPemain;
    }
    
    public String getPosisi() {
        return posisi;
    }

    public int getGol() {
        return gol;
    }

    public int getAssist() {
        return assist;
    }

    public int getMatch() {
        return match;
    }

    public String getNamaPemain() {
        return namaPemain;
    }

    public void setIdPemain(int idPemain) {
        this.idPemain = idPemain;
    }

    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }

    public void setGol(int gol) {
        this.gol = gol;
    }

    public void setAssist(int assist) {
        this.assist = assist;
    }

    public void setMatch(int match) {
        this.match = match;
    }

    public void setNamaPemain(String namaPemain) {
        this.namaPemain = namaPemain;
    }
}
