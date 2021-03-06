package com.nfinity.demo.petsdemotest.application.visits;

import java.util.List;
import javax.validation.constraints.Positive;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.nfinity.demo.petsdemotest.commons.search.SearchCriteria;
import com.nfinity.demo.petsdemotest.application.visits.dto.*;

@Service
public interface IVisitsAppService {

	CreateVisitsOutput create(CreateVisitsInput visits);

    void delete(Integer id);

    UpdateVisitsOutput update(Integer id, UpdateVisitsInput input);

    FindVisitsByIdOutput findById(Integer id);

    List<FindVisitsByIdOutput> find(SearchCriteria search, Pageable pageable) throws Exception;

    
    //Pets
    GetPetsOutput getPets(Integer visitsid);
}
