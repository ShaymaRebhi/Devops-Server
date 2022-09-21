package com.esprit.examen.services;


import com.esprit.examen.entities.SecteurActivite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SecteurActiviteServiceImplTest {

    @Autowired
    ISecteurActiviteService secteurActiviteService;
    private static final Logger l = LogManager.getLogger(StockServiceImpl.class);

    @Test
    public void testRetrieveAllSecteurActivites() throws ParseException {

        List<SecteurActivite> secteurActivites = secteurActiviteService.retrieveAllSecteurActivite();
        int expected = secteurActivites.size();
        SecteurActivite sa = new SecteurActivite(1L,"3a","Papier");
        SecteurActivite secteurActivite = secteurActiviteService.addSecteurActivite(sa);
        assertEquals(expected + 1, secteurActiviteService.retrieveAllSecteurActivite().size());
        secteurActiviteService.deleteSecteurActivite(secteurActivite.getIdSecteurActivite());

    }
    @Test
    public void testAddStock()throws ParseException {
        List<SecteurActivite> stocks = secteurActiviteService.retrieveAllSecteurActivite();
        int expected=stocks.size();
        SecteurActivite sa = new SecteurActivite(2L,"3b","Bois");
        SecteurActivite savedSecteurActivite= secteurActiviteService.addSecteurActivite(sa);

        assertEquals(expected+1, secteurActiviteService.retrieveAllSecteurActivite().size());
        assertNotNull(savedSecteurActivite.getLibelleSecteurActivite());
        secteurActiviteService.deleteSecteurActivite(savedSecteurActivite.getIdSecteurActivite());

    }

    @Test
    public void testAddStockOptimized() {

        SecteurActivite sa = new SecteurActivite(3L,"1a","carton");
        SecteurActivite savedSecteurActivite= secteurActiviteService.addSecteurActivite(sa);
        assertNotNull(savedSecteurActivite.getIdSecteurActivite());
        assertNotNull(savedSecteurActivite.getCodeSecteurActivite());
        secteurActiviteService.deleteSecteurActivite(savedSecteurActivite.getIdSecteurActivite());

    }

    @Test
    public void testDeleteStock() {
        SecteurActivite sa = new SecteurActivite(4L,"1b","Electronique");
        SecteurActivite savedSecteurActivite= secteurActiviteService.addSecteurActivite(sa);
        secteurActiviteService.deleteSecteurActivite(savedSecteurActivite.getIdSecteurActivite());
        assertNull(secteurActiviteService.retrieveSecteurActivite(savedSecteurActivite.getIdSecteurActivite()));
    }

}
