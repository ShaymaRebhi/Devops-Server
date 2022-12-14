/*package com.esprit.examen.services;
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
import java.util.Set;
import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class FactureServiceImplTest {
    @Autowired
    IFactureService factureService;
    @Test
    public void testAddFacture() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = dateFormat.parse("30/09/2000");
        Date date2 = dateFormat.parse("25/10/2000");
        Facture f = new Facture(1f,2f,date1,date2,false);
        Facture savedFacture= factureService.addFacture(f);
        assertNotNull(savedFacture.getIdFacture());
    }
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
        assertNotNull(facture.getIdFacture());
    }
    @Test
    public void testRetrieveAllFactures() throws ParseException {
        List<Facture> factures = factureService.retrieveAllFactures();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = dateFormat.parse("30/09/2000");
        Date date2 = dateFormat.parse("25/10/2000");
        int expected = factures.size();
        Facture f = new Facture();
        f.setDateCreationFacture(date1);
        f.setDateDerniereModificationFacture(date2);
        f.setArchivee(true);
        f.setMontantFacture(1.5f);
        Facture savedFacture= factureService.addFacture(f);
        assertEquals(expected + 1, factureService.retrieveAllFactures().size());
    }
    @Test
    public void testRetrieveFactureByid() throws ParseException {
        Facture facture = factureService.retrieveFacture(1l);
        assertNotNull(facture.getIdFacture());
    }
    @Test
    public void testgetFacturesByFournisseur() throws ParseException {
        Set<Facture> factures =  factureService.getFacturesByFournisseur(2l);
        log.info(" count" + factures.size());
        for (Facture facture : factures) {
            log.info(" facture : " + facture.getMontantFacture()+ " et le fournisseur est  "+facture.getFournisseur().getIdFournisseur());
            assertNotNull(facture.getIdFacture());
        }
    }
    @Test
    public void testCancelFacture() throws ParseException  {
        Facture sa = new Facture();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = dateFormat.parse("30/09/2020");
        Date date2 = dateFormat.parse("05/12/2022");
        sa.setDateCreationFacture(date1);
        sa.setDateDerniereModificationFacture(date2);
        sa.setArchivee(true);
        sa.setMontantFacture(1.5f);
        Facture savedfacture= factureService.addFacture(sa);
        factureService.cancelFacture(savedfacture.getIdFacture());
        assertNotNull(sa.getIdFacture());
    }
}
*/