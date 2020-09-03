
package video;

/**
 *
 * @author sagar
 */
import com.sun.jna.NativeLibrary;
import javax.swing.JFrame;
import uk.co.caprica.vlcj.component.EmbeddedMediaListPlayerComponent;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

    public class cvideo {
        private final JFrame ourFrame = new JFrame();
        private final EmbeddedMediaPlayerComponent ourMediaPlayer;
        private String mediaPath="";



        cvideo(String vlcPath,String mediaURL){
        this.mediaPath = mediaURL;
        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(),vlcPath);
        ourMediaPlayer = new EmbeddedMediaListPlayerComponent();
        ourFrame.setContentPane(ourMediaPlayer);
        ourFrame.setSize(500, 500);
        ourFrame.setVisible(true);
        ourFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        }
        public void run(){
        ourMediaPlayer.getMediaPlayer().playMedia(mediaPath);
        }
    }