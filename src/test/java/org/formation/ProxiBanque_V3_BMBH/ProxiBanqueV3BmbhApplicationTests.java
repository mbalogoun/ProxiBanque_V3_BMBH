package org.formation.ProxiBanque_V3_BMBH;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.formation.dao.CrudClientDao;
import org.formation.dao.CrudCompteDao;
import org.formation.dao.CrudConseillerDao;
import org.formation.model.Client;
import org.formation.model.CompteBancaire;
import org.formation.service.ConseillerWebService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProxiBanqueV3BmbhApplicationTests {

	@Autowired
	private CrudConseillerDao crudConseillerDao;
	@Autowired
	private CrudClientDao crudClientDao;
	@Autowired
	private CrudCompteDao crudCompteDao;
	@Autowired
	ConseillerWebService conseillerWebService;
	
	@Test
	public void contextLoads() {
		assertNotNull(crudConseillerDao);
		assertNotNull(crudClientDao);
		assertNotNull(crudCompteDao);
//		Conseiller cons1 = new Conseiller("cons", "conseil", "mohalogin", "lion");
//		assertEquals(cons1, crudConseillerDao.save(cons1));
//		conseillerWebService.getConseiller("3")
		
//		Client c = new Client("1254", "Marant", "marlon", "Fontenay", cons1);
//		assertEquals(c, crudClientDao.save(c));
//		crudClientDao.deleteById(5);
//		System.out.println(crudConseillerDao.findById(3));
//		Client c = new Client("1254", "now", "marlon", "Fontenay", crudConseillerDao.findById(3));
		
		Client c = new Client("1254", "clientcompte1", "marlon", "Fontenay");
		CompteBancaire compte = new CompteBancaire("125a3", "Epargne", 2563.02, c);
		assertEquals(compte, crudCompteDao.save(compte));
		
	}

}
