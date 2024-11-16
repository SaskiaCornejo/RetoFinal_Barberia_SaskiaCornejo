package com.mitocode.retofinal.service.impl;

import com.mitocode.retofinal.model.Cliente;
import com.mitocode.retofinal.repo.IClienteRepo;
import com.mitocode.retofinal.repo.IGenericRepo;
import com.mitocode.retofinal.service.IClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteServiceimpl extends CRUDimpl<Cliente,Integer> implements IClienteService {
    private final IClienteRepo repo;

    @Override
    protected IGenericRepo<Cliente, Integer> getRepo() {
        return repo;
    }
}






































