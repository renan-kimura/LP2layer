package LPlayer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;

public class Musicas implements ManipularArqMusicas {
	private ListProperty<String> listaMusicas = new SimpleListProperty<String>();
	String path = "musicas.txt";
	
	private File ArquivoBase = new File(path); //passar cada linha para dentro do ArrayList
	//construtor pega as m�sicas do txt e p�e num List<>
	public Musicas () throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader("/home/viniciusrvk/git/LP2layer/LP2layer/src/musicas.txt"));
		String linha = "";
		while ((linha = buffRead.readLine()) != null) {
			
				//listaMusicas.add(linha);
				System.out.println(linha);
		}
		buffRead.close();
		
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
	/*public ListView<String> load_musicas() {
		ListView<String> listview = new ListView<String>(); 
		for(String m : musicas) {
			listview.setId(m);
		}
		return listview;
	}*/
	public void load_base() {
		/*BufferedReader buffRead = new BufferedReader(new FileReader(path));
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
	/*public int getSizeMusica() {
		return musicas.size();
	}
	public List<String> getMusicas() {
		return this.musicas;
	}
	public String getElementMusica(int index) {
		return musicas.get(index);
	}*/
	public ListProperty<String> getListaMusicas() {
		return listaMusicas;
	}
	public void setListaMusicas(ListProperty<String> listaMusicas) {
		this.listaMusicas = listaMusicas;
	}
	

}