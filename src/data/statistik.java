package data;

public class statistik{
    String posisi;
    private int gol;
    private int assist;
    private int match;

    public statistik(String posisi, int gol, int assist, int match) {
        this.posisi = posisi;
        this.gol = gol;
        this.assist = assist;
        this.match = match;
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
}
