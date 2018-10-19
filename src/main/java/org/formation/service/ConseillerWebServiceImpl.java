package org.formation.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.core.Response;

import org.formation.dao.CrudClientDao;
import org.formation.dao.CrudConseillerDao;
import org.formation.model.Client;
import org.formation.model.Conseiller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("conseillerWebService")
public class ConseillerWebServiceImpl implements ConseillerWebService {

	@Autowired
	private CrudConseillerDao crudConseillerDao;

	@Autowired
	private CrudClientDao crudClientDao;

	@Override
	public Conseiller getConseiller(String id) {
		Optional<Conseiller> optional = crudConseillerDao.findById(Integer.valueOf(id));
		return optional.get();
	}

	@Override
	public List<Conseiller> getConseillers() {
		return crudConseillerDao.findAll();
	}

	@Override
	public Response updateConseiller(Conseiller conseiller) {
		Conseiller c = crudConseillerDao.save(conseiller);
		return Response.ok(c).build();
	}

	@Override
	public Response addConseiller(Conseiller conseiller) {
		Conseiller c = crudConseillerDao.save(conseiller);
		return Response.ok(c).build();
	}

	@Override
	public Response deleteConseiller(String id) {
		crudConseillerDao.deleteById(Integer.valueOf(id));
		return Response.ok().build();
	}

	@Override
	public List<Client> getListeClientsConseiller(String login, String pwd) {
		List<Conseiller> listeCompletCons = crudConseillerDao.findAll();
		Conseiller leConseiller = new Conseiller();
		List<Client> laListe = new ArrayList<>();
		
		for (Conseiller conseiller : listeCompletCons) {
			if (login.equals(conseiller.getLogin()) && pwd.equals(conseiller.getPassword())) {
				leConseiller = conseiller;
				break;
			}
		}

		if (leConseiller != null) {
			List<Client> listeCompletClient = crudClientDao.findAll();
			for (Client client : listeCompletClient) {
				if (client.getConseiller().equals(leConseiller)) {
					laListe.add(client);
				}
			}
		}
		
		return laListe;
	}

}
