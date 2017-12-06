package br.com.cc.login.controllers;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.cc.login.models.Usuario;

@RestController
@Transactional
public class GeracaoDeCoisasController {

	@PersistenceContext
	private EntityManager em;

	private List<Usuario> geraUsuariosEAmigos() {
		Usuario juliano = new Usuario("juliano", "123456");
		Usuario diego = new Usuario("diego", "123456");
		Usuario sergio = new Usuario("sergio", "123456");
		Usuario fernando = new Usuario("fernando", "1");
		
		em.persist(juliano);
		em.persist(diego);
		em.persist(sergio);
		em.persist(fernando);

		return Arrays.asList(juliano,diego, sergio, fernando);
	}

	
	@GetMapping("/gera/dados")
	public String geraDados(){
		List usuariosRegistrados = em.createQuery("select u from Usuario u").getResultList();
		if(!usuariosRegistrados.isEmpty()){
			return "<p>Opa, você já gerou os dados, não precisa rodar essa url de novo</p>";
		}
		List<Usuario> usuarios = geraUsuariosEAmigos();
		return "<p>os dados foram gerados e inseridos no banco de dados <b>loginDatabase</b></p>";
	}
}
