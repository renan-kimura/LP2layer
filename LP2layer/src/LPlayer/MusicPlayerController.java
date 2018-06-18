package LPlayer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javazoom.jl.decoder.JavaLayerException;


public class MusicPlayerController implements Initializable {
	
	List<String> listaDmusicas = new ArrayList<String>();
	@FXML
	Label musica_atual;
	@FXML
	private ListView<String> listview = new ListView<String>();
	@FXML
	private Button btn_play;
	@FXML
	private Button btn_stop;
	
	MusicPlayer mp = new MusicPlayer();
	Musicas musicas;
	int currentId;
	public MusicPlayerController() throws JavaLayerException, IOException {
	}
	
	@FXML
	public void play_btn() throws FileNotFoundException, JavaLayerException{
		mp.stop=false;
		mp.setCurrentSong(musica_atual.getText());
		Thread t1 = new Thread(mp);
		t1.start();
		System.out.println("Entrou");
	}

	@FXML
	public void stop_btn() throws InterruptedException {
		mp.getPlayer().close();
		mp.cancel();
		System.out.println("Stop");
	}
	@FXML
	public void select_btn() throws IOException{
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter("data/musicas.txt"));
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().addAll(
				new ExtensionFilter("Audio Files", "*.mp3"),
				new ExtensionFilter("All files", "*.*"));
		List<File> seletedFiles = fc.showOpenMultipleDialog(null);
		System.out.println("select_btn");
		
		if(seletedFiles != null) {
			for (int i = 0; i < seletedFiles.size(); i++) {
				listview.getItems().add(seletedFiles.get(i).getAbsolutePath());
				//arrumar essa parte para gravar as m�sicas adicionadas
				buffWrite.append(seletedFiles.get(i).getAbsolutePath() + "\n");
			}
			buffWrite.close();
		}else{
			System.out.println("cancelou sele��o");
		}
	}
		
	@FXML
	public void load_musics() {
		for (int i = 0; i < musicas.getListaMusicas().size(); i++) {
			String s = musicas.getListaMusicas().get(i);
			listview.getItems().add(s);
		}
	}
	
	@FXML
	public void selectCurrentSong(MouseEvent e) {
		musica_atual.setText(listview.getSelectionModel().getSelectedItem());
		currentId = listview.getSelectionModel().getSelectedIndex();
	}
	@FXML
	public void removeSeletedSong() {
		final int selectedIdx = listview.getSelectionModel().getSelectedIndex();
		listview.getItems().remove(selectedIdx);
	}
	@FXML
	public void nextSong() throws FileNotFoundException, JavaLayerException, InterruptedException {
		this.stop_btn();
		musica_atual.setText(listview.getItems().get(currentId +1));
		this.play_btn();
	}
	@FXML
	public void prevSong() throws FileNotFoundException, JavaLayerException, InterruptedException {
		this.stop_btn();
		musica_atual.setText(listview.getItems().get(currentId -1));
		this.play_btn();
	}
	@FXML
	public void exitMenu() {
		System.exit(0);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		musicas  = new Musicas();
		BufferedReader buffRead = null;
		try {
			buffRead = new BufferedReader(new FileReader("musicas.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String linha = "";
		try {
			while ((linha = buffRead.readLine()) != null) {
				
					listaDmusicas.add(linha);
					System.out.println(linha);	
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			buffRead.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		listview.itemsProperty().bind(musicas.getListaMusicas());
		listview.setOnMouseClicked(new EventHandler<MouseEvent>(){

	        @Override
	        public void handle(MouseEvent event) {
	        	selectCurrentSong(event);
	        }
	    });
		musicas.getListaMusicas().set(FXCollections.observableArrayList(listaDmusicas));
	}

}