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
public class SoundPanel extends JPanel {

    JButton soundButton;

    public SoundPanel() {
        setLayout(null);
        setBounds(1090, 10, 60, 60);

        Icon bug1 = new ImageIcon(getClass().getResource("images/sound_on.jpg"));
        soundButton = new JButton(bug1);
        soundButton.setBorderPainted(false);
        soundButton.setBounds(0, 0, 60, 60);
        soundButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
            /*  if (GamePanel.canPlaySound) {
                        GamePanel.canPlaySound = false;
                        Icon bug1 = new ImageIcon(getClass().getResource("images/sound_off.png"));
                        soundButton.setIcon(bug1);
                } else {
                    GamePanel.canPlaySound = true;
                    Icon bug1 = new ImageIcon(getClass().getResource("images/sound_on.png"));
                    soundButton.setIcon(bug1);
                } 
            */
            }
        });
        add(soundButton);
    }
}