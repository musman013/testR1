package com.nfinity.demo.petsdemotest.domain.irepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.nfinity.demo.petsdemotest.domain.model.PetsEntity; 
import java.util.List;
import com.nfinity.demo.petsdemotest.domain.model.OwnersEntity;
import org.javers.spring.annotation.JaversSpringDataAuditable;

@JaversSpringDataAuditable
@RepositoryRestResource(collectionResourceRel = "owners", path = "owners")
public interface IOwnersRepository extends JpaRepository<OwnersEntity, Integer>,QuerydslPredicateExecutor<OwnersEntity> {

}
