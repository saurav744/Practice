package com.saurav.myblogapp.data_access;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saurav.myblogapp.control.model.Publication;

public interface PublicationRepository extends JpaRepository<Publication, Long>{

}
