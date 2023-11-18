package com.BackUtilisateur.dao;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.repository.CrudRepository;

import com.BackUtilisateur.modele.Utilisateur;





public interface UtilisateurRepository extends CrudRepository<Utilisateur, Integer> {
	
	Optional<Utilisateur> findByMail(String mail);
	
	 List<Utilisateur> findByNomAndPrenom(String nom, String prenom);
	 
	 
	 

}
