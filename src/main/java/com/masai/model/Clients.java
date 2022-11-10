package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Clients")
public class Clients {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer client_id;
	private String client_name;
	private String client_number;
	private String client_email;
	private String client_password;
	private String client_Address;
}
