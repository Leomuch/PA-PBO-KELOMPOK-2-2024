package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import data.statistik;
import main.App;

public class statistikController {
    static InputStreamReader isr = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(isr);
    public static void readStatistics() throws SQLException {
        db.connection();
        String query = "SELECT namaPemain, idPemain, posisi, gol, assist, `match` FROM statistik";
        try {
            db.preparedStatement = (PreparedStatement) db.conn.prepareStatement(query);
            db.resultSet = db.preparedStatement.executeQuery();
            while (db.resultSet.next()) {
                int idPemain = db.resultSet.getInt("idPemain");
                String posisi = db.resultSet.getString("posisi");
                int gol = db.resultSet.getInt("gol");
                int assist = db.resultSet.getInt("assist");
                int match = db.resultSet.getInt("match");
                String namaPemain = db.resultSet.getString("namaPemain");
                data.statistik newStatistik = new statistik(posisi, gol, assist, match, idPemain, namaPemain);
                App.statistikPlayer.add(newStatistik);
            }
        } catch (SQLException e) {
            System.out.println("Gagal Membaca Data Statistik");
            e.printStackTrace();
        }
    }

    public static void addStatistik(String posisi, int gol, int assist, int match, int idPemain, String namaPemain) throws IOException, SQLException {
        db.connection();
        boolean idPlayerExists = false;
        String readStatistik = "SELECT COUNT(*) FROM statistik WHERE idPemain = ?";
        try {
            db.preparedStatement = db.conn.prepareStatement(readStatistik);
            db.preparedStatement.setInt(1, idPemain);
            db.resultSet = db.preparedStatement.executeQuery();
            if (db.resultSet.next() && db.resultSet.getInt(1) > 0) {
                idPlayerExists = true;
            }
        } catch (SQLException e) {
            System.out.println("Gagal mengecek.");
            e.printStackTrace();
        }
    
        if (idPlayerExists) {
            System.out.println("Data Statistik Pemain Tersebut Sudah Ada");
            System.out.print("Data sudah ada. Ingin menambah data lain (1) atau mengedit (2)? Masukkan pilihan: ");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int pilihan = Integer.parseInt(br.readLine());
    
            if (pilihan == 1) {
                // Logika untuk menambah data yang lain
                // ...
            } else if (pilihan == 2) {
                // updateStatistik(idPemain);
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        } else {
            // Logika untuk menambah data baru ke database
            String query = "INSERT INTO statistik (posisi, gol, assist, `match`, idPemain, namaPemain) VALUES (?, ?, ?, ?, ?, ?)";
            try {
                db.preparedStatement = db.conn.prepareStatement(query);
                db.preparedStatement.setString(1, posisi);
                db.preparedStatement.setInt(2, gol);
                db.preparedStatement.setInt(3, assist);
                db.preparedStatement.setInt(4, match);
                db.preparedStatement.setInt(5, idPemain);
                db.preparedStatement.setString(6, namaPemain);
                db.preparedStatement.executeUpdate();
                System.out.println("Tambah Data Statistik Berhasil.");
            } catch (SQLException e) {
                System.out.println("Tambah Data Statistik Gagal");
                e.printStackTrace();
            } finally {
                try {
                    if (db.preparedStatement != null) db.preparedStatement.close();
                    if (db.conn != null) db.conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }        
}