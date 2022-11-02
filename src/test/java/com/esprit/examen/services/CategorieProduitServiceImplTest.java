package com.esprit.examen.services;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.entities.Produit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.esprit.examen.entities.Operateur;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategorieProduitServiceImplTest {

    @Autowired
    ICategorieProduitService categorieProduitService;
    private static final Logger l = LogManager.getLogger(CategorieProduitServiceImpl.class);
    @Test
    public void testRetrieveAllProduit() throws ParseException {

        List<CategorieProduit> categorieProduit = categorieProduitService.retrieveAllCategorieProduits();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date11 = dateFormat.parse("30/09/2000");
        Date date12 = dateFormat.parse("30/09/2010");
        String c = "123";
        String L = "delice";

        CategorieProduit sa = new CategorieProduit(c, L);
        CategorieProduit savedProduit = categorieProduitService.addCategorieProduit(sa);
        System.out.print("Categorie Produit " + sa);
        CategorieProduit sa2 = new CategorieProduit("125665", "kgkfglkg");
        CategorieProduit savedProduit2 = categorieProduitService.addCategorieProduit(sa2);
        assertNotNull(sa.getIdCategorieProduit());

        categorieProduitService.retrieveCategorieProduit(sa.getIdCategorieProduit());

        List<CategorieProduit> CategorieProduits = categorieProduitService.retrieveAllCategorieProduits();
        System.out.print("Categorie Produit " + CategorieProduits);
        l.info(sa2);
    }
    @Test
    public void testDeleteCategorieProduit() throws ParseException {

        List<CategorieProduit> CategorieProduits = categorieProduitService.retrieveAllCategorieProduits();
        int expected = CategorieProduits.size();
        Long idFour=(long) 2;
        //assertEquals(expected + 1, categorieProduitService.retrieveAllCategorieProduits().size());
        System.out.print("size "+CategorieProduits.size());
        l.info(" count" + CategorieProduits.size());
        categorieProduitService.deleteCategorieProduit(1L);
        System.out.print("size2 "+categorieProduitService.retrieveAllCategorieProduits().size());

    }


    @Test
    public void testAddCategorieProduit() throws ParseException{
        List<CategorieProduit> CategorieProduits = categorieProduitService.retrieveAllCategorieProduits();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        CategorieProduit p = new CategorieProduit("date1", "date2");
        System.out.print("produit \n "+p);
        CategorieProduit savedProduit= categorieProduitService.addCategorieProduit(p);

        System.out.print("size1 "+CategorieProduits.size());
        categorieProduitService.deleteCategorieProduit(savedProduit.getIdCategorieProduit());
        List<CategorieProduit> CategorieProduits1 = categorieProduitService.retrieveAllCategorieProduits();
        System.out.print("size2 "+CategorieProduits1.size());
    }
















}
