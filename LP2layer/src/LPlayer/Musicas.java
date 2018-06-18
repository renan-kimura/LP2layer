package LPlayer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import pkgTree.Trie;

public class Musicas implements ManipularArqMusicas {
	private ListProperty<String> listaMusicas = new SimpleListProperty<String>();
	Trie musicaTree = new Trie();
	private File file;

	/**
	 * <h3>Função carregar musicas já cadastradas</h3>
	 */
	public void carregarMusicas() {
		String []linha;
		file = new File("data/playListDefault.txt");
		if(!file.exists()) {
			System.out.println("Erro! Contate o suporte.");
		}else {
			try {
				FileReader playListDefault = new FileReader(file);
				try (BufferedReader in = new BufferedReader(playListDefault)){
					while (in.ready()) {
						linha = in.readLine().split(";");
						musicaTree.insert(linha[0], linha[1]);
						listaMusicas.add(linha[0]);
					}in.close();
				}
			}catch (Exception e) {
				System.out.println("Erro ao carregar arquivo em Musica.java");
			}
		}
		
		
	}
	public void salvarMusicas() {
		file = new File("data/playListDefault.txt");
		if(!file.exists()) {
			System.out.println("Erro! Lista de musica principal nao existe");
		}else {
			
		}
	}
	
	public ListProperty<String> getListaMusicas() {
		return listaMusicas;
	}
	public void setListaMusicas(ListProperty<String> listaMusicas) {
		this.listaMusicas = listaMusicas;
	}
	@Override
	public void leitor() throws IOException {
		// TODO Auto-generated method stub
		
	}
	

}