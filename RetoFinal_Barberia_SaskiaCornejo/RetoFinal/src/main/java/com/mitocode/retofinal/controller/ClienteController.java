package com.mitocode.retofinal.controller;

import com.mitocode.retofinal.dto.ClienteDto;
import com.mitocode.retofinal.dto.GenericResponse;
import com.mitocode.retofinal.model.Cliente;
import com.mitocode.retofinal.service.IClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {
    private final IClienteService service;
    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;
    @GetMapping
    public ResponseEntity<GenericResponse<ClienteDto>> getAllClientes() {
        List<ClienteDto> list= service.findAll().stream().map(this::converToDto).toList();
        //return ResponseEntity.ok(list);
        return ResponseEntity.ok(new GenericResponse<>(200,"success",list));
    }
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody ClienteDto clienteDto) {
        Cliente obj= service.save(converToEntity(clienteDto));
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdCliente()).toUri();
        return ResponseEntity.created(location).build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<ClienteDto>> getClienteById(@PathVariable("id") int id) {
        Cliente obj= service.findById(id);
        return ResponseEntity.ok(new GenericResponse<>(200,"success", Arrays.asList(converToDto(obj))));
    }
    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<ClienteDto>> update(@Valid @PathVariable("id") int id,@RequestBody ClienteDto clienteDto) {
        clienteDto.setIdCliente(id);
        Cliente obj= service.update(id, converToEntity(clienteDto));
        return ResponseEntity.ok(new GenericResponse<>(200,"success", Arrays.asList(converToDto(obj))));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    private ClienteDto converToDto(Cliente cliente) {
        return modelMapper.map(cliente,ClienteDto.class);
    }
    private Cliente converToEntity(ClienteDto clienteDto) {
        return modelMapper.map(clienteDto,Cliente.class);
    }
}
