package com.esprit.examen.services;
import com.esprit.examen.entities.DetailFacture;
import com.esprit.examen.repositories.DetailFactureRepository;
import org.junit.jupiter.api.*;
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
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
@SpringBootTest

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
 class DetailFactureImplTest {
    @Autowired
    DetailFactureRepository detailFactureRepository;

    @Mock
    DetailFactureRepository detailFactureRepository2;

    @InjectMocks
    DetailFactureImpl detailfactureService;

    DetailFacture d = new DetailFacture(5l,1,2.2f,1,33.2f);


    Long getId()
    {
        for (DetailFacture det: detailFactureRepository.findAll()) {
            return det.getIdDetailFacture();
        }
        return 0L;
    }
    @Test
    @Order(0)
     void addDetailFacture() {
        DetailFacture detailFacture = new DetailFacture();
        List<DetailFacture> LDetailFacture = new ArrayList<>();
        for (Long i=3L;i<=10L;i++) {
            detailFacture.setIdDetailFacture(i);
            detailFacture.setPrixTotalDetail(35.2f);
            detailFacture.setQteCommandee(85);
            detailFacture.setPrixTotalDetail(156.9f);
            DetailFacture dd=detailFactureRepository.save(detailFacture);
            LDetailFacture.add(dd);
        }
        assertEquals(8,LDetailFacture.size());
    }
    @Test
    @Order(3)
     void deleteAll() {
        detailFactureRepository.deleteAll();
        assertEquals(0,detailFactureRepository.findAll().spliterator().estimateSize());
    }
    @Test
    @Order(2)
     void retrieveDetailFacture() {
        Mockito.when(detailFactureRepository2.findById(Mockito.anyLong())).thenReturn(Optional.of(d));
        DetailFacture ddd = detailfactureService.retrieveDetailFactureById(getId());
        Mockito.verify(detailFactureRepository2,Mockito.times(1)).findById(getId());
    }
    @Test
    @Order(4)
     void getDetailFacture(){
        Iterable<DetailFacture> LDetailFacture = detailFactureRepository2.findAll();
        Assertions.assertNotNull(LDetailFacture);
    }


}
