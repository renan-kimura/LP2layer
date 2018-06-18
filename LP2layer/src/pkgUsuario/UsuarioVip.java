package pkgUsuario;

import java.util.ArrayList;
import java.util.Scanner;

public class UsuarioVip extends Usuario{

	ArrayList<String> playList = new ArrayList<String>();// varios caminhos pra playlists
	

	public UsuarioVip(String name, String senha) {
		super(name, senha);
	}

	public UsuarioVip(String[] linha) {
		super(linha[0], linha[1]);
		for (int i = 2; i < linha.length; i++) {
			playList.add(linha[i]);
		}
	}
	public UsuarioVip createUser() {
		String tmp;
		System.out.println("Nome do novo usuarioVip: ");
		Scanner in = new Scanner(System.in);
		tmp = in.next();
		super.setNome(tmp);
		System.out.println("Senha: ");
		tmp = in.next();
		super.setSenha(tmp);
		in.close();
		return this;
	}
	
	public void setPlaylist(ArrayList<String> nova) {
		playList = nova;
	}

	@Override
	public
	Object getPlayList() {
		return playList;
	}
	
}
