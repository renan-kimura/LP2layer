package pkgUsuario;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class GerenciadorUsuario {
	
	public GerenciadorUsuario() {
	}
	
	/**
	 * <h3>Função para verificar se usuario ja esta cadastrado.</h3>
	 * @param usuario
	 * @param senha
	 * @return boolean
	 */
	public boolean checkUsuario(String usuario, String senha) {
		String []linha;
		File data = new File("pkgUsuario/usuarioData.txt");
		if(!data.exists()){
			System.out.println("Erro. Contate o suporte ao sistema!");
		}else {
			try {
				FileReader users = new FileReader(data);
				try(BufferedReader in = new BufferedReader(users)){
					while (in.ready()) {
						linha = in.readLine().split(";");
						if(linha[0].equalsIgnoreCase(usuario)&& linha[1].equals(senha)) {
							return true;
						}
					}in.close();
				}
			}catch (Exception e) {
				System.out.println("Erro! Contate o suporte.");
			}
		}return false;
	}
	/**
	 * <h3>Função retorna Usuario já cadastrado.</h3>
	 * @param nome
	 * @return Usuario
	 */
	public Usuario getUsuario(String nome) {
		String []linha;
		File data = new File("data/users.txt");
		if(!data.exists()){
			System.out.println("Erro. Contate o suporte ao sistema!");
		}else {
			try {
				FileReader users = new FileReader(data);
				try(BufferedReader in = new BufferedReader(users)){
					while (in.ready()) {
						linha = in.readLine().split(";");
						if(linha[0].equals(nome)) {
							return new Usuario(linha);
						}
					}in.close();
				}
			}catch (Exception e) {
				System.out.println("Erro! Contate o suporte.");
			}
		}return null;
	}
	
	

}
