package com.everis.bootcamp.clientMicroservice.Service;

import com.everis.bootcamp.clientMicroservice.Document.ClientType;
import com.everis.bootcamp.clientMicroservice.ServiceDTO.Request.ClientTypeRequest;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientTypeService {

	Mono<ClientType> create(ClientType clientType);
	Mono<ClientType> update(String id,ClientTypeRequest clientTypeRequest);
	Flux<ClientType> readAll();
	Mono<ClientType> delete(String id);
	Mono<ClientType> getOne(String id);
}
