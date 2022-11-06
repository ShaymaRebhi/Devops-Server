package com.esprit.examen.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.DetailFacture;
import com.esprit.examen.entities.Operateur;
import com.esprit.examen.repositories.OperateurRepository;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OperateurServiceImplTest {
	
    @Mock
    OperateurRepository operateurRepository;
	
    @InjectMocks
	private OperateurServiceImpl operateurServiceImlp;
	
    final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	
	@Test
    @Order(0)
	void TestAddOperateur(){
		
            Operateur operateur =new Operateur();
            List<Operateur> operateurs = new ArrayList<>();
            for (Long i=1L;i<=8L;i++) {
            	operateur.setIdOperateur(i);
	            operateur.setNom("Mokaddem");
	            operateur.setPassword("123456");
	            operateur.setPrenom("Sofiene");
	            operateurServiceImlp.addOperateur(operateur);
	            LOGGER.info("Operateur added : " + operateur.getNom());
	            operateurs.add(operateurRepository.save(operateur));
            }
            assertEquals(8,operateurs.size());
	}
	
	
	@Test
    @Order(1)
	void TestRetrieveAllOperateur(){
		
        Iterable<Operateur> operateurs = operateurRepository.findAll();
        Assertions.assertNotNull(operateurs);
		
	}
	
	@Test
	@Order(2)
	void TestRetrieveOperateur() {
		
        Operateur operateur = operateurServiceImlp.retrieveOperateur(2L);
        Assertions.assertNotNull(operateur);
	}

	@Test
	@Order(3)
	void TestDeleteAllOperateur(){
		
        operateurRepository.deleteAll();
        assertEquals(0,operateurRepository.findAll().spliterator().estimateSize());
	}
	

}
	

