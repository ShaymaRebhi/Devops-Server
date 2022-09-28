package com.esprit.examen.services;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.Operateur;

@SpringBootTest
public class OperateurServiceImplTest {
	
	@Autowired
	private OperateurServiceImpl operateurServiceImlp;
	
	
	@Test
	public void TestOperateur(){
		
		try {/*
            Operateur operateur =new Operateur();
            operateur.setNom("taboubi");
            operateur.setPassword("123456");
            operateur.setPrenom("Sofiene");
            operateurServiceImlp.addOperateur(operateur);
            */
            //operateurServiceImlp.retrieveAllOperateurs();
            
            Operateur operateur = operateurServiceImlp.retrieveOperateur((long) 1);
            operateur.setNom("Tijeni");
            operateurServiceImlp.updateOperateur(operateur);
            //operateurServiceImlp.deleteOperateur(operateur.getIdOperateur());

        }catch (Exception e){


            System.out.println(e.getMessage());
        }
		
	}

}
	

