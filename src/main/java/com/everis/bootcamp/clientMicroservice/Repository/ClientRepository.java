package com.everis.bootcamp.clientMicroservice.Repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import com.everis.bootcamp.clientMicroservice.Document.Client;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
@Repository
public interface ClientRepository extends ReactiveMongoRepository<Client, String>{

	
	
}
