package org.formation.service;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.core.Response;

import org.formation.dao.CrudCompteDao;
import org.formation.model.CompteBancaire;
import org.springframework.beans.factory.annotation.Autowired;

public class CompteWebServiceImpl implements CompteWebService {

	@Autowired
	private CrudCompteDao crudCompteDao;
	
	@Override
	public CompteBancaire getCompteBancaire(String id) {
		Optional<CompteBancaire> optional = crudCompteDao.findById(Integer.valueOf(id));
		return optional.get();
	}

	@Override
	public List<CompteBancaire> getCompteBancaires() {
		return crudCompteDao.findAll();
	}

	@Override
	public Response updateCompteBancaire(CompteBancaire compteBancaire) {
		crudCompteDao.save(compteBancaire);
		return Response.ok().build();
	}

	@Override
	public Response addCompteBancaire(CompteBancaire compteBancaire) {
		crudCompteDao.save(compteBancaire);
		return Response.ok().build();
	}

	@Override
	public Response deleteCompteBancaire(String id) {
		crudCompteDao.deleteById(Integer.valueOf(id));;
		return Response.ok().build();
	}

}
