package pkgUsuario;


import java.util.Scanner;

public class UsuarioComum extends Usuario {
	String nome;
	String senha;

	String plailyst = "playListDefault";

	public UsuarioComum(String nome, String senha) {
		super(nome, senha);
	}
	
	

	public UsuarioComum createUser() {
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



	@Override
	public
	Object getPlayList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
