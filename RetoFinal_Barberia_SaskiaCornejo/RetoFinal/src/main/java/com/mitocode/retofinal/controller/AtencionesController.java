package com.mitocode.retofinal.controller;

import com.mitocode.retofinal.dto.AtencionesDto;
import com.mitocode.retofinal.dto.GenericResponse;
import com.mitocode.retofinal.model.Atenciones;
import com.mitocode.retofinal.service.IAtencionesService;
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
@RequestMapping("/atenciones")
@RequiredArgsConstructor
public class AtencionesController {
    private final IAtencionesService service;
    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;
    @GetMapping
    public ResponseEntity<GenericResponse<AtencionesDto>> getAllAtencioness() {
        List<AtencionesDto> list= service.findAll().stream().map(this::converToDto).toList();
        //return ResponseEntity.ok(list);
        return ResponseEntity.ok(new GenericResponse<>(200,"success",list));
    }
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody AtencionesDto atencionDto) {
        Atenciones obj= service.save(converToEntity(atencionDto));
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdAtencion()).toUri();
        return ResponseEntity.created(location).build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<AtencionesDto>> getAtencionesById(@PathVariable("id") int id) {
        Atenciones obj= service.findById(id);
        return ResponseEntity.ok(new GenericResponse<>(200,"success", Arrays.asList(converToDto(obj))));
    }
    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<AtencionesDto>> update(@Valid @PathVariable("id") int id,@RequestBody AtencionesDto atencionDto) {
        atencionDto.setIdAtencion(id);
        Atenciones obj= service.update(id, converToEntity(atencionDto));
        return ResponseEntity.ok(new GenericResponse<>(200,"success", Arrays.asList(converToDto(obj))));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    private AtencionesDto converToDto(Atenciones atencion) {
        return modelMapper.map(atencion,AtencionesDto.class);
    }
    private Atenciones converToEntity(AtencionesDto atencionDto) {
        return modelMapper.map(atencionDto,Atenciones.class);
    }
}
