package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.model.Commentaire;
import tn.esprit.spring.repository.CommentaireRepository;

@Service
public class CommentaireServiceImp implements ICommentaireService<Commentaire>{
@Autowired
CommentaireRepository com;
	@Override
	public List<Commentaire> findAll() {
		// TODO Auto-generated method stub
		return (List<Commentaire>) com.findAll();
	}

	@Override
	public Commentaire findById(int id) {
		// TODO Auto-generated method stub
		return com.findById(id).get();
	}

	@Override
	public Commentaire create(Commentaire commentaire) {
		// TODO Auto-generated method stub
		return com.save(commentaire);
	}

	@Override
	public Commentaire update(Commentaire commentaire) {
		// TODO Auto-generated method stub
		return com.save(commentaire);
	}

	@Override
	public void delete(int commentId) {
		// TODO Auto-generated method stub
		 com.deleteById(commentId);
	}

	

	

}
