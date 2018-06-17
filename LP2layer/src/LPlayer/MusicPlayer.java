package LPlayer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;



public class MusicPlayer implements Runnable{
	//FileInputStream songFile;
	FileInputStream songFile;
	Player player;
	String currentSong;
	Boolean stop = false;

	
	public MusicPlayer() throws JavaLayerException, FileNotFoundException{
		/*if(currentSong != null) {
		songFile = new FileInputStream(currentSong);
		player = new Player(songFile);
		}*/
	}

	public Player getPlayer() {
		return player;
	}

	public void run() {
		while(!stop) {
			try {
				if(currentSong != null) {
					songFile = new FileInputStream(currentSong);
					player = new Player(songFile);
				}
				player.play();
			} catch (JavaLayerException e) {
				System.out.println("deu ruim");
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void cancel() {
		stop = true;
		Thread.currentThread().interrupt();
	}
	public String getCurrentSong() {
		return currentSong;
	}

	public void setCurrentSong(String currentSong) {
		this.currentSong = currentSong;
	}

}
