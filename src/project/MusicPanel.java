/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author buiphukhuyen
 */
public class MusicPanel extends JPanel {

    public static BackgroundMusicPlayer myMusic;
    JButton myButton;

    public MusicPanel() {
        myMusic = new BackgroundMusicPlayer();

        setLayout(null);
        setBounds(1000, 10, 60, 60);

        Icon bug1 = new ImageIcon(getClass().getResource("images/background_music_on.jpg"));

        myButton = new JButton(bug1);

        myButton.setBounds(0, 0, 60, 60);
        myButton.setOpaque(false);
        myButton.setContentAreaFilled(false);
        myButton.setBorderPainted(false);
        
        myButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (myMusic.isPlay == false) {
                    Icon bug1 = new ImageIcon(getClass().getResource("images/background_music_on.jpg"));
                    myButton.setIcon(bug1);
                    System.out.println("stopping : " + myMusic.isStopping);

                    myMusic.isPlay = true;
                    myMusic.isStopping = false;
//                    if (myMusic.firstPress == true) {
//                        myMusic.playMusic(-1);
//                        myMusic.firstPress = false;
//                        myMusic.repeatMusic();
//                    } else {
                        myMusic.resumeMusic();
                        myMusic.repeatMusic();
                   // }

                } else {   // ( my.isPlay = true ) 

                    Icon bug1 = new ImageIcon(getClass().getResource("images/background_music_off.jpg"));
                    myButton.setIcon(bug1);

                    myMusic.isPlay = false;
                    myMusic.isStopping = true;

                    System.out.println("stopping : " + myMusic.isStopping);

                    myMusic.stopMusic();
                }
            }
        });
        add(myButton);
    }

}
