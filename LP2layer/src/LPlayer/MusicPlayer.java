package LPlayer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;



public class MusicPlayer extends Thread{
	//FileInputStream songFile;
	FileInputStream songFile;
	Player player;


	public MusicPlayer() throws JavaLayerException, FileNotFoundException{
		songFile = new FileInputStream("C:\\Users\\Renan\\Documents\\NetBeansProjects\\LP2layer\\src\\Space Oddity.mp3");
		player = new Player(songFile);
	}

	public Player getPlayer() {
		return player;
	}

	public void run() {
		try {
			player.play();
		} catch (JavaLayerException e) {
			System.out.println("deu ruim");
			e.printStackTrace();
		}
	}

}
