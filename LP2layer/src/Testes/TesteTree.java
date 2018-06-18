package Testes;

import static org.junit.Assert.*;
import org.junit.Test;

import pkgTree.Trie;

public class TesteTree {

	@Test
	public void testeInseção_Busca() {
		Trie tree = new Trie();
		tree.insert("folha1.mp3", "raiz/caminho/folha1.mp3");
		tree.insert("folha2.mp3", "raiz/caminho/folha2.mp3");
		tree.insert("tolha1.mp3", "raiz/caminho/tolha3.mp3");
		
		
		
		System.out.println(tree.getValor("folha2.mp3"));
		
		tree.show();
		
		
		
		assertTrue(tree.getValor("tolha1.mp3").equals("raiz/caminho/tolha3.mp3"));
		assertTrue(tree.getValor("folha2.mp3").equals("raiz/caminho/folha2.mp3"));
		assertTrue(!tree.search("folha1"));
		assertTrue(tree.search("folha1.mp3"));
		
		
	}

}
