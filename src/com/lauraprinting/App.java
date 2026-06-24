package com.lauraprinting;

import com.formdev.flatlaf.FlatLightLaf;
import com.lauraprinting.config.DatabaseConfig;
import com.lauraprinting.ui.LoginFrame;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        System.out.println("Memulai aplikasi Laura Printing...");

        // 1. Inisialisasi Database & Jalankan Migrasi Otomatis
        DatabaseConfig.initializeDatabase();

        // 2. Konfigurasi Tema/Tampilan GUI dengan FlatLaf
        try {
            FlatLightLaf.setup();
            
            // Mengatur setelan visual modern (sudut melengkung)
            UIManager.put("Button.arc", 12);
            UIManager.put("Component.arc", 12);
            UIManager.put("TextComponent.arc", 12);
            UIManager.put("TableHeader.background", new java.awt.Color(241, 245, 249));
            UIManager.put("ScrollBar.thumbArc", 999);
            UIManager.put("ScrollBar.trackArc", 999);
            
            System.out.println("Tampilan UI FlatLaf berhasil dikonfigurasi.");
        } catch (Exception e) {
            System.err.println("Gagal mengatur Tampilan UI FlatLaf, menggunakan tema bawaan.");
            e.printStackTrace();
        }

        // 3. Jalankan Layar Login pada Event Dispatch Thread Swing
        SwingUtilities.invokeLater(() -> {
            new LoginFrame().setVisible(true);
        });
    }
}
