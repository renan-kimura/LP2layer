package pkgMusica;

public class Musica {
	private String nome;
	private String path;
	
	public Musica(String n, String p) {
		nome = n;
		path = p;
	}
	public String getNome() {
		return nome;
	}
	public String getPath() {
		return path;
	}
	@Override
	public String toString() {
		return nome+";"+path;
	}
	
}
