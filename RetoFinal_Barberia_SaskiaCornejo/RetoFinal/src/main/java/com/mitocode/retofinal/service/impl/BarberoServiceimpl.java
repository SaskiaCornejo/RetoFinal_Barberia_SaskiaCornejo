package com.mitocode.retofinal.service.impl;

import com.mitocode.retofinal.model.Barbero;
import com.mitocode.retofinal.repo.IBarberoRepo;
import com.mitocode.retofinal.repo.IGenericRepo;
import com.mitocode.retofinal.service.IBarberoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BarberoServiceimpl extends CRUDimpl<Barbero,Integer> implements IBarberoService {
    private final IBarberoRepo repo;

    @Override
    protected IGenericRepo<Barbero, Integer> getRepo() {
        return repo;
    }
}






































