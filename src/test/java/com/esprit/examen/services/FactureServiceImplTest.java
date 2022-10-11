package com.esprit.examen.services;


import com.esprit.examen.entities.Facture;

import com.esprit.examen.entities.Operateur;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class FactureServiceImplTest {
    @Autowired
    IFactureService factureService;
/*
    @Test

    public void testAddFacture() throws ParseException {
        //	List<Stock> stocks = stockService.retrieveAllStocks();
        //	int expected=stocks.size();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = dateFormat.parse("30/09/2000");
        Date date2 = dateFormat.parse("25/10/2000");

        Facture f = new Facture(1f,2f,date1,date2,false);
        Facture savedFacture= factureService.addFacture(f);

        //	assertEquals(expected+1, stockService.retrieveAllStocks().size());
        assertNotNull(savedFacture.getIdFacture());
        //	stockService.deleteStock(savedStock.getIdStock());

    }
*/
    @Test
    public void testAddFacture1() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = dateFormat.parse("30/09/2000");
        Date date2 = dateFormat.parse("25/10/2000");
        Facture f  = new Facture();
        f.setArchivee(false);
        f.setDateCreationFacture(date1);
        f.setDateDerniereModificationFacture(date2);
        Facture facture = factureService.addFacture(f);
        System.out.print("facture "+facture);
        assertNotNull(facture.getIdFacture());



    }

    @Test
    public void testRetrieveAllFactures() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dateNaissance = dateFormat.parse("30/09/2000");
        List<Facture> factures = factureService.retrieveAllFactures();

        System.out.print("facture "+factures);


    }
    @Test
    public void testRetrieveFactureByid() throws ParseException {

        Facture facture = factureService.retrieveFacture(1l);

        System.out.print("facture "+facture);


    }

    @Test
    public void testgetFacturesByFournisseur() throws ParseException {

Facture f= new Facture();
        List<Facture> factures =  factureService.getFacturesByFournisseur(1l);
        log.info(" count" + factures.size());

      //  System.out.print("facture "+factures);
        for (Facture facture : factures) {
            log.info(" facture : " + facture.getMontantFacture()+ " et le fournisseur est  "+facture.getFournisseur().getIdFournisseur());

        }

    }

/*
    @Test
    public void testAddFactureOptimized() throws ParseException {
        //	List<Stock> stocks = stockService.retrieveAllStocks();
        //	int expected=stocks.size();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = dateFormat.parse("30/09/2000");
        Date date2 = dateFormat.parse("25/10/2000");

        Facture f = new Facture();
        Facture savedFacture= factureService.addFacture(f);
        assertNotNull(savedFacture.getIdFacture());



    }


    @Test
    public void testRetrieveAllFactures() throws ParseException {

        List<Facture> factures = factureService.retrieveAllFactures();
        int expected = factures.size();
        Facture sa = new Facture(2f,3.2f);
        Facture f1 = factureService.addFacture(sa);

    }


    @Test
    public void testDeleteFacture() {
        Facture sa = new Facture();
        Facture savedfacture= factureService.addFacture(sa);
        // factureService.deleteSecteurActivite(savedSecteurActivite.getIdSecteurActivite());
        //assertNull(secteurActiviteService.retrieveSecteurActivite(savedSecteurActivite.getIdSecteurActivite()));
    }

 */
}
