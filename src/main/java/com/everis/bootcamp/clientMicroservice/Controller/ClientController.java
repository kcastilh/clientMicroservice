package com.everis.bootcamp.clientMicroservice.Controller;

//import java.net.URI;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.everis.bootcamp.clientMicroservice.Document.Client;
import com.everis.bootcamp.clientMicroservice.Service.ClientService;
import com.everis.bootcamp.clientMicroservice.ServiceDTO.Request.ClientRequest;


import io.swagger.annotations.ApiOperation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api")

public class ClientController {

	@Autowired
	ClientService clientService;
	
	//CREATE
	@ApiOperation(value = "Update New Clients")
	@PostMapping(value =  "/clients")
	public Mono<Client> createClient(@Valid @RequestBody ClientRequest clientRequest){
		return clientService.create(clientRequest);
	}
	
	//UPDATE
	@ApiOperation(value = "Update Clients")
	@PutMapping(value = "/clients/{id}")
	public Mono <Client> updateClient(@PathVariable("id") String id,@Valid @RequestBody ClientRequest clientRequest){
			return clientService.update(id, clientRequest);				
	}
	
	//READ
	@ApiOperation(value = "List all clients")
	@GetMapping(value = "/clients")
	public ResponseEntity<Flux<Client>> listClient(){
		
		return ResponseEntity.ok().body(clientService.readAll());
	}
	
	//DELETE
	@ApiOperation(value = "Delete a client")
	@DeleteMapping(value = "/client/{clientId}")
	public Mono<Client> deleteClient(@PathVariable(value = "clientId") String clientId){		
		return clientService.delete(clientId);		
	}
	
	//FIND ONE
	@ApiOperation(value = "List on client")
	@GetMapping(value = "/client/{clientId}")
	public Mono<Client> findOneClient(@PathVariable(value = "clientId")String clientId){
		return clientService.getOne(clientId);
	}
	
	//EXIST
	@ApiOperation(value = "Valides Client")
	@GetMapping(value = "/client/exist/{clientId}")
	public Mono<Boolean> existClient(String clientId){
		
		return clientService.isPresent(clientId);
	}
	
	
	
	
}
