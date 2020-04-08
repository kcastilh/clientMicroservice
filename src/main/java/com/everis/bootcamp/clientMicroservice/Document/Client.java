package com.everis.bootcamp.clientMicroservice.Document;


import lombok.*;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;

@Document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor 
public class Client {

	@Id
	private String id;
	@NotBlank(message = "'Names'can't be blank")
	private String name;
    //@NotBlank(message = "'Type' can't be blank")
    //private String type;
	@NotNull(message = "'Type' can't be blank")
	//private Mono<ClientType> clientType;
	private ClientType clientType;
	@NotBlank(message = "'Status'can't be blank")
	//private String status;
	public void setStatus(String status) {
		// TODO Auto-generated method stub
		
	}
	public void setName(Object name) {
		// TODO Auto-generated method stub
		
	}
	public void setClientType(Object idClientType) {
		// TODO Auto-generated method stub
		
	}
	
	
}
