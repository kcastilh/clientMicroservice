package com.everis.bootcamp.clientMicroservice.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.everis.bootcamp.clientMicroservice.Document.ClientType;
import com.everis.bootcamp.clientMicroservice.Service.ClientTypeService;
import com.everis.bootcamp.clientMicroservice.ServiceDTO.Request.ClientTypeRequest;

import io.swagger.annotations.ApiOperation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api")

public class ClientTypeController {
	
	@Autowired
	ClientTypeService clientTypeService;
	
	//CREATE
	@ApiOperation(value = "Create new clientTypes")
	@PostMapping(value = "/clientTypes")
	public Mono<ClientType> createClientType(ClientType clientType){
		return clientTypeService.create(clientType);
	}
	
	//UPDATE
	@ApiOperation(value = "Update clientType")
	@PutMapping(value = "/clientTypes/{id}")
	public Mono<ClientType> updateClientType(@PathVariable("id")String id,@Valid @RequestBody ClientTypeRequest clientTypeRequest){
		return clientTypeService.update(id, clientTypeRequest);
	}
	
	//READ 
	@ApiOperation(value = "List all clientTye")
	@GetMapping(value = "/clientTypes")
	public ResponseEntity<Flux<ClientType>>listClientType(){
		return ResponseEntity.ok().body(clientTypeService.readAll());
	}
	
	//DELETE
	@ApiOperation(value = "Delete a clientType")
	@DeleteMapping(value = "/clientTypes/{clientTypeId}")
	public Mono<ClientType> deleteClientType(@PathVariable(value = "clientTypeId") String clientTypeId){
		return  clientTypeService.delete(clientTypeId);
	}
	
	//FIND ONE
	@ApiOperation(value = "List one clientType")
	@GetMapping(value = "/clientType/{clientTypeId}")
	public Mono<ClientType> findOneClientType(@PathVariable(value = "clientTypeId") String clientTypeId){
		return clientTypeService.getOne(clientTypeId);
	}
	
	
	
}
