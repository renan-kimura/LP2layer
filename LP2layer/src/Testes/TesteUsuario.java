package Testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pkgUsuario.GerenciadorUsuario;

class TesteUsuario {

	@Test
	void testeCheckUsuario() {
		new GerenciadorUsuario().getUsuario("root");
		assertTrue(new GerenciadorUsuario().checkUsuario("root", "root"));
	}
}
