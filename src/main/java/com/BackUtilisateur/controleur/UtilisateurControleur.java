/**
 * 
 */
package com.BackUtilisateur.controleur;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.BackUtilisateur.dao.UtilisateurRepository;
import com.BackUtilisateur.modele.Utilisateur;




@RestController
/**
 * @author fanti
 *
 */
public class UtilisateurControleur {

	
	@Autowired
	UtilisateurRepository utilisateurRepository;	
	@RequestMapping("/")
	
	String root() {
		return "Hello from backend Utilisateur AgriEco";
	}
	
	@PostMapping(path = "/ajouterUtilisateur")
	
	public ResponseEntity<Void> creerUtilisateur(@Valid @RequestBody Utilisateur utilisateur) {
		Utilisateur utilisateurAjoute = utilisateurRepository.save(utilisateur);		
		if (utilisateurAjoute == null)
			return ResponseEntity.noContent().build();		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(utilisateurAjoute.getId())
				.toUri();		
		return ResponseEntity.created(uri).build();
	}
	
	
	

	}


