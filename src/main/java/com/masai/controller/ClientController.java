package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.ClientNotFound;
import com.masai.model.Clients;
import com.masai.service.ClientService;
@RestController
public class ClientController {
	@Autowired
	ClientService clientService;
	@PostMapping("/Client")
	public ResponseEntity<String>   createClients(@RequestBody Clients Clients) throws ClientNotFound {
		String status =  clientService.createClients(Clients);
		return new ResponseEntity<>(status,HttpStatus.CREATED);
	}
	@GetMapping("/Client")
	public ResponseEntity<List<Clients>> getAllClientsList() throws ClientNotFound{
		return new ResponseEntity<>(clientService.getAllClientsList(),HttpStatus.ACCEPTED);
	}
	@GetMapping("/Client/{id}")
	public ResponseEntity<Clients> getClientsById(@PathVariable int id) throws ClientNotFound {
		return new ResponseEntity<Clients>(clientService.getClientsById(id),HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/Client/{id}")
	public ResponseEntity<Clients> deleteClientsById(@PathVariable int id) throws ClientNotFound {
		return new ResponseEntity<Clients>(clientService.deleteClientsById(id),HttpStatus.ACCEPTED);
	}
	@PatchMapping("/Client/{id}")
	public ResponseEntity<Clients> updateClientsById(@PathVariable int id,@RequestBody Clients Clients) throws ClientNotFound {
		return new ResponseEntity<Clients>(clientService.updateClientsById(id,Clients),HttpStatus.CREATED);
	}
}
