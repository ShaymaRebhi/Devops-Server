package com.esprit.examen.services;

import com.esprit.examen.entities.Produit;
import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProduitServiceImplTest {
	 @Autowired
	    IProduitService produitService;
	    private static final Logger l = LogManager.getLogger(ProduitServiceImpl.class);

	    @Test
	    public void testRetrieveAllProduit() throws ParseException {

			List<Produit> produit = produitService.retrieveAllProduits();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date date11 = dateFormat.parse("30/09/2000");
			Date date12 = dateFormat.parse("30/09/2010");
			Produit sa = new Produit(date11, date12);
			Produit savedProduit = produitService.addProduit(sa);
			System.out.print("Produit " + sa);
			assertNotNull(sa.getIdProduit());

			produitService.retrieveProduit(sa.getIdProduit());

			List<Produit> Produits = produitService.retrieveAllProduits();
			System.out.print("Produit " + Produits);
		}
	@Test
	public void testDeleteProduit() throws ParseException {

		List<Produit> Produits = produitService.retrieveAllProduits();
			int expected = Produits.size();
			Long idFour=(long) 2;
			//assertEquals(expected + 1, produitService.retrieveAllProduits().size());
		System.out.print("size "+Produits.size());
			l.info(" count" + Produits.size());
		produitService.deleteProduit(1L);
		System.out.print("size2 "+produitService.retrieveAllProduits().size());

	}
	@Test
	public void testAddProduit() throws ParseException{
		List<Produit> Produits = produitService.retrieveAllProduits();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date1 = dateFormat.parse("10/02/2020");
		Date date2 = dateFormat.parse("12/09/2022");
		Produit p = new Produit(date1, date2);
		System.out.print("produit \n "+p);
		Produit savedProduit= produitService.addProduit(p);

		System.out.print("size1 "+Produits.size());
		produitService.deleteProduit(savedProduit.getIdProduit());
		List<Produit> Produits1 = produitService.retrieveAllProduits();
		System.out.print("size2 "+Produits1.size());
	}
}
