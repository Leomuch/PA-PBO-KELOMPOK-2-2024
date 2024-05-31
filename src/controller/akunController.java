package controller;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import main.App;

import java.sql.*;

import user.akun;


public class akunController extends akun {

    public akunController(int id, String username, String password, String role) {
        super(id, username, password, role);
    }

    @Override
    public void readAkun(String username, String password) throws SQLException, NoSuchAlgorithmException, InvalidKeySpecException {
        db.connection();
        try {
            db.preparedStatement = db.conn.prepareStatement("SELECT * FROM akun WHERE username = ?");
            db.preparedStatement.setString(1, username);
            db.resultSet = db.preparedStatement.executeQuery();

            // memasukkan data ke arraylist akun
            if (db.resultSet.next()) {
                int id = db.resultSet.getInt("id");
                String role = db.resultSet.getString("role");
                akun newAkun = new akunController(id, username, password, role);
                App.listAkun.add(newAkun);
            }
    
            db.resultSet.close();
            db.preparedStatement.close();
            db.conn.close();
        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
        }
    }
    
    
    public static void regis(String username, String password, String role) throws NoSuchAlgorithmException, InvalidKeySpecException{
        db.connection();
        boolean usernameExists = false;
        String readUsername = "SELECT * FROM akun WHERE username = ?";
        try{
           db.preparedStatement =  (PreparedStatement) db.conn.prepareStatement(readUsername);
           db.preparedStatement.setString(1, username);
           db.resultSet = db.preparedStatement.executeQuery();
           if (db.resultSet.next()) {
                usernameExists = true;
                System.out.println("Username Sudah Ada");
           }
           db.resultSet.close();
           db.preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Gagal mengecek.");
            e.printStackTrace();
        }
        if (!usernameExists) {
            String query = "INSERT INTO akun (username, password, role) VALUES (?,?,?)";
            try {
                db.preparedStatement = (PreparedStatement) db.conn.prepareStatement(query);
                db.preparedStatement.setString(1, username);
                db.preparedStatement.setString(2, hashPass(password));
                db.preparedStatement.setString(3, role);
                db.preparedStatement.executeUpdate();
                System.out.println("Registrasi Berhasil.");
            } catch (SQLException e){
                System.out.println("Registrasi Gagal");
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

    public static final String predeterminedSalt = "TujuhKeajaibanInformatika";

    public static String hashPass(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] salt = predeterminedSalt.getBytes();
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = factory.generateSecret(spec).getEncoded();

        return Base64.getEncoder().encodeToString(hash);
    }
}
