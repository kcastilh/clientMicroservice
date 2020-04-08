package com.everis.bootcamp.clientMicroservice.Repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.everis.bootcamp.clientMicroservice.Document.ClientType;

import reactor.core.publisher.Mono;

@Repository
public interface ClientTypeRepository extends ReactiveMongoRepository<ClientType, String> {

	Mono<ClientType> finByname(String name);
	
}
