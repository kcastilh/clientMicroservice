package com.everis.bootcamp.clientMicroservice.Document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;
@Document(value = "clientTypes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ClientType {
	@Id
	private static String id;
	//private String name;

	public static Object builder() {
		
		return null;
	}

	public static Object id(Object idClientType) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setName(Object name) {
		
		
	}

	

}
