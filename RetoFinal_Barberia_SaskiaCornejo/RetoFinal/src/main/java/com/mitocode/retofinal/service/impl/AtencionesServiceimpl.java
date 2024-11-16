package com.mitocode.retofinal.service.impl;

import com.mitocode.retofinal.model.Atenciones;
import com.mitocode.retofinal.repo.IAtencionesRepo;
import com.mitocode.retofinal.repo.IGenericRepo;
import com.mitocode.retofinal.service.IAtencionesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AtencionesServiceimpl extends CRUDimpl<Atenciones,Integer> implements IAtencionesService {
    private final IAtencionesRepo repo;

    @Override
    protected IGenericRepo<Atenciones, Integer> getRepo() {
        return repo;
    }
}






































