package controller;

import java.sql.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import data.kontrakPemain;
import main.App;

public class kontrakController {
    static InputStreamReader isr = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(isr);
    public static void readContract() throws SQLException {
        db.connection();
        String namaPemain;
        int idPemain;
        LocalDate kontrakAwal, kontrakAkhir;
        double nilaiKontrak, klausulPelepasan;
        String query = "SELECT namaPemain, idPemain, kontrakAwal, kontrakAkhir, nilaiKontrak, klausulPelepasan FROM kontrakPemain";
        try {
            db.preparedStatement = (PreparedStatement) db.conn.prepareStatement(query);
            db.resultSet = db.preparedStatement.executeQuery();
            while (db.resultSet.next()) {
                idPemain = db.resultSet.getInt("idPemain");
                namaPemain = db.resultSet.getString("namaPemain");
                kontrakAwal = db.resultSet.getDate("kontrakAwal").toLocalDate();
                kontrakAkhir = db.resultSet.getDate("kontrakAkhir").toLocalDate();
                nilaiKontrak = db.resultSet.getDouble("nilaiKontrak");
                klausulPelepasan = db.resultSet.getDouble("klausulPelepasan");
                data.kontrakPemain newKontrakPemain = new kontrakPemain(kontrakAwal, kontrakAkhir, nilaiKontrak, klausulPelepasan, idPemain, namaPemain);
                App.contract.add(newKontrakPemain);
            }
        } catch (SQLException e) {
            System.out.println("Gagal Membaca Data Kontrak Pemain");
            e.printStackTrace();
        }
    }

    public static void addContract(LocalDate kontrakAwal, LocalDate kontrakAkhir, double nilaiKontrak, double klausulPelepasan, int idPemain, String namaPemain) throws IOException, SQLException {
        db.connection();
        boolean idPlayerExists = false;
        String readStatistik = "SELECT COUNT(*) FROM kontrakPemain WHERE idPemain = ?";
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
            // Logika untuk menambah data baru ke database
            String query = "INSERT INTO kontrakPemain (kontrakAwal, kontrakAkhir, nilaiKontrak, klausulPelepasan, idPemain, namaPemain) VALUES (?, ?, ?, ?, ?, ?)";
            try {
                db.preparedStatement = db.conn.prepareStatement(query);
                db.preparedStatement.setDate(1, Date.valueOf(kontrakAwal));
                db.preparedStatement.setDate(2, Date.valueOf(kontrakAkhir));
                db.preparedStatement.setDouble(3, nilaiKontrak);
                db.preparedStatement.setDouble(4, klausulPelepasan);
                db.preparedStatement.setInt(5, idPemain);
                db.preparedStatement.setString(6, namaPemain);
                db.preparedStatement.executeUpdate();
                System.out.println("Tambah Data Kontrak Pemain Berhasil.");
            } catch (SQLException e) {
                System.out.println("Tambah Data Kontrak Pemain Gagal");
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
