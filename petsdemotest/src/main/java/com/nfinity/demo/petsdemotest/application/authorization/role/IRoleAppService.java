package com.nfinity.demo.petsdemotest.application.authorization.role;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nfinity.demo.petsdemotest.commons.search.SearchCriteria;
import com.nfinity.demo.petsdemotest.application.authorization.role.dto.*;
import java.util.List;

@Service
public interface IRoleAppService {
    // CRUD Operations

    CreateRoleOutput create(CreateRoleInput input);

    void delete(Long rid);

    UpdateRoleOutput update(Long roleId, UpdateRoleInput input);

    FindRoleByIdOutput findById(Long rid);

    List<FindRoleByIdOutput> find(SearchCriteria search, Pageable pageable) throws Exception;

}
