/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author buiphukhuyen
 */
public class StartPanel extends JPanel {

    SoundPlayer mySound = new SoundPlayer();

    public StartPanel() {
        setLayout(null);
        setBounds(0, 0, 1200, 700);

        /*Hình nền cho Game: Đối tượng tự tạo ImagePanel - Một panel có chức năng Load ảnh */
        ImagePanel background = new ImagePanel("images/background.png", 0, 0, 1200, 700);

        //Thêm các button chức năng
        Icon bug1 = new ImageIcon(getClass().getResource("images/btn_1player.jpg"));
        JButton oneButton = new JButton(bug1);
        
        Icon bug2 = new ImageIcon(getClass().getResource("images/btn_2players.jpg"));
        JButton twoButton = new JButton(bug2);
        
        Icon bug3 = new ImageIcon(getClass().getResource("images/btn_socket.jpg"));
        JButton socketButton = new JButton(bug3);

        //Định vị trí các button 
        oneButton.setBounds(475, 280, 250, 75);
        twoButton.setBounds(475, 360, 250, 75);
        socketButton.setBounds(475, 440, 250, 75);
        
        add(oneButton);
        add(twoButton);
        add(socketButton);

        this.add(background);

    }

}