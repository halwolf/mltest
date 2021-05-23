package com.mercadolibre.demoapp.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.mercadolibre.demoapp.entity.IpBanList;


public interface IIPBanList extends MongoRepository<IpBanList, String> {

	@Query("{ 'ip' : ?0 }")
	List<IpBanList> findByIP(String ip);
	
}
