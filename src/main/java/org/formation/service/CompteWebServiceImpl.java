package org.formation.service;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.core.Response;

import org.formation.dao.CrudCompteDao;
import org.formation.model.CompteBancaire;
import org.formation.model.MontantVirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("compteWebService")
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
		CompteBancaire c = crudCompteDao.save(compteBancaire);
		return Response.ok(c).build();
	}

	@Override
	public Response addCompteBancaire(CompteBancaire compteBancaire) {
		CompteBancaire c = crudCompteDao.save(compteBancaire);
		return Response.ok(c).build();
	}

	@Override
	public Response deleteCompteBancaire(String id) {
		crudCompteDao.deleteById(Integer.valueOf(id));
		;
		return Response.ok().build();
	}

	@Override
	public Response faireVirement(String id1, String id2, MontantVirement montant) {
		CompteBancaire c1 = crudCompteDao.findById(Integer.valueOf(id1)).get();
		CompteBancaire c2 = crudCompteDao.findById(Integer.valueOf(id2)).get();
//		List<CompteBancaire> liste = new ArrayList<>();

		if (c1.getSolde() >= montant.getMontant()) {
			c1.setSolde(c1.getSolde() - montant.getMontant());
			c2.setSolde(c2.getSolde() + montant.getMontant());
			crudCompteDao.save(c1);
//			liste.add(c1);
			crudCompteDao.save(c2);
//			liste.add(c2);
		}
		return Response.ok().build();
	}

}
