package com.esprit.examen.services;
import com.esprit.examen.entities.DetailFacture;
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
import java.util.Optional;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DetailFactureImplTest {
    @Autowired
    IDetailFactureService detailfactureService;


    @Test
    public void testRetrieveDetailFactureByid() throws ParseException {

        DetailFacture detailfacture = detailfactureService.retrieveDetailFactureById(2l);
        log.info(" Detail facture" + detailfacture);
        System.out.print("facture "+detailfacture);



    }

}
