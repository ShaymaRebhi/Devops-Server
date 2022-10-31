package com.esprit.examen.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.Operateur;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootTest
public class OperateurServiceImplTest {
	
	@Autowired
	private OperateurServiceImpl operateurServiceImlp;
	
    final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	
	@Test
	public void TestAddOperateur(){
		
		try {
            Operateur operateur =new Operateur();
            operateur.setNom("taboubi");
            operateur.setPassword("123456");
            operateur.setPrenom("Sofiene");
            operateurServiceImlp.addOperateur(operateur);
            LOGGER.info("Operateur added : " + operateur.getNom());

        }catch (Exception e){


            System.out.println(e.getMessage());
        }
		
	}
	
	@Test
	public void TestUpdateOperateur(){
		
		try {
            
            Operateur operateur = operateurServiceImlp.retrieveOperateur((long) 1);
            operateur.setNom("Mokaddem");
            operateurServiceImlp.updateOperateur(operateur);
            LOGGER.info("Operaeur updated : " + operateur.getNom());

        }catch (Exception e){


            System.out.println(e.getMessage());
        }
		
	}
	
	@Test
	public void TestRetrieveAllOperateur(){
		
		try {
			operateurServiceImlp.retrieveAllOperateurs();
            LOGGER.info("Retrieve All Operateur work");

        }catch (Exception e){


            System.out.println(e.getMessage());
        }
		
	}

	@Test
	public void TestDeleteOperateur(){
		
		try {
			operateurServiceImlp.deleteOperateur((long) 1);
            LOGGER.info("Operaeur deleted");

        }catch (Exception e){


            System.out.println(e.getMessage());
        }
		
	}

	@Test
	public void TestGetOperateur(){
		
		try {
			Operateur operateur = operateurServiceImlp.retrieveOperateur((long) 1);
            LOGGER.info("Operaeur : " + operateur.getNom());

        }catch (Exception e){


            System.out.println(e.getMessage());
        }
		
	}

}
	

