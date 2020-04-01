package com.nfinity.demo.petsdemotest.domain.irepository; 
 
import com.nfinity.demo.petsdemotest.domain.model.JwtEntity; 
import org.springframework.data.jpa.repository.JpaRepository; 
 
import java.util.List; 

public interface IJwtRepository extends JpaRepository<JwtEntity, Long> { 

    JwtEntity findByToken(String token); 
    
} 