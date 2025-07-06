
import java.net.URL;
import javax.sound.sampled.*;
public class GameSounds{
    
    Clip nomNom;
    Clip newGame;
    Clip death;
  
    boolean stopped;
       

    public GameSounds(){
        stopped=true; 
        URL url;
        AudioInputStream audioIn;
        
        try{
            // Pacman eating sound
            url = this.getClass().getClassLoader().getResource("nomnom.wav");
            audioIn = AudioSystem.getAudioInputStream(url);
            nomNom = AudioSystem.getClip();
            nomNom.open(audioIn);
            
            // newGame        
            url = this.getClass().getClassLoader().getResource("newGame.wav");
            audioIn = AudioSystem.getAudioInputStream(url);
            newGame = AudioSystem.getClip();
            newGame.open(audioIn);
            
            // death        
            url = this.getClass().getClassLoader().getResource("death.wav");
            audioIn = AudioSystem.getAudioInputStream(url);
            death = AudioSystem.getClip();
            death.open(audioIn);

        }catch(Exception e){}
    }
    
    public void nomNom(){
        
        if (!stopped)
          return;

        stopped=false;
        nomNom.stop();
        nomNom.setFramePosition(0);
        nomNom.loop(Clip.LOOP_CONTINUOUSLY);
    }

    /* Stop pacman eating sound */
    public void nomNomStop(){
        stopped=true;
        nomNom.stop();
        nomNom.setFramePosition(0);
    }
    
    /* Play new game sound */
    public void newGame(){
        newGame.stop();
        newGame.setFramePosition(0);
        newGame.start();
    }
    
    /* Play pacman death sound */
    public void death(){
        death.stop();
        death.setFramePosition(0);
        death.start();
    }
}
