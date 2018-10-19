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
import org.formation.model.MontantVirement;

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
	
	@PUT
	@Path("/comptes/{id1}/{id2}/")
	Response faireVirement(@PathParam("id1") String id1, @PathParam("id2") String id2, MontantVirement montant);
}
