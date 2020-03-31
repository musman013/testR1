package com.nfinity.demo.petsdemotest.application.visits;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import com.nfinity.demo.petsdemotest.domain.model.PetsEntity;
import com.nfinity.demo.petsdemotest.application.visits.dto.*;
import com.nfinity.demo.petsdemotest.domain.model.VisitsEntity;

@Mapper(componentModel = "spring")
public interface VisitsMapper {

   VisitsEntity createVisitsInputToVisitsEntity(CreateVisitsInput visitsDto);
   
   @Mappings({ 
   @Mapping(source = "pets.id", target = "petId"),                   
   @Mapping(source = "pets.name", target = "petsDescriptiveField"),                    
   }) 
   CreateVisitsOutput visitsEntityToCreateVisitsOutput(VisitsEntity entity);

   VisitsEntity updateVisitsInputToVisitsEntity(UpdateVisitsInput visitsDto);

   @Mappings({ 
   @Mapping(source = "pets.id", target = "petId"),                   
   @Mapping(source = "pets.name", target = "petsDescriptiveField"),                    
   }) 
   UpdateVisitsOutput visitsEntityToUpdateVisitsOutput(VisitsEntity entity);

   @Mappings({ 
   @Mapping(source = "pets.id", target = "petId"),                   
   @Mapping(source = "pets.name", target = "petsDescriptiveField"),                    
   }) 
   FindVisitsByIdOutput visitsEntityToFindVisitsByIdOutput(VisitsEntity entity);


   @Mappings({
   @Mapping(source = "pets.id", target = "id"),                  
   @Mapping(source = "visits.id", target = "visitsId"),
   })
   GetPetsOutput petsEntityToGetPetsOutput(PetsEntity pets, VisitsEntity visits);

}
