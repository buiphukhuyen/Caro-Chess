/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.music;

import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.JPanel;
import javazoom.jl.player.Player;

/**
 *
 * @author buiphukhuyen
 */
public class BackgroundMusicPlayer extends JPanel {

    private int total;   //Tổng số byte của file nhạc  
    private int stop;    //Số byte chưa đọc

    private FileInputStream FIS;
    private Player myPlayer;

    private boolean firstPress = true;
    public boolean isStopping = false;
    public boolean isPlay = true;

    //Phương thức khởi tạo
    public BackgroundMusicPlayer() {
        playMusic(-1);
        isStopping = false;
        repeatMusic();
    }
    
    //Phương thức Chạy Nhạc
    public void playMusic(final int pos) {
        new Thread(() -> {
            try {
                FIS = new FileInputStream("sounds/background_1.mp3");
                System.out.println("total " + total);
                total = FIS.available();
                if (pos > -1) {
                    FIS.skip(pos);
                }
                myPlayer = new Player(FIS);
                myPlayer.play();
            } catch (Exception e) {
                System.out.print("Error Play Music:" + e);
            }
        }).start();;
    }
    
    //Phương thức Dừng Nhạc
    public void stopMusic() {
        try {
            System.out.println("Dừng: " + stop);
            stop = FIS.available();
            myPlayer.close();
        } catch (IOException e) {
        }
    }

    //Phương thức Lặp lại Nhạc
    public void repeatMusic() {
        new Thread(() -> {
            while (isStopping == false) {
                try {
                    Thread.sleep(100);
                    int now = FIS.available();
                    if (now == 0) {
                        playMusic(-1);
                    }
                } catch (Exception e) {
                    System.out.print("Error Repeat Music:" + e);
                }
            }
        }).start();;
    }

    //Phương thức Chạy lại Nhạc
    public void resumeMusic() {
        try {
            System.out.println("Resume" + (total - stop));
            if (stop == 0) {
                playMusic(-1);
            } else {
                playMusic(total - stop);
            }
        } catch (Exception e) {
            System.out.print("Error Resume Music:" + e);
        }

    }

}
