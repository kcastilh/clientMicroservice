package com.everis.bootcamp.clientMicroservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.everis.bootcamp.clientMicroservice.Document.Client;
//import com.everis.bootcamp.clientMicroservice.Document.ClientType;
import com.everis.bootcamp.clientMicroservice.Repository.ClientRepository;
//import com.everis.bootcamp.clientMicroservice.Repository.ClientTypeRepository;
import com.everis.bootcamp.clientMicroservice.ServiceDTO.Request.ClientRequest;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;
@Service
@Transactional
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
	@Autowired
	ClientRepository clientRepository;
	
	
	
	//CREATE
	@Override
	public Mono<Client> create(ClientRequest clientRequest){
		Client client = new Client();
		client
			.setName(clientRequest.getName());
        client.setClientType(clientRequest.getIdClientType());
        //client.setClientType(ClientType.builder().id(clientRequest.getIdClientType()).build());
        client.setStatus(clientRequest.getStatus());
		return clientRepository.save(client);
	}
	
	@Override
    public Mono<Client> update(String id, ClientRequest clientRequest) {
        return clientRepository.findById(id);
	}
	//READ
	@Override
	public Flux<Client> readAll() {
		
		return clientRepository.findAll();
	}
	//DELETE
	@Override
	public Mono<Client> delete(String id) {
		
		return getOne(id).switchIfEmpty(Mono.empty()).filter(Objects::nonNull)
        .flatMap(client -> clientRepository.delete(client).then(Mono.just(client)));

}
	//FIND ONE
	@Override
	public Mono<Client> getOne(String id) {		
		return clientRepository.findById(id);
	}
	//Is Present
	@Override
	public Mono<Boolean> isPresent(String id) {
		 return clientRepository.existsById(id);
	}

}
