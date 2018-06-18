package pkgUsuario;


import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class UsuarioComum extends Usuario {
	String nome;
	String senha;

	File playlist;

	public UsuarioComum(String nome, String senha, String path) {
		super(nome, senha);
		playlist = new File(path);
	}


	public UsuarioComum createUser() {
		
		return this;
	}
	
	
}
