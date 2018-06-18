package pkgMusica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import pkgTree.Trie;

public class PlaylistComum implements ManipularArqMusicas {
	Trie musicas;
	File file = new File("data/playlist/default.txt");
	
	public PlaylistComum() {
		musicas = new Trie();
	}
	@Override
	public void carregarMusicas() {
		String []linha;
		if(!file.exists()) {
			System.out.println("Erro! Contate o suporte.");
		}else {
			try {
				FileReader musics = new FileReader(file);
				try (BufferedReader in = new BufferedReader(musics)){
					while (in.ready()) {
						linha = in.readLine().split(";");
						musicas.insert(linha[0], new Musica(linha[0], linha[1]));
						System.out.println(linha[0]+" "+linha[1]);
					}in.close();
				}
			}catch (Exception e) {
				System.out.println("Erro ao carregar arquivo em Musica.java");
				e.printStackTrace();
			}
		}
		
		
	}

	@Override
	public void salvarMusicas() {
		if(!file.exists()) {
			System.out.println("Erro! Lista de musica principal nao existe");
		}else {
			if(!file.exists()) {
				System.out.println("Erro em Musicas.java:48! Contate o suporte.");
			}else {
				try {
					FileWriter playList = new FileWriter(file);
					try(BufferedWriter out = new BufferedWriter(playList)){
						out.write(musicas.toString());
						out.close();
					}playList.close();
				}catch (Exception e) {
					System.out.println("Erro Musica.java:58! contate o suporte");
				}
			}
		}
	}
}
