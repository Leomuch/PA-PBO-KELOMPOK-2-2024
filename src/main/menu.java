package main;
public class menu {
    protected void index() {
        System.out.println("========================");
        System.out.println("||    TRANSFERMARKT   ||");
        System.out.println("========================");
        System.out.println("||     1. LOGIN       ||");
        System.out.println("||     2. SIGN UP     ||");
        System.out.println("||     3. EXIT        ||");
        System.out.println("========================");
        System.out.print("Pilihan : ");
    }

    protected void detail() {
        System.out.println("===========================");
        System.out.println("||  1. Statistik Pemain  ||");
        System.out.println("||  2. Kontrak Pemain    ||");
        System.out.println("||  3. Kembali           ||");
        System.out.println("===========================");
        System.out.print("Pilihan : ");
    }

    protected void tambahDetail() {
        System.out.println("==============================");
        System.out.println("||  1. Tambah Pemain        ||");
        System.out.println("||  2. Update Pemain        ||");
        System.out.println("||  3. Hapus Pemain         ||");
        System.out.println("||  4. Tambah Statistik     ||");
        System.out.println("||  5. Tambah Kontrak       ||");
        System.out.println("||  6. Kembali              ||");
        System.out.println("==============================");
        System.out.print("Pilihan : ");
    }

    protected void lihatDetail() {
        System.out.println("==========================");
        System.out.println("||  1. Lihat Pemain     ||");
        System.out.println("||  2. Lihat Statistik  ||");
        System.out.println("||  3. Lihat Kontrak    ||");
        System.out.println("||  4. Kembali          ||");
        System.out.println("==========================");
        System.out.print("Pilihan : ");
    }

    protected void menuAdmin() {
        System.out.println("==========================");
        System.out.println("||      ADMIN MENU      ||");
        System.out.println("==========================");
        System.out.println("||  1. Manajemen Data   ||");
        System.out.println("||  2. Data Pemain      ||");
        System.out.println("||  3. Kembali          ||");
        System.out.println("==========================");
        System.out.print("Pilihan : ");
    }
    
    protected void menuUser() {
        System.out.println("============================");
        System.out.println("||        USER MENU       ||");
        System.out.println("============================");
        System.out.println("||  1. Lihat Data Pemain  ||");
        System.out.println("||  2. Kembali            ||");
        System.out.println("============================");
        System.out.print("Pilihan : ");
    }
}