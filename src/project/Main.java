/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * @author buiphukhuyen
 */
public class Main {
    public static JFrame myFrame;
    public static StartPanel myStartPanel = new StartPanel();
   // public static GamePanel myGamePanel = new GamePanel();
   // public static NetworkPanel myNetworkPanel = new NetworkPanel();
   // public static ImagePanel twoLanPlayerPanel = new ImagePanel("images/background.png", 0, 0, 800, 400);
    public static boolean startGame;

    public Main() {
        startGame = true; //Đánh dấu game đã bắt đầu 

        //  Khởi tạo cửa sổ Game   
        myFrame = new JFrame("Caro Game - Java Project");
        myFrame.setResizable(false);
        myFrame.setVisible(true);
        myFrame.setLayout(null);
        myFrame.setBounds(100, 100, 1200, 700);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);
        //Nhạc nền
        MusicPanel myMusicPanel = new MusicPanel();
        myFrame.add(myMusicPanel);

        //Ấm thanh 
        SoundPanel mySoundPanel = new SoundPanel();

        //Thêm button nhạc nền và âm thanh vào Frame chính 
        myFrame.add(mySoundPanel);
        myFrame.repaint();

        //Khởi chạy menu start game 
        myFrame.add(myStartPanel);

    }

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {

        try { // sử Jato libary có chức năng thay đổi giao diện game đẹp hơn 
            UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
        } catch (Exception e) {
        };
        Main myMain = new Main();
    }
}