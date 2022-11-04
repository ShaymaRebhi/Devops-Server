package com.esprit.examen.services;

import com.esprit.examen.entities.DetailFacture;
import com.esprit.examen.repositories.DetailFactureRepository;
import com.esprit.examen.repositories.FactureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
public class DetailFactureImpl  implements  IDetailFactureService{
    @Autowired
    DetailFactureRepository detailFactureRepo;
    @Autowired
    ProduitServiceImpl psi;
    @Autowired
    FactureRepository fR;

    @Override
    public List<DetailFacture> retrieveAllDetailFactures() {
        List<DetailFacture> detailfactures =  detailFactureRepo.findAll();
        for (DetailFacture detailfacture : detailfactures) {
            log.info(" detail facture : " + detailfactures);
            log.info(" detail facture : " + detailfacture);
        }
        return detailfactures;
    }

    @Override
    public DetailFacture addDetailFacture(Long idProduit, Long idFacture, int qte) {
        DetailFacture df= new DetailFacture();

        df.setProduit(this.psi.produitRepository.getById(idProduit));
        df.setPrixTotalDetail(this.psi.produitRepository.getById(idProduit).getPrix()*qte);
        df.setMontantRemise((this.psi.produitRepository.getById(idProduit).getPrix()*qte/100));
         df.setFacture(this.fR.findById(idFacture).orElse(null));
        df.setQteCommandee(qte);
        return this.detailFactureRepo.save(df);
    }


    @Override
    public void deleteDetailFacture(Long id) {
        detailFactureRepo.deleteById(id);

    }

    @Override
    public DetailFacture updateDetailFacture(DetailFacture f) {
        detailFactureRepo.save(f);
        return f;
    }

    @Override
    public  Optional<DetailFacture> retrieveDetailFacture(Long id) {
        return detailFactureRepo.findById(id);
    }

    @Override
    public DetailFacture retrieveDetailFactureById(Long id) {
        return detailFactureRepo.findById(id).orElse(null);
    }

}
