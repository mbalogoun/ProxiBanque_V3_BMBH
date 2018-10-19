package org.formation.dao;

import org.formation.model.Conseiller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudConseillerDao extends JpaRepository<Conseiller, Integer> {

	// customized methods here

//	List<Conseiller> findAllConseillerByNom(String nom);

//	List<Conseiller> findAllConseillerByLogin(String login);
}
