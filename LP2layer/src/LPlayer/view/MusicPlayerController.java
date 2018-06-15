package LPlayer.view;

import java.io.FileNotFoundException;
import java.util.List;
import LPlayer.AllSongs;
import LPlayer.MusicPlayer;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.File;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javazoom.jl.decoder.JavaLayerException;

public class MusicPlayerController extends MusicPlayer {
	//Player p;
	MusicPlayer mp = new MusicPlayer();
	AllSongs musicas;
	public MusicPlayerController() throws JavaLayerException, FileNotFoundException {
		//p = super.getPlayer();
		//load_musics(); //quando ativa isso dá pau no fxml
	}
	@FXML
	Label musica_atual;
	@FXML
	private ListView<String> listview;
	@FXML
	private Button btn_play;
	@FXML
	private Button btn_stop;
	
	@FXML
	public void play_btn() throws FileNotFoundException, JavaLayerException{
		mp.start();
		System.out.println("Entrou");
	}
	@SuppressWarnings("deprecation")
	@FXML
	public void stop_btn() throws InterruptedException {
		mp.stop();
		System.out.println("Pausa");
	}
	@FXML
	public void select_btn(){
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().addAll(
				new ExtensionFilter("Audio Files", "*.mp3"),
				new ExtensionFilter("All files", "*.*"));
		List<File> seletedFiles = fc.showOpenMultipleDialog(null);
		System.out.println("select_btn");
		if(seletedFiles != null) {
			for (int i = 0; i < seletedFiles.size(); i++) {
				listview.getItems().add(seletedFiles.get(i).getName());
			}
		}else{
			System.out.println("cancelou seleção");
		}
	}
	
	@FXML
	public void atual_btn() {
		//musica_atual.setLabelFor(listview.getOnMousePressed());
		listview = new ListView(listview.getOnMouseClicked());
	}
	
	//acho que está correto embora não esteja funcionando. Acho que o problema é o FXML
	public void load_musics() {
		for (int i = 0; i < musicas.getSizeMusica(); i++) {
			String s = musicas.getElementMusica(i);
			listview.getItems().add(i,s);
		}

	}

}