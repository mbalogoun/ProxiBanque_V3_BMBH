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
import org.formation.model.Conseiller;

@Path("/conseillerservice")
public interface ConseillerWebService {

	@GET
	@Path("/conseillers/{id}/")
	Conseiller getConseiller(@PathParam("id") String id);

	@GET
	@Path("/conseillers")
	List<Conseiller> getConseillers();

	@PUT
	@Path("/conseillers/")
	Response updateConseiller(Conseiller conseiller);

	@POST
	@Path("/conseillers/")
	Response addConseiller(Conseiller conseiller);

	@DELETE
	@Path("/conseillers/{id}/")
	Response deleteConseiller(@PathParam("id") String id);
	
	@GET
	@Path("/conseillers/{login}/{pwd}")
	List<Client> getListeClientsConseiller(@PathParam("login") String login,
			@PathParam("pwd") String pwd);

}
