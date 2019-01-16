package com.saurav.myblogapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saurav.myblogapp.exceptions.PublicationNotFoundException;
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
    public void deletePublication(long id) throws PublicationNotFoundException {
    	
    	if(!isPresent(id))
    		throw new PublicationNotFoundException();

        publicationRepository.deleteById(id);
    }

    @Override
    public boolean isAuthor(User user, long id) throws PublicationNotFoundException {
    	
    	if(!isPresent(id))
    		throw new PublicationNotFoundException();
    	
    	Publication pub = publicationRepository.findById(id).get();
        
    	return pub.getAuthors().contains(user);
        
    }
    
    @Override
    public boolean isPresent(long id) {
    	return publicationRepository.existsById(id);
    }

    @Override
    public void updatePublication(long id, Publication inputPub) throws PublicationNotFoundException {

        if(isPresent(id)) {
        	
        	Publication pub = publicationRepository.findById(id).get();
        	
        	if(inputPub.getTitle() != null)
        		pub.setTitle(inputPub.getTitle());
        	
        	if(inputPub.getBody() != null)
        		pub.setBody(inputPub.getBody());
        	
        	if(inputPub.getType() != null)
        		pub.setType(inputPub.getType());
        	
        	publicationRepository.save(pub); 	
        } else {
        	throw new PublicationNotFoundException();	
        }
        	
    }

    @Override
    public Publication getPublicationById(long id) throws PublicationNotFoundException {
    	
    	if(!isPresent(id))
    		throw new PublicationNotFoundException();
    	
    	Optional<Publication> pub = publicationRepository.findById(id);
    	
        return pub.get();
    }

    @Override
    public void changeState(long id, PublicationState state) throws PublicationNotFoundException {
    		
    	 if(isPresent(id)) {
         	
         	Publication pub = publicationRepository.findById(id).get();
         	pub.setState(state);
         	publicationRepository.save(pub);	
         } else {
        	 throw new PublicationNotFoundException();
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