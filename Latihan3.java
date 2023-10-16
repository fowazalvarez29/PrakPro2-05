/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author alvarez
 */
public class Latihan3 extends JFrame {
/**
     * Konstruktor kelas Latihan3 untuk menginisialisasi komponen GUI
     */
    public Latihan3() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Membuat label dengan teks "Form Biodata" yang berada di tengah jendela
        JLabel headerLabel = new JLabel("Form Biodata", JLabel.CENTER);

        // Membuat panel kontrol dan mengatur layoutnya menggunakan FlowLayout
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        // Membuat panel untuk menampung komponen input dan mengatur layoutnya menggunakan GridBagLayout
        JPanel panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();

        // Mengatur posisi dan menambahkan komponen-komponen input ke panel menggunakan GridBagLayout
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 3;
        gbc.gridy = 1;
        panel.add(new JLabel("Jenis Kelamin"), gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        panel.add(new JLabel("Nama: "), gbc);
        gbc.gridx = 2;
        gbc.gridy = 2;
        JTextField namaTextField = new JTextField(5);
        panel.add(namaTextField, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 3;
        panel.add(new JLabel("Nomor HP: "), gbc);
        gbc.gridx = 2;
        gbc.gridy = 4;
        JTextField teleponTextField = new JTextField(5);
        panel.add(teleponTextField, gbc);

        JRadioButton lakiLakiRadioButton = new JRadioButton("Laki-Laki");
        JRadioButton perempuanRadioButton = new JRadioButton("Perempuan");
        
        ButtonGroup group = new ButtonGroup();
        group.add(lakiLakiRadioButton);
        group.add(perempuanRadioButton);

        gbc.gridx = 3;
        gbc.gridy = 2;
        panel.add(lakiLakiRadioButton, gbc);
        
        gbc.gridx = 3;
        gbc.gridy = 3;
        panel.add(perempuanRadioButton, gbc);

        // Membuat objek radio button dan checkbox, lalu menambahkannya ke panel menggunakan GridBagLayout
        JCheckBox wnaCheckBox = new JCheckBox("Warga Negara Asing");
        gbc.gridx = 3;
        gbc.gridy = 4;
        panel.add(wnaCheckBox, gbc);

        gbc.insets = new Insets(20, 0, 20, 0);
        gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridwidth = 2;

        // Membuat tombol "Simpan" dan textarea untuk output, lalu menambahkannya ke panel menggunakan GridBagLayout
        JButton simpanButton = new JButton("Simpan");
        JTextArea txtOutput = new JTextArea(5, 50);

        // Menambahkan aksi ketika tombol "Simpan" ditekan
        simpanButton.addActionListener(new ActionListener() {
            // Logika untuk menangani aksi saat tombol "Simpan" ditekan
            public void actionPerformed(ActionEvent e) {
                // RadioButton Jenis Kelamin
                String jenisKelamin = "";
                if (lakiLakiRadioButton.isSelected()) {
                    jenisKelamin = "Laki-Laki";
                } else if (perempuanRadioButton.isSelected()) {
                    jenisKelamin = "Perempuan";
                }
                
                // Text Output 
                txtOutput.setText("Nama: " + namaTextField.getText() +
                                  "\nJenis Kelamin: " + jenisKelamin +
                                  "\nNomor HP: " + teleponTextField.getText() +
                                  "\nWarga Negara Asing: " + (wnaCheckBox.isSelected() ? "Ya" : "Tidak"));
                
                
                // Mengosongkan kolom input setelah data disimpan
                namaTextField.setText("");
                teleponTextField.setText("");
                group.clearSelection(); // Menghilangkan seleksi radio button
                wnaCheckBox.setSelected(false); // Menghilangkan seleksi CheckBox
            }
        });

         // Menambahkan komponen-komponen ke panel kontrol
        panel.add(simpanButton, gbc);
        controlPanel.add(panel);

        // Mengatur layout jendela menggunakan GridLayout dan menambahkan komponen-komponen ke jendela
        this.setLayout(new GridLayout(3, 1));
        this.add(headerLabel);
        this.add(controlPanel);
        this.add(new JScrollPane(txtOutput));

        // Mengatur ukuran jendela
        this.setSize(500, 500);
    }

    /**
     * Metode main untuk menjalankan aplikasi
     */
    public static void main(String[] args) {
        // Memastikan bahwa kode dijalankan di thread antarmuka pengguna (Event Dispatch Thread)
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Membuat objek Latihan3 dan menampilkannya
                Latihan3 h = new Latihan3();
                h.setVisible(true);
            }
        });
    }
}