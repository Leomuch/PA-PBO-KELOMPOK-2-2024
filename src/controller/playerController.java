package controller;

import java.sql.*;
import java.time.LocalDate;
import java.time.Period;

import data.pemain;
import main.App;

public class playerController {
    public static void readPlayer() throws SQLException {
        db.connection();
        String query = "SELECT * FROM pemain";
        String namaPemain, asalKlub, negara;
        LocalDate tanggalLahir;
        int umur, idPemain;
        boolean Exists = false;
        try {
            db.preparedStatement = (PreparedStatement) db.conn.prepareStatement(query);
            db.resultSet = db.preparedStatement.executeQuery();
            while (db.resultSet.next()) {
                Exists = false;
                idPemain = db.resultSet.getInt("idPemain");
                namaPemain = db.resultSet.getString("namaPemain");
                asalKlub = db.resultSet.getString("asalKlub");
                tanggalLahir = db.resultSet.getDate("tanggalLahir").toLocalDate();
                umur = Period.between(tanggalLahir, LocalDate.now()).getYears();
                // umur = db.resultSet.getInt("umur");
                negara = db.resultSet.getString("negara");
                for (pemain existingData : App.player) {
                    if (existingData.getIdPemain() == idPemain) {
                        existingData.setNamaPemain(namaPemain);
                        existingData.setAsalKlub(asalKlub);
                        existingData.setTanggalLahir(tanggalLahir);
                        existingData.setUmur(umur);
                        existingData.setNegara(negara);
                        Exists = true;  
                    }
                }
                if (!Exists) {
                    pemain newPlayer = new pemain(idPemain, namaPemain, asalKlub, tanggalLahir, umur, negara);
                    App.player.add(newPlayer);
                }
            }
        } catch (SQLException e) {
            System.out.println("Gagal Membaca Data Pemain");
            e.printStackTrace();
        } finally {
            if (db.resultSet != null) db.resultSet.close();
            if (db.preparedStatement != null) db.preparedStatement.close();
            if (db.conn != null) db.conn.close();
        }
    }

    public static void addPlayer(String namaPemain, String asalKlub, LocalDate tanggalLahir, int umur, String negara) throws SQLException {
        db.connection();
        boolean pemainExists = false;
        String readPemain = "SELECT * FROM pemain WHERE namaPemain = ?";
        try {
            db.preparedStatement = (PreparedStatement) db.conn.prepareStatement(readPemain);
            db.preparedStatement.setString(1, namaPemain);
            db.resultSet = db.preparedStatement.executeQuery();
            if (db.resultSet.next()) {
                pemainExists = true;
                System.out.println("Data Pemain Tersebut Sudah Ada");
            }
            db.resultSet.close();
            db.preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Gagal mengecek.");
            e.printStackTrace();
        }
        if (!pemainExists) {
            String query = "INSERT INTO pemain (namaPemain, asalKlub, tanggalLahir, umur, negara) VALUES (?,?,?,?,?)";
            try {
                db.preparedStatement = (PreparedStatement) db.conn.prepareStatement(query);
                db.preparedStatement.setString(1, namaPemain);
                db.preparedStatement.setString(2, asalKlub);
                db.preparedStatement.setDate(3, Date.valueOf(tanggalLahir));
                db.preparedStatement.setInt(4, umur);
                db.preparedStatement.setString(5, negara);
                db.preparedStatement.executeUpdate();
                System.out.println("Tambah Data Berhasil.");
            } catch (SQLException e) {
                System.out.println("Tambah Data Gagal");
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

    public static void updatePlayer(int idPemain, String namaPemain, String asalKlub, LocalDate tanggalLahir, int umur, String negara) throws SQLException {
        db.connection();
        String query = "UPDATE pemain SET namaPemain = ?, asalKlub = ?, tanggalLahir = ?, umur = ?, negara ? WHERE idPemain = ?";
    
        try (PreparedStatement preparedStatement = db.conn.prepareStatement(query)) {
            preparedStatement.setString(1, namaPemain);
            preparedStatement.setString(2, asalKlub);
            preparedStatement.setDate(3, Date.valueOf(tanggalLahir));
            preparedStatement.setInt(4, umur);
            preparedStatement.setInt(5, idPemain);
            preparedStatement.setString(6, negara);
    
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Update Data Berhasil.");
            } else {
                System.out.println("Update Data Gagal. Tidak ada pemain dengan ID tersebut.");
            }
        } catch (SQLException e) {
            System.out.println("Update Data Gagal");
            e.printStackTrace();
        } finally {
            try {
                if (db.conn != null) db.conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void deletePlayer(int idPemain) throws SQLException {
        db.connection();
        String query = "DELETE FROM pemain WHERE idPemain = ?";

        try (PreparedStatement preparedStatement = db.conn.prepareStatement(query)) {
            preparedStatement.setInt(1, idPemain);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Hapus Data Berhasil.");
            } else {
                System.out.println("Hapus Data Gagal. Tidak ada pemain dengan ID tersebut.");
            }
        } catch (SQLException e) {
            System.out.println("Hapus Data Gagal");
            e.printStackTrace();
        } finally {
            try {
                if (db.conn != null) db.conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
