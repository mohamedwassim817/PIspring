
package tn.esprit.spring.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.model.Actualite;
import tn.esprit.spring.repository.ActualiteRepository;

import java.util.ArrayList;
import java.util.Optional;


@Service
public class ActualiteServiceImp implements IActualiteService {

    @Override
	public void deleteactualiteById(int a) {
    	actuRepository.deleteById(a);
		
	}

	@Override
	public int addOrUpdateActualite(Actualite a) {
    	actuRepository.save(a);
		//System.out.println(a);
		return a.getId();
	}

	@Override
	public Long sumlikes() {
		
		return actuRepository.sumlikes();
	}

	@Override
	public Long sumLikesParPost(int id) {
		
		return actuRepository.sumLikesParPost(id);
	}

	@Autowired
    ActualiteRepository actuRepository;

    @Override
    public Actualite addActualite(Actualite b) {
        return actuRepository.save(b);
    }

    @Override
    public void deleteActualite(Actualite b) {
        actuRepository.delete(b);
    }

    @Override
    public Actualite updateActualite(Actualite b) {
        return actuRepository.save(b);
    }

    @Override
    public ArrayList<Actualite> getActualiteList() {
        return (ArrayList<Actualite>) actuRepository.findAll();
    }

    @Override
    public Actualite getActualite(Actualite b) {
        return actuRepository.findById(b.getId()).get();
    }

    @Transactional
    @Override
    public Actualite getActualiteByID(int id) {
        System.out.println("***************************"+id);
        Optional<Actualite> op = actuRepository.findById(id);
        if (op.isPresent())
            return op.get();
        return null;
    }

	@Override
	public Long postes() {
		
		return actuRepository.postes();
	}

	@Override
	public Long avglikes() {
		
		return actuRepository.avglikes();
	}

	@Override
	public void addLike(int id_post, int quantity) {
	//	ActualiteServiceImp actuser =new ActualiteServiceImp();
		
//	Actualite actu =actuser.getActualiteByID(id_post);
	//actu.setId(id_post);
	//actu.setQuantity(quantity+1);
	actuRepository.addLike(id_post, quantity+1);
	
		
	}

  
}