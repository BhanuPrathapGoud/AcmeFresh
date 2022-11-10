package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.ClientNotFound;
import com.masai.model.Clients;
import com.masai.repository.ClientDao;

@Service
public class ClientServiceImpl implements ClientService{
	@Autowired
	ClientDao ClientssDao;

	@Override
	public List<Clients> getAllClientsList() throws ClientNotFound{
		List<Clients> list = ClientssDao.findAll();
		if(list.size() > 0) {
			return list;
		}else {
			throw new  ClientNotFound("Clientss not exist");
		}
	}

	@Override
	public Clients getClientsById(int id) throws ClientNotFound{
		Optional<Clients> opt = ClientssDao.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			throw new  ClientNotFound("Clients no exist with this"+id);
		}
	}

	@Override
	public String createClients(Clients clients) throws ClientNotFound {
		Optional<Clients> opt = ClientssDao.findById(clients.getClient_id());
		if(opt.isPresent()) {
			throw new ClientNotFound("This Clientss Already Created");
		}else {
			ClientssDao.save(clients);
			return "Clientss Created Sucessfully";
		}
	}

	@Override
	public Clients deleteClientsById(int id) throws ClientNotFound {
		Optional<Clients> opt = ClientssDao.findById(id);
		if(!opt.isPresent()) {
			throw new  ClientNotFound("Clients no exist with this"+id);
		}else {
			Clients Clientss = opt.get();
			ClientssDao.delete(opt.get());
			return Clientss;
		}
	}

	@Override
	public Clients updateClientsById(int id,Clients Clients) throws ClientNotFound {
		Optional<Clients> opt = ClientssDao.findById(id);
		if(!opt.isPresent()) {
			throw new  ClientNotFound("Clients no exist with this"+id);
		}else {
			ClientssDao.save(Clients);			
			return Clients;
		}
	}
}
