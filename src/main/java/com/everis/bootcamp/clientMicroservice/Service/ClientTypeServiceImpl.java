package com.everis.bootcamp.clientMicroservice.Service;

import com.everis.bootcamp.clientMicroservice.Document.ClientType;
import com.everis.bootcamp.clientMicroservice.Repository.ClientTypeRepository;
import com.everis.bootcamp.clientMicroservice.ServiceDTO.Request.ClientTypeRequest;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

public class ClientTypeServiceImpl implements ClientTypeService{
	@Autowired
    ClientTypeRepository clientTypeRepository;

    @Override
    public Mono<ClientType> create(ClientType clientType) {
        return clientTypeRepository.save(clientType);
    }

    @Override
    public Mono<ClientType> update(String id, ClientTypeRequest clientTypeRequest) {
        return clientTypeRepository.findById(id).flatMap(client -> {
            client.setName(clientTypeRequest.getName());
            return clientTypeRepository.save(client);
        });
    }

    @Override
    public Flux<ClientType> readAll() {
        return clientTypeRepository.findAll();
    }

    @Override
    public Mono<ClientType> delete(String id) {
        return getOne(id).switchIfEmpty(Mono.empty()).filter(Objects::nonNull)
                .flatMap(clientType -> clientTypeRepository.delete(clientType).then(Mono.just(clientType)));
    }

    @Override
    public Mono<ClientType> getOne(String id) {
        return clientTypeRepository.findById(id);
    }

	
}
