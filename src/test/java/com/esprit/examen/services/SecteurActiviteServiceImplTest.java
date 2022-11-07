package com.esprit.examen.services;


import com.esprit.examen.entities.SecteurActivite;
import com.esprit.examen.repositories.SecteurActiviteRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
public class SecteurActiviteServiceImplTest {

    @Mock
    SecteurActiviteRepository secteurActiviteRepository;
    @InjectMocks
    SecteurActiviteServiceImpl secteurActiviteServiceImpl;


    SecteurActivite secteurActivite = new SecteurActivite("3a","Papier");

    @Test
    public void testRetrieveSecteurActivite() {

        Mockito.when(secteurActiviteRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(secteurActivite));
        SecteurActivite secteurActivite1 = secteurActiviteServiceImpl.retrieveSecteurActivite(2L);
        Assertions.assertNotNull(secteurActivite1);
    }

    @org.junit.jupiter.api.Test
    @Order(0)
    void addSecteurActivite() {
        SecteurActivite secteurActivite = new SecteurActivite();
        List<SecteurActivite> LSecteurActivite = new ArrayList<>();
        for (Long i=3L;i<=10L;i++) {
            secteurActivite.setIdSecteurActivite(i);
            secteurActivite.setCodeSecteurActivite("3w");
            secteurActivite.setLibelleSecteurActivite("lait");
            SecteurActivite dd=secteurActiviteRepository.save(secteurActivite);
            LSecteurActivite.add(dd);
        }
        assertEquals(8,LSecteurActivite.size());
    }
    @org.junit.jupiter.api.Test
    @Order(3)
    void deleteAll() {
        secteurActiviteRepository.deleteAll();
        assertEquals(0,secteurActiviteRepository.findAll().spliterator().estimateSize());
    }
    @org.junit.jupiter.api.Test
    @Order(2)
    void retrieveSecteurActivite() {
        Mockito.when(secteurActiviteRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(secteurActivite))
        ;
        SecteurActivite user1 = secteurActiviteServiceImpl.retrieveSecteurActivite(2L);
        Assertions.assertNotNull(user1);

    }
    @org.junit.jupiter.api.Test
    @Order(4)
    void getSecteurActivite(){
        Iterable<SecteurActivite> LSecteurActivite = secteurActiviteRepository.findAll();
        Assertions.assertNotNull(LSecteurActivite);
    }
}