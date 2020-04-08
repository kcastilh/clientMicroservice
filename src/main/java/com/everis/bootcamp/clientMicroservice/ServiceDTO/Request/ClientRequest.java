package com.everis.bootcamp.clientMicroservice.ServiceDTO.Request;


import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequest {

		private String name;
		private String idClientType;
		private String status;
		public String getStatus() {
			return status;
		}
		public Object getName() {
			return name;
		}
		public Object getIdClientType() {
			
			return idClientType;
		}

}
