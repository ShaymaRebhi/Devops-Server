package com.esprit.examen.services;

import com.esprit.examen.entities.CategorieFournisseur;
import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.repositories.FournisseurRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class FournisseurServiceImplMock {

    @Mock
    FournisseurRepository fournisseurRepository;

    @InjectMocks
    FournisseurServiceImpl fs;

    Fournisseur f= new Fournisseur(12345678910L,"testCode","testLibelle",CategorieFournisseur.CONVENTIONNE);

    List<Fournisseur> listF = new ArrayList<Fournisseur>() {
        {
            add(new Fournisseur(123456789L,"testCode1","testLibelle1",CategorieFournisseur.CONVENTIONNE));
            add(new Fournisseur(123456710L,"testCode2","testLibelle2",CategorieFournisseur.CONVENTIONNE));

        }
    };

    @org.junit.jupiter.api.Test
    @Order(0)
    public void testRetrieveFournissseur() {

        Mockito.when(fournisseurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(f))
        ;
        Fournisseur f1 =  fs.retrieveFournisseur(2022L);
        Assertions.assertNotNull(f1);
    }



    @org.junit.jupiter.api.Test
    @Order(1)
    public void deleteAll() {
        fournisseurRepository.deleteAll();
        assertEquals(0,fournisseurRepository.findAll().spliterator().estimateSize());
    }

    @org.junit.jupiter.api.Test
    @Order(2)
     public void getFournisseurs(){
        Iterable<Fournisseur> fournisseurs = fournisseurRepository.findAll();
        Assertions.assertNotNull(fournisseurs);
    }
}
