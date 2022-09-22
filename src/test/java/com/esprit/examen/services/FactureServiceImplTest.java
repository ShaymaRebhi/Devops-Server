package com.esprit.examen.services;


import java.text.SimpleDateFormat;
import java.util.Date;

import com.esprit.examen.entities.Facture;
import com.esprit.examen.entities.SecteurActivite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FactureServiceImplTest {

	 @Autowired
	    IFactureService factureService;
	    private static final Logger l = LogManager.getLogger(FactureServiceImpl.class);

	    @Test
	    public void testRetrieveAllFacture() throws ParseException {

	      /*  List<Facture> Facture = factureService.retrieveAllFactures();
	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date date11 = dateFormat.parse("30/09/2000");
			Date date12 = dateFormat.parse("30/09/2010");
	        Facture sa = new Facture(date11,date12);
	        Facture savedFacture= factureService.addFacture(sa);
	        System.out.print("facture "+savedFacture);
	        assertNotNull(sa.getIdFacture());
	        assertNotNull(sa.getDetailsFacture());
			factureService.retrieveFacture(sa.getIdFacture());

			List<Facture> factures = factureService.retrieveAllFactures();
			int expected = factures.size();
			Long idFour=(long) 2;
			assertEquals(expected + 1, factureService.retrieveAllFactures().size());
			List<Facture> factures1 = factureService.getFacturesByFournisseur(idFour);
			l.info(" count" + factures1.size());
			for (Facture f : factures1) {
				l.info(" date creation : " + f.getDateCreationFacture()+ " Dernier modi "+f.getDateDerniereModificationFacture());
			}*/
	    }
	
}
