package com.mitocode.retofinal.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean(name="defaultMapper")
    public ModelMapper defaultMapper() {
        return new ModelMapper();
    }

   /* @Bean(name = "clientMapper")
    public ModelMapper clientMapper() {
        ModelMapper modelMapper = new ModelMapper();
        //Lectura GET
        modelMapper.createTypeMap(Client.class, ClientDto.class)
                .addMapping(Client::getPrimaryName,(dest,v)->dest.setFirstname((String) v))
                .addMapping(Client::getLastName,(dest,v)->dest.setSuname((String) v));
        //escritura POST PUT
        modelMapper.createTypeMap(ClientDto.class, Client.class)
                .addMapping(ClientDto::getFirstname,(dest,v)->dest.setPrimaryName((String) v))
                .addMapping(ClientDto::getSuname,(dest,v)->dest.setLastName((String) v));
        return modelMapper;
    }
    @Bean(name = "saleMapper")
    public ModelMapper saleMapper() {
        ModelMapper modelMapper = new ModelMapper();
        //Lectura GET
        modelMapper.createTypeMap(Sale.class, SaleDto.class)
                .addMapping(e->e.getClient().getPrimaryName(),(dest,v)->dest.getClient().setPrimaryName((String) v))
                .addMapping(e->e.getClient().getLastName(),(dest,v)->dest.getClient().setLastName((String) v));
        return modelMapper;
    }*/

}






















