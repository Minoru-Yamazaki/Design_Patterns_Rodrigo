package br.com.fatecmc.esiii.cadcliente.dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class TesteHash {

	public static void main(String[] args) {
		
		EntidadeDominio entidade = new Cliente();
		System.out.println(entidade.getClass().getName());
		
		entidade = new Endereco();
		System.out.println(entidade.getClass().getName());
		
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		
		
		List<String> professores = new ArrayList<String>();
		professores.add("Rodrigo");
		professores.add("Luciano");
		professores.add("Gilberto");
		
		List<String> jogadores = new ArrayList<String>();
		jogadores.add("Neymar");
		jogadores.add("Socrates");
		jogadores.add("Pelé");
		
		
		map.put("Professor", professores);
		map.put("Jogador", jogadores);
		
		
		Set<String> profissoes = map.keySet();
		
		for(String p:profissoes) {
			List<String> keyProfisao = map.get(p);
			System.out.println(p + "\n");
			for(String k:keyProfisao) {
				System.out.println(k);
			}
			System.out.println("-----------\n");
		}
	}

}
