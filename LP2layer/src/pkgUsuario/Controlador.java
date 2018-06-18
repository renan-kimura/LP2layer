package pkgUsuario;

import java.util.ArrayList;

public class Controlador {
	UsuarioVip usuarioVip;
	public Controlador() {
		
	}
	public boolean autenticarUsuario(String usuario) {
		if(!UserManager.checkUser(usuario)) {
			return false;
		}
	}
	
}
