package org.formation.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.formation.model.CompteBancaire;

@Path("/compteservice")
public interface CompteWebService {
	@GET
	@Path("/comptes/{id}/")
	CompteBancaire getCompteBancaire(@PathParam("id") String id);

	@GET
	@Path("/comptes")
	List<CompteBancaire> getCompteBancaires();

	@PUT
	@Path("/comptes/")
	Response updateCompteBancaire(CompteBancaire compteBancaire);

	@POST
	@Path("/comptes/")
	Response addCompteBancaire(CompteBancaire compteBancaire);

	@DELETE
	@Path("/comptes/{id}/")
	Response deleteCompteBancaire(@PathParam("id") String id);
}
