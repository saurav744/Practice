package com.saurav.myblogapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saurav.myblogapp.model.Publication;
import com.saurav.myblogapp.model.PublicationState;
import com.saurav.myblogapp.model.User;
import com.saurav.myblogapp.repository.PublicationRepository;

@Service("publicationService")
@Transactional
public class PublicationServiceImpl implements PublicationService {

	@Autowired
    private PublicationRepository publicationRepository;

    public PublicationServiceImpl() {

    }

    @Override
    public void addPublication(Publication publication) {

        publicationRepository.save(publication);
    }

    @Override
    public void deletePublication(long id) {

        publicationRepository.deleteById(id);
    }

    @Override
    public boolean isAuthor(User user, long id) {
    	
    	Publication pub = publicationRepository.getOne(id);
        
        List<User> authors = pub.getAuthors();
        if(authors.contains(user)) {
        	return true;
        }
        return false;
    }

    @Override
    public void updatePublication(long id, Publication inputPub) {

        if(publicationRepository.findById(id).isPresent()) {
        	
        	Publication pub = publicationRepository.findById(id).get();
        	
        	if(inputPub.getTitle() != null)
        		pub.setTitle(inputPub.getTitle());
        	
        	if(inputPub.getBody() != null)
        		pub.setBody(inputPub.getBody());
        	
        	if(inputPub.getType() != null)
        		pub.setType(inputPub.getType());
        	
        	publicationRepository.save(pub); 	
        }    
    }

    @Override
    public Publication getPublicationById(long id) {
    	
    	Optional<Publication> pub = publicationRepository.findById(id);
    	
        return pub.orElse(null);
    }

    @Override
    public void changeState(long id, PublicationState state) {
    		
    	 if(publicationRepository.findById(id).isPresent()) {
         	
         	Publication pub = publicationRepository.findById(id).get();
         	pub.setState(state);
         	publicationRepository.save(pub);	
         }
    }

    @Override
    public List<Publication> getPending() {
    		
        return publicationRepository.findByState(PublicationState.PENDING);
    }

	@Override
	public List<Publication> getAllPublications() {
		
		return publicationRepository.findAll();
	}
	

}