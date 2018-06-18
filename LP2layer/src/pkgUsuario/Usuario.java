package pkgUsuario;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {
	private String name;
	private String senha;
	private Boolean vip = false;
	ArrayList<String> playList = new ArrayList<String>(); // LISTA DE MUSICAS 
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	public Usuario(String name, String senha) {
		this.name = name;
		this.senha = senha;
	}

	public Usuario(String[] linha) {
		name = linha[0];
		senha = linha[1];
		if(linha[2].equals("true")){ vip = true;}
		for (int i = 3; i < linha.length; i++) {
			playList.add(linha[i]);
		}
	}
	public Usuario createUser() {
		name = "";
		senha = "";
		System.out.println("Nome do novo usuario: ");
		Scanner in = new Scanner(System.in);
		name = in.nextLine();
		System.out.println("Senha: ");
		senha = in.next();
		return this;
	}
	
}
