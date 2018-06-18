package pkgUsuario;

import java.util.ArrayList;

public class Controlador {
	Usuario usuario;
	public Controlador() {
		
	}
	public boolean autenticarUsuario(String usuario) {
		if(!UserManager.checkUser(usuario)) {
			return false;
		}
	}
	
}
