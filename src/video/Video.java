/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package video;

/**
 *
 * @author sagar
 */
import java.io.File;
import javax.swing.JFileChooser;



public class Video {
    String mediaPath="";
   public Video(String mediaPath)
    {
        this.mediaPath=mediaPath;
    }
   // private static final JFileChooser ourFileSelector = new JFileChooser();

    public void t(){
        String vlcPath="C:\\Program Files (x86)\\VideoLAN\\VLC";
        
        //File ourFile;
//
//
//        ourFileSelector.setFileSelectionMode(JFileChooser.FILES_ONLY);
//        ourFileSelector.showSaveDialog(null);
//        ourFile = ourFileSelector.getSelectedFile();
//        mediaPath = ourFile.getAbsolutePath();
        new cvideo(vlcPath,mediaPath).run();
    }
}