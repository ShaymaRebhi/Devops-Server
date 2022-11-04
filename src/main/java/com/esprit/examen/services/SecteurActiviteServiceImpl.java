package com.esprit.examen.services;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esprit.examen.entities.SecteurActivite;
import com.esprit.examen.repositories.SecteurActiviteRepository;

@Service
@Slf4j
public class SecteurActiviteServiceImpl implements ISecteurActiviteService{

	@Autowired
	SecteurActiviteRepository secteurActiviteRepository;
	@Override
	public List<SecteurActivite> retrieveAllSecteurActivite() {
		List<SecteurActivite> secteurActivites = (List<SecteurActivite>) secteurActiviteRepository.findAll();
		for (SecteurActivite secteurActivite : secteurActivites) {
			log.info(" SecteurActivite : " + secteurActivite);
		}
		log.info("out of method retrieveAllSecteurActivite");
		return (List<SecteurActivite>) secteurActiviteRepository.findAll();
	}

	@Override
	public SecteurActivite addSecteurActivite(SecteurActivite sa) {
		secteurActiviteRepository.save(sa);
		log.info("secteurActivite added !!");
		return sa;
	}

	@Override
	public void deleteSecteurActivite(Long id) {
		secteurActiviteRepository.deleteById(id);
		log.info("SecteurActivite deleted");
	}

	@Override
	public SecteurActivite updateSecteurActivite(SecteurActivite sa) {
		secteurActiviteRepository.save(sa);
		log.info("SecteurActivite updated");
		return sa;
	}

	@Override
	public SecteurActivite retrieveSecteurActivite(Long id) {
		return secteurActiviteRepository.findById(id).orElse(null);

	}

}
