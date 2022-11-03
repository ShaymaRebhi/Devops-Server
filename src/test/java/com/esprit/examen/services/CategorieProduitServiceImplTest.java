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

        String c = "123";
        String L = "delice";
        String c1 = "fd1g3f1g";
        String L1 = "Lenovo";
        CategorieProduit sa = new CategorieProduit();
        sa.setCodeCategorie(c);
        sa.setLibelleCategorie(L);
        CategorieProduit savedProduit = categorieProduitService.addCategorieProduit(sa);
        System.out.print("Categorie Produit " + sa);
        CategorieProduit sa2 = new CategorieProduit();
        sa2.setCodeCategorie(c1);
        sa2.setLibelleCategorie(L1);
        CategorieProduit savedProduit2 = categorieProduitService.addCategorieProduit(sa2);
        assertNotNull(sa.getIdCategorieProduit());

        categorieProduitService.retrieveCategorieProduit(sa.getIdCategorieProduit());

        List<CategorieProduit> CategorieProduits = categorieProduitService.retrieveAllCategorieProduits();

        l.info("Categorie Produit " + CategorieProduits);
        l.info(sa2);
    }
    @Test
    public void testDeleteCategorieProduit() throws ParseException {

        List<CategorieProduit> CategorieProduits = categorieProduitService.retrieveAllCategorieProduits();
        int expected = CategorieProduits.size();
        Long idFour=(long) 3;
        assertEquals(expected + 1, categorieProduitService.retrieveAllCategorieProduits().size());

        l.info(" count" + CategorieProduits.size());
        categorieProduitService.deleteCategorieProduit(3L);

        l.info("size2 "+categorieProduitService.retrieveAllCategorieProduits().size());
    }


    @Test
    public void testAddCategorieProduit() throws ParseException{
        List<CategorieProduit> CategorieProduits = categorieProduitService.retrieveAllCategorieProduits();
        String c = "122ff456f";
        String L = "Samsung";
        CategorieProduit p = new CategorieProduit();
        p.setCodeCategorie(c);
        p.setLibelleCategorie(L);
        System.out.print("produit \n "+p);
        CategorieProduit savedProduit= categorieProduitService.addCategorieProduit(p);

        System.out.print("size1 "+CategorieProduits.size());

        List<CategorieProduit> CategorieProduits1 = categorieProduitService.retrieveAllCategorieProduits();
        System.out.print("size2 "+CategorieProduits1.size());
    }
















}
