package org.formation.service;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.core.Response;

import org.formation.dao.CrudConseillerDao;
import org.formation.model.Conseiller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("conseillerWebService")
public class ConseillerWebServiceImpl implements ConseillerWebService {

	@Autowired
	private CrudConseillerDao crudConseillerDao;

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
		return null;
	}

	@Override
	public Response addConseiller(Conseiller conseiller) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response deleteConseiller(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
