/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kelas;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class user {
    String user_name, user_email, user_pasword, user_fulname;
    int user_status;
    
    private Connection konek;

    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private String query;
    
    public user() throws SQLException{
        koneksi koneksi = new koneksi();
        konek = koneksi.koneksiDB();
        
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_pasword() {
        return user_pasword;
    }

    public void setUser_pasword(String user_pasword) {
        this.user_pasword = user_pasword;
    }

    public String getUser_fulname() {
        return user_fulname;
    }

    public void setUser_fulname(String user_fulname) {
        this.user_fulname = user_fulname;
    }

    public int getUser_status() {
        return user_status;
    }

    public void setUser_status(int user_status) {
        this.user_status = user_status;
    }
    public void tambahUser(){
        query = "INSERT INTO user VALUES(?,?,MD5(?),?,?)";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, user_name);
            ps.setString(2, user_email);
            ps.setString(3, user_pasword);
            ps.setString(4, user_fulname);
            ps.setInt(5, user_status);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null,"user berhasil ditambahkan");
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null,"user gagal ditambahkan");
        }
    }
    public ResultSet tampiluser(){
        query = "SELECT * FROM user";
        try {
            st = konek.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException sQLException) {
            JOptionPane.showInputDialog(null,"Data Gagal Ditambahkan");
        }
        
        return rs;
        
    }
    
    public void hapusUser() {
        query = "DELETE FROM user WHERE user_name = ?";
        
        try {
            ps = konek.prepareStatement(query);
            
            ps.setString(1,  user_name);
            
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "User Berhasil Di Hapus");
            
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "User Gagal Di Hapus");
        }
        
    }
    public void ubahUser() {
        if (user_pasword.equals("")){
            
            query = "UPDATE user SET user_email = ?,"
                    + " user_fullname = ?,"
                    + " user_status = ?"
                    + " WHERE user_name = ?";
            try {
                ps = konek.prepareStatement(query);
                
                ps.setString(1, user_email);
                ps.setString(2, user_fulname);
                ps.setInt(3, user_status);
                ps.setString(4, user_name);
                
                ps.executeUpdate();
                ps.close();
                JOptionPane.showMessageDialog(null, "User Berhasil Di Ubah");
                
            } catch (SQLException sQLException) {
                JOptionPane.showMessageDialog(null, "User Gagal Di Ubah");
            }
        }else {
            query = "UPDATE user SET user_email = ?,"
                    + " user_fullname = ?,"
                    + " user_status = ?,"
                    + " user_password = MD5(?)"
                    + "WHERE user_name = ?";
            
            try {
                ps = konek.prepareCall(query);
                
                ps.setString(1, user_email);
                ps.setString(2, user_fulname);
                ps.setInt(3,user_status);
                ps.setString(4,user_pasword);
                ps.setString(5, user_name);
                
                ps.executeUpdate();
                ps.close();
                JOptionPane.showMessageDialog(null, "User Berhasil Di Ubah");
                
            } catch (SQLException sQLException) {
                JOptionPane.showMessageDialog(null, "User Gagal Di Uabh");
            }
            
        }
    }

}
    

