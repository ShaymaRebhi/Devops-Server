package com.esprit.examen.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.CategorieFournisseur;
import com.esprit.examen.entities.DetailFournisseur;
import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.entities.SecteurActivite;

import lombok.extern.slf4j.Slf4j;

import static org.junit.Assert.*;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class FournisseurServiceImplTest {

	
	@Autowired
	IFournisseurService FournisseurService;
	
	@Test
	public void testAddFournisseur()
	{
		Fournisseur f= new Fournisseur();
		f.setCode("njejnjnef");
		f.setLibelle("AAAA");
		f.setCategorieFournisseur(CategorieFournisseur.CONVENTIONNE);
        FournisseurService.addFournisseur(f);
        System.out.println("Fournisseur Code Test => "+f.getCode());
        assertNotNull(f.getIdFournisseur());
		assertNotNull(f.getCategorieFournisseur());
		FournisseurService.deleteFournisseur(f.getIdFournisseur());
  
	}
	
	@Test
	public void testDeleteFournisseur()
	{
		Fournisseur f= new Fournisseur();
		f.setCode("testDelete");
		f.setLibelle("AAAA");
		f.setCategorieFournisseur(CategorieFournisseur.CONVENTIONNE);
        FournisseurService.addFournisseur(f);
        System.out.println("Fournisseur Test => "+f);
        FournisseurService.deleteFournisseur(f.getIdFournisseur());		
        assertNull(FournisseurService.retrieveFournisseur(f.getIdFournisseur()));
	}
	
	@Test
	public void retrieveAllFournisseurs()
	{
		
        List<Fournisseur> fournisseurs= FournisseurService.retrieveAllFournisseurs();
        int expected = fournisseurs.size();
        Fournisseur f= new Fournisseur();
		f.setCode("testRetrieve");
		f.setLibelle("AAAA");
		f.setCategorieFournisseur(CategorieFournisseur.CONVENTIONNE);
        FournisseurService.addFournisseur(f);
        assertEquals(expected+1, FournisseurService.retrieveAllFournisseurs().size());
	}
	
	
	@Test
	public void testUpdateFournisseur()
	{
		Fournisseur f= new Fournisseur();
		f.setCode("testRetrieve");
		f.setLibelle("AAAA");
		f.setCategorieFournisseur(CategorieFournisseur.CONVENTIONNE);
		FournisseurService.addFournisseur(f);
		Fournisseur fr= FournisseurService.retrieveFournisseur(f.getIdFournisseur());
		fr.setCategorieFournisseur(CategorieFournisseur.ORDINAIRE);
		FournisseurService.updateFournisseur(fr);
		assertEquals(CategorieFournisseur.ORDINAIRE,fr.getCategorieFournisseur());
		log.info("test update =>" + fr.getCategorieFournisseur());

	}

	@Test
	public void TestAssignSecteurToFournisseur()
	{
		
		SecteurActivite sa= new SecteurActivite();
		sa.setCodeSecteurActivite("testgtest");
		sa.setLibelleSecteurActivite("testlibelle");
		
		Fournisseur f= new Fournisseur();
		f.setCode("njejnjnef");
		f.setLibelle("AAAA");
		f.setCategorieFournisseur(CategorieFournisseur.CONVENTIONNE);
        FournisseurService.addFournisseur(f);
		assertNotNull(f.getIdFournisseur());

	}
	
}
