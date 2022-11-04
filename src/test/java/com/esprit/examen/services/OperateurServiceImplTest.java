package com.esprit.examen.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.Operateur;

import static org.junit.Assert.*;

import java.lang.invoke.MethodHandles;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootTest
class OperateurServiceImplTest {
	
	@Autowired
	private OperateurServiceImpl operateurServiceImlp;
	
    final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	
	@Test
	void TestAddOperateur(){
		
		try {
            Operateur operateur =new Operateur();
            operateur.setNom("taboubi");
            operateur.setPassword("123456");
            operateur.setPrenom("Sofiene");
            operateurServiceImlp.addOperateur(operateur);
            LOGGER.info("Operateur added : " + operateur.getNom());
            assertNotNull(operateur.getIdOperateur());

        }catch (Exception e){


        	LOGGER.info(e.getMessage());
        }
		
	}
	
	@Test
	void TestUpdateOperateur(){
		
		try {
            Operateur operateur =new Operateur();
            operateur.setNom("Mokaddem");
            operateur.setPassword("123456");
            operateur.setPrenom("Sofiene");
            operateurServiceImlp.addOperateur(operateur);
            Operateur operateurUpdate = operateurServiceImlp.retrieveOperateur(operateur.getIdOperateur());
            operateurUpdate.setNom("TEST");
            operateurServiceImlp.updateOperateur(operateurUpdate);
            LOGGER.info("Operaeur updated : " + operateurUpdate.getNom());

    		assertEquals("TEST",operateurUpdate.getNom());

        }catch (Exception e){


        	LOGGER.info(e.getMessage());
        }
		
	}
	
	@Test
	void TestRetrieveAllOperateur(){
		
		try {
			List<Operateur> operateurs =  operateurServiceImlp.retrieveAllOperateurs();
            LOGGER.info("Retrieve All Operateur work");
            int expected = operateurs.size();
            Operateur operateur =new Operateur();
            operateur.setNom("Mokaddem");
            operateur.setPassword("123456");
            operateur.setPrenom("Sofiene");
            operateurServiceImlp.addOperateur(operateur);

            assertEquals(expected+1, operateurServiceImlp.retrieveAllOperateurs().size());

        }catch (Exception e){


        	LOGGER.info(e.getMessage());
        }
		
	}

	@Test
	void TestDeleteOperateur(){
		
		try {
            Operateur operateur =new Operateur();
            operateur.setNom("Mokaddem");
            operateur.setPassword("123456");
            operateur.setPrenom("Sofiene");
            operateurServiceImlp.addOperateur(operateur);
			operateurServiceImlp.deleteOperateur(operateur.getIdOperateur());
            LOGGER.info("Operaeur deleted");
            assertNull(operateurServiceImlp.retrieveOperateur(operateur.getIdOperateur()));

        }catch (Exception e){


        	LOGGER.info(e.getMessage());
        }
		
	}


}
	

