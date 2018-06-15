package LPlayer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

public class AllSongs implements ManipularArqMusicas {
	private List<String> musicas;
	//construtor pega as músicas do txt e põe num List<>
	public AllSongs () throws IOException {
		/*BufferedReader buffRead = new BufferedReader(new FileReader("musicas.txt"));
		String linha = "";
		while (true) {
			if (linha != null) {
				musicas.add(linha);
				System.out.println(linha);

			} else
				break;
			linha = buffRead.readLine();
		}
		buffRead.close();*/
		
		musicas.add("teste");
	}
	@Override
	public void leitor() throws IOException {
		/*BufferedReader buffRead = new BufferedReader(new FileReader("musicas.txt"));
		String linha = "";
		while (true) {
			if (linha != null) {
				musicas.add(linha);
				System.out.println(linha);

			} else
				break;
			linha = buffRead.readLine();
		}
		buffRead.close();*/
	}
	
	
	
	/*public static void escritor(String path) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		String linha = "";
		Scanner in = new Scanner(System.in);
		System.out.println("Escreva algo: ");
		linha = in.nextLine();
		buffWrite.append(linha + "\n");
		buffWrite.close();
	}*/
	public ListView<String> load_musicas() {
		ListView<String> listview = new ListView<String>(); 
		for(String m : musicas) {
			listview.setId(m);
		}
		return listview;
	}

	public int getSizeMusica() {
		return musicas.size();
	}
	public List<String> getMusicas() {
		return this.musicas;
	}
	public String getElementMusica(int index) {
		return musicas.get(index);
	}
}