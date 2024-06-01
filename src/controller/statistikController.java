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
        String query = "SELECT s.idPemain, s.posisi, s.gol, s.assist, s.match, p.namaPemain " +
                       "FROM statistik s " +
                       "JOIN pemain p ON s.idPemain = p.idPemain";
        try {
            db.preparedStatement = db.conn.prepareStatement(query);
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
        } finally {
            if (db.resultSet != null) try { db.resultSet.close(); } catch (SQLException e) { e.printStackTrace(); }
            if (db.preparedStatement != null) try { db.preparedStatement.close(); } catch (SQLException e) { e.printStackTrace(); }
            if (db.conn != null) try { db.conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }    

    public static void addStatistik(String posisi, int gol, int assist, int match, int idPemain) throws IOException, SQLException {
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
        } finally {
            if (db.resultSet != null) try { db.resultSet.close(); } catch (SQLException e) { e.printStackTrace(); }
            if (db.preparedStatement != null) try { db.preparedStatement.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    
        if (idPlayerExists) {
            System.out.println("Data Statistik Pemain Tersebut Sudah Ada");
            System.out.print("Data sudah ada. Ingin menambah data lain (1) atau mengedit (2)? Masukkan pilihan: ");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int pilihan = Integer.parseInt(br.readLine());
    
            if (pilihan == 1) {
                addStatistik(posisi, gol, assist, match, idPemain);
            } else if (pilihan == 2) {
                updateStatistik(idPemain);
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        } else {
            String query = "INSERT INTO statistik (posisi, gol, assist, `match`, idPemain) VALUES (?, ?, ?, ?, ?)";
            try {
                db.preparedStatement = db.conn.prepareStatement(query);
                db.preparedStatement.setString(1, posisi);
                db.preparedStatement.setInt(2, gol);
                db.preparedStatement.setInt(3, assist);
                db.preparedStatement.setInt(4, match);
                db.preparedStatement.setInt(5, idPemain);
                db.preparedStatement.executeUpdate();
                System.out.println("Tambah Data Statistik Berhasil.");
            } catch (SQLException e) {
                System.out.println("Tambah Data Statistik Gagal");
                e.printStackTrace();
            } finally {
                if (db.preparedStatement != null) try { db.preparedStatement.close(); } catch (SQLException e) { e.printStackTrace(); }
                if (db.conn != null) try { db.conn.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
        }
    }    
    
    public static void updateStatistik(int idPemain) throws IOException, SQLException {
        db.connection();
        String query = "SELECT namaPemain, posisi, gol, assist, `match` FROM statistik WHERE idPemain = ?";
        try {
            db.preparedStatement = db.conn.prepareStatement(query);
            db.preparedStatement.setInt(1, idPemain);
            db.resultSet = db.preparedStatement.executeQuery();

            if (db.resultSet.next()) {
                String currentNamaPemain = db.resultSet.getString("namaPemain");
                String currentPosisi = db.resultSet.getString("posisi");
                int currentGol = db.resultSet.getInt("gol");
                int currentAssist = db.resultSet.getInt("assist");
                int currentMatch = db.resultSet.getInt("match");

                System.out.println("Nama Pemain: " + currentNamaPemain);
                System.out.println("Posisi Saat Ini: " + currentPosisi);
                System.out.println("Gol Saat Ini: " + currentGol);
                System.out.println("Assist Saat Ini: " + currentAssist);
                System.out.println("Match Saat Ini: " + currentMatch);

                System.out.print("Masukkan Posisi Baru (kosong untuk tidak mengubah): ");
                String posisi = br.readLine();
                if (posisi.isEmpty()) posisi = currentPosisi;

                System.out.print("Masukkan Jumlah Gol Baru (kosong untuk tidak mengubah): ");
                String golInput = br.readLine();
                int gol = golInput.isEmpty() ? currentGol : Integer.parseInt(golInput);

                System.out.print("Masukkan Jumlah Assist Baru (kosong untuk tidak mengubah): ");
                String assistInput = br.readLine();
                int assist = assistInput.isEmpty() ? currentAssist : Integer.parseInt(assistInput);

                System.out.print("Masukkan Jumlah Match Baru (kosong untuk tidak mengubah): ");
                String matchInput = br.readLine();
                int match = matchInput.isEmpty() ? currentMatch : Integer.parseInt(matchInput);

                String updateQuery = "UPDATE statistik SET posisi = ?, gol = ?, assist = ?, `match` = ? WHERE idPemain = ?";
                try {
                    db.preparedStatement = db.conn.prepareStatement(updateQuery);
                    db.preparedStatement.setString(1, posisi);
                    db.preparedStatement.setInt(2, gol);
                    db.preparedStatement.setInt(3, assist);
                    db.preparedStatement.setInt(4, match);
                    db.preparedStatement.setInt(5, idPemain);
                    db.preparedStatement.executeUpdate();
                    System.out.println("Update Data Statistik Berhasil.");
                } catch (SQLException e) {
                    System.out.println("Update Data Statistik Gagal");
                    e.printStackTrace();
                }
            } else {
                System.out.println("Pemain dengan ID tersebut tidak ditemukan.");
            }
        } catch (SQLException e) {
            System.out.println("Gagal mengambil data pemain.");
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
