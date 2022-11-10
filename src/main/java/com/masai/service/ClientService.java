package com.masai.service;

import java.util.List;

import com.masai.exception.ClientNotFound;
import com.masai.model.Clients;




public interface ClientService {
	public List<Clients> getAllClientsList()throws ClientNotFound;
	public Clients getClientsById(int Id)throws ClientNotFound;
	public String createClients(Clients clients) throws ClientNotFound;
	public Clients deleteClientsById(int id)throws ClientNotFound;
	public Clients updateClientsById(int id, Clients clients)throws ClientNotFound;
}
