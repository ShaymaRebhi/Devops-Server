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
import org.springframework.beans.factory.annotation.Autowired;

public class ProduitServiceImplTest {
	 @Autowired
	    IProduitService produitService;
	    private static final Logger l = LogManager.getLogger(ProduitServiceImpl.class);

	    @Test
	    public void testRetrieveAllProduit() throws ParseException {

	       /* List<Produit> produit = produitService.retrieveAllProduits();
	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date date11 = dateFormat.parse("30/09/2000");
			Date date12 = dateFormat.parse("30/09/2010");
	        Produit sa = new Produit(date11,date12);
	        Produit savedProduit= produitService.addProduit(sa);
	        System.out.print("Produit "+savedProduit);
	        assertNotNull(sa.getIdProduit());
	        assertNotNull(sa.getDetailFacture());
			produitService.retrieveProduit(sa.getIdProduit());

			List<Produit> Produits = produitService.retrieveAllProduits();
			int expected = Produits.size();
			Long idFour=(long) 2;
			assertEquals(expected + 1, produitService.retrieveAllProduits().size());
		
			l.info(" count" + Produits.size());
			
	   */ }
}
