package pkgUsuario;

public abstract class Usuario {
	String nome;
	String senha;
	
	public Usuario(String nome, String senha) {
		this.nome = nome;
		this.senha = senha;
	}
}
