/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author buiphukhuyen
 */
public class SoundPlayer {
    
    private FileInputStream FIS  ; 
    private Player myPlayer ; 
  
    public void playSound(String path ) { 
        try {                 
            FIS = new FileInputStream(path) ;  
            myPlayer = new Player(FIS) ; 
           
            new Thread (
                () -> {
                    try {
                        myPlayer.play();
                    }
                    catch(Exception e) {
                        System.out.print("Sound Player Error: " + e);
                    }
            }).start();    
        }
        catch(FileNotFoundException | JavaLayerException e ) { 
            JOptionPane.showInputDialog(e.getMessage()) ; 
        }  
    }
}
