package com.nfinity.demo.petsdemotest.domain.irepository;

import com.nfinity.demo.petsdemotest.domain.model.VetSpecialtiesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;
import com.nfinity.demo.petsdemotest.domain.model.VetSpecialtiesEntity;
import org.javers.spring.annotation.JaversSpringDataAuditable;

@JaversSpringDataAuditable
@RepositoryRestResource(collectionResourceRel = "vetSpecialties", path = "vetSpecialties")
public interface IVetSpecialtiesRepository extends JpaRepository<VetSpecialtiesEntity, VetSpecialtiesId>,QuerydslPredicateExecutor<VetSpecialtiesEntity> {

}
