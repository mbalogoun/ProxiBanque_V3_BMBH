package org.formation.service;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.core.Response;

import org.formation.dao.CrudClientDao;
import org.formation.model.Client;
import org.springframework.beans.factory.annotation.Autowired;

public class ClientWebServiceImpl implements ClientWebService {

	@Autowired
	private CrudClientDao crudClientDao;
	
	@Override
	public Client getClient(String id) {
		Optional<Client> optional = crudClientDao.findById(Integer.valueOf(id));
		return optional.get();
	}

	@Override
	public List<Client> getClients() {
		return crudClientDao.findAll();
	}

	@Override
	public Response updateClient(Client client) {
		crudClientDao.save(client);
		return Response.ok().build();
	}

	@Override
	public Response addClient(Client client) {
		crudClientDao.save(client);
		return Response.ok().build();
	}

	@Override
	public Response deleteClient(String id) {
		crudClientDao.deleteById(Integer.valueOf(id));;
		return Response.ok().build();
	}

}
