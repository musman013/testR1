package com.nfinity.demo.petsdemotest.domain.irepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.nfinity.demo.petsdemotest.domain.model.VetSpecialtiesEntity; 
import java.util.List;
import com.nfinity.demo.petsdemotest.domain.model.VetsEntity;
import org.javers.spring.annotation.JaversSpringDataAuditable;

@JaversSpringDataAuditable
@RepositoryRestResource(collectionResourceRel = "vets", path = "vets")
public interface IVetsRepository extends JpaRepository<VetsEntity, Integer>,QuerydslPredicateExecutor<VetsEntity> {

}
