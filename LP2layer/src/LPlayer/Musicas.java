package LPlayer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import pkgMusica.ManipularArqMusicas;
import pkgTree.Trie;

public class Musicas implements ManipularArqMusicas {
	private ArrayList<String> nomeMusica = new ArrayList<String>();
	Trie musicaTree = new Trie();
	private File file;

	/**
	 * <h3>Função carregar musicas já cadastradas</h3>
	 */
	public void carregarMusicas() {
		String []linha;
		file = new File("/home/viniciusrvk/git/LP2layer/LP2layer/data/playlist/default.txt");
		if(!file.exists()) {
			System.out.println("Erro! Contate o suporte.");
		}else {
			try {
				FileReader musics = new FileReader(file);
				try (BufferedReader in = new BufferedReader(musics)){
					while (in.ready()) {
						String tmp = in.readLine();
						linha = tmp.split(";");
						tmp = linha[0];
						musicaTree.insert(linha[0], linha[1]);
						nomeMusica.add(tmp);
						System.out.println(linha[0]+" "+linha[1]);
					}in.close();
				}
			}catch (Exception e) {
				System.out.println("Erro ao carregar arquivo em Musica.java");
			}
		}
		
		
	}
	public void salvarMusicas() {
		file = new File("data/playlist/playListDefault.txt");
		if(!file.exists()) {
			System.out.println("Erro! Lista de musica principal nao existe");
		}else {
			file = new File("data/playlist/playListDefault.txt");
			if(!file.exists()) {
				System.out.println("Erro em Musicas.java:53! Contate o suporte.");
			}else {
				try {
					FileWriter playList = new FileWriter(file);
					try(BufferedWriter out = new BufferedWriter(playList)){
						for (String string : nomeMusica) {
							out.write(string+";"+musicaTree.getValor(string));
						}out.close();
					}playList.close();
				}catch (Exception e) {
					System.out.println("Erro Musica.java:63! contate o suporte");
				}
			}
		}
	}
	public void salvarMusicas(String playlistPessoal) {
		file = new File("data/playlist/"+playlistPessoal+".txt");
		if(!file.exists()) {
			System.out.println("Erro! Lista de musica principal nao existe");
		}else {
			file = new File("data/playlist/playListDefault.txt");
			if(!file.exists()) {
				System.out.println("Erro em Musicas.java:53! Contate o suporte.");
			}else {
				try {
					FileWriter playList = new FileWriter(file);
					try(BufferedWriter out = new BufferedWriter(playList)){
						for (String string : nomeMusica) {
							out.write(string+";"+musicaTree.getValor(string));
						}out.close();
					}playList.close();
				}catch (Exception e) {
					System.out.println("Erro Musica.java:63! contate o suporte");
				}
			}
		}
	}
	
	
	public String getMusica(String nome) {
		return (String)musicaTree.getValor(nome);
	}
	public String getNomeMusica(String caminho){
		String tmp[] = caminho.split("/");
		String nome = tmp[tmp.length-1];
		tmp = nome.split(".mp3");
		nome = tmp[0];
		return nome;
	}
	
	public ArrayList<String> getnomeMusica() {
		return nomeMusica;
	}
	public void setNomeMusica(ArrayList<String> nomeMusica) {
		this.nomeMusica = nomeMusica;
	}
	@Override
	public void leitor() throws IOException {
		// TODO Auto-generated method stub
		
	}
	

}