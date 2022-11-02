package com.esprit.examen.services;

import com.esprit.examen.entities.DetailFacture;
import com.esprit.examen.entities.Facture;
import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.entities.Operateur;

import java.util.List;
import java.util.Optional;

public interface IDetailFactureService {
    List<DetailFacture> retrieveAllDetailFactures();

    DetailFacture addDetailFacture(Long idProduit,Long idFacture,int qte );
    void deleteDetailFacture(Long id);

    DetailFacture updateDetailFacture(DetailFacture f);

    Optional<DetailFacture> retrieveDetailFacture(Long id);
    DetailFacture retrieveDetailFactureById(Long id);
}
