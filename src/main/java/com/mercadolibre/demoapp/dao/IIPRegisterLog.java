package com.mercadolibre.demoapp.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.mercadolibre.demoapp.entity.IpRegisterLog;

public interface IIPRegisterLog extends MongoRepository<IpRegisterLog, String> {

	@Query("{ 'ipOrigen' : ?0, 'createdAt' : { '$gte':  {$date : '?1'}  }}")
	List<IpRegisterLog> findByIP(String ip, Date from);

}
