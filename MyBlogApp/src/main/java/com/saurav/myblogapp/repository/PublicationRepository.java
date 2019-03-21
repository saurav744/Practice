package com.saurav.myblogapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saurav.myblogapp.model.Publication;
import com.saurav.myblogapp.model.PublicationState;

public interface PublicationRepository extends JpaRepository<Publication, Long>{
	
	List<Publication> findByState(PublicationState state);

}
