package pkgUsuario;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class GerenciadorUsuario {
	File data;
	/**
	 * <h3>Função para verificar se usuarioVip ja esta cadastrado.</h3>
	 * @param usuarioVip
	 * @param senha
	 * @return boolean
	 */
	public boolean checkUsuario(String usuario, String senha) {
		String []linha;
		data = new File("data/usuarios/usuarioData.txt");
		if(!data.exists()){
			System.out.println("Erro. Contate o suporte do sistema!");
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
	 * <h3>Função retorna UsuarioVip já cadastrado.</h3>
	 * @param nome
	 * @return UsuarioVip
	 */
	public UsuarioVip getUsuario(String nome) {
		String []linha;
		data = new File("data/users.txt");
		if(!data.exists()){
			System.out.println("Erro. Contate o suporte ao sistema!");
		}else {
			try {
				FileReader users = new FileReader(data);
				try(BufferedReader in = new BufferedReader(users)){
					while (in.ready()) {
						linha = in.readLine().split(";");
						if(linha[0].equals(nome)) {
							return new UsuarioVip(linha);
						}
					}in.close();
				}
			}catch (Exception e) {
				System.out.println("Erro! Contate o suporte.");
			}
		}return null; 
	}
	
	

}
