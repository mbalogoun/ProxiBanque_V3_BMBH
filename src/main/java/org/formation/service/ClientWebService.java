package org.formation.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.formation.model.Client;

@Path("/clientservice")
public interface ClientWebService {

	@GET
	@Path("/clients/{id}/")
	Client getClient(@PathParam("id") String id);

	@GET
	@Path("/clients")
	List<Client> getClients();

	@PUT
	@Path("/clients/")
	Response updateClient(Client Client);

	@POST
	@Path("/clients/")
	Response addClient(Client Client);

	@DELETE
	@Path("/clients/{id}/")
	Response deleteClients(@PathParam("id") String id);
}
