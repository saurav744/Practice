package com.saurav.myblogapp.data_access;

import org.springframework.data.jpa.repository.JpaRepository;
import com.saurav.myblogapp.control.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
