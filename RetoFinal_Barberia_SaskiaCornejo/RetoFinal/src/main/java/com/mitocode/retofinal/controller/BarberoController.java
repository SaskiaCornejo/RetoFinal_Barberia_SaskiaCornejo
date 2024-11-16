package com.mitocode.retofinal.controller;

import com.mitocode.retofinal.dto.BarberoDto;
import com.mitocode.retofinal.dto.GenericResponse;
import com.mitocode.retofinal.model.Barbero;
import com.mitocode.retofinal.service.IBarberoService;
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
@RequestMapping("/barbero")
@RequiredArgsConstructor
public class BarberoController {
    private final IBarberoService service;
    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;
    @GetMapping
    public ResponseEntity<GenericResponse<BarberoDto>> getAllBarberos() {
        List<BarberoDto> list= service.findAll().stream().map(this::converToDto).toList();
        //return ResponseEntity.ok(list);
        return ResponseEntity.ok(new GenericResponse<>(200,"success",list));
    }
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody BarberoDto barberoDto) {
        Barbero obj= service.save(converToEntity(barberoDto));
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdBarbero()).toUri();
        return ResponseEntity.created(location).build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<BarberoDto>> getBarberoById(@PathVariable("id") int id) {
        Barbero obj= service.findById(id);
        return ResponseEntity.ok(new GenericResponse<>(200,"success", Arrays.asList(converToDto(obj))));
    }
    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<BarberoDto>> update(@Valid @PathVariable("id") int id,@RequestBody BarberoDto barberoDto) {
        barberoDto.setIdBarbero(id);
        Barbero obj= service.update(id, converToEntity(barberoDto));
        return ResponseEntity.ok(new GenericResponse<>(200,"success", Arrays.asList(converToDto(obj))));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    private BarberoDto converToDto(Barbero barbero) {
        return modelMapper.map(barbero,BarberoDto.class);
    }
    private Barbero converToEntity(BarberoDto barberoDto) {
        return modelMapper.map(barberoDto,Barbero.class);
    }
}
