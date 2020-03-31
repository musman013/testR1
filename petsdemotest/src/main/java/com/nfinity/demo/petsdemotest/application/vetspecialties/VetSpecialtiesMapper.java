package com.nfinity.demo.petsdemotest.application.vetspecialties;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import com.nfinity.demo.petsdemotest.domain.model.SpecialtiesEntity;
import com.nfinity.demo.petsdemotest.domain.model.VetsEntity;
import com.nfinity.demo.petsdemotest.application.vetspecialties.dto.*;
import com.nfinity.demo.petsdemotest.domain.model.VetSpecialtiesEntity;

@Mapper(componentModel = "spring")
public interface VetSpecialtiesMapper {

   VetSpecialtiesEntity createVetSpecialtiesInputToVetSpecialtiesEntity(CreateVetSpecialtiesInput vetspecialtiesDto);
   
   @Mappings({ 
   @Mapping(source = "specialties.name", target = "specialtiesDescriptiveField"),                    
   @Mapping(source = "vets.firstName", target = "vetsDescriptiveField"),                    
   }) 
   CreateVetSpecialtiesOutput vetSpecialtiesEntityToCreateVetSpecialtiesOutput(VetSpecialtiesEntity entity);

   VetSpecialtiesEntity updateVetSpecialtiesInputToVetSpecialtiesEntity(UpdateVetSpecialtiesInput vetspecialtiesDto);

   @Mappings({ 
   @Mapping(source = "specialties.name", target = "specialtiesDescriptiveField"),                    
   @Mapping(source = "vets.firstName", target = "vetsDescriptiveField"),                    
   }) 
   UpdateVetSpecialtiesOutput vetSpecialtiesEntityToUpdateVetSpecialtiesOutput(VetSpecialtiesEntity entity);

   @Mappings({ 
   @Mapping(source = "specialties.name", target = "specialtiesDescriptiveField"),                    
   @Mapping(source = "vets.firstName", target = "vetsDescriptiveField"),                    
   }) 
   FindVetSpecialtiesByIdOutput vetSpecialtiesEntityToFindVetSpecialtiesByIdOutput(VetSpecialtiesEntity entity);


   @Mappings({
   @Mapping(source = "vetSpecialties.specialtyId", target = "vetSpecialtiesSpecialtyId"),
   @Mapping(source = "vetSpecialties.vetId", target = "vetSpecialtiesVetId"),
   })
   GetSpecialtiesOutput specialtiesEntityToGetSpecialtiesOutput(SpecialtiesEntity specialties, VetSpecialtiesEntity vetSpecialties);

   @Mappings({
   @Mapping(source = "vetSpecialties.specialtyId", target = "vetSpecialtiesSpecialtyId"),
   @Mapping(source = "vetSpecialties.vetId", target = "vetSpecialtiesVetId"),
   })
   GetVetsOutput vetsEntityToGetVetsOutput(VetsEntity vets, VetSpecialtiesEntity vetSpecialties);

}
