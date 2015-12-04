package com.tn.isamm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tn.isamm.dao.CadeauDAO;

@Service
public class CadeauService {
private CadeauDAO cadeauDAO;
	
	@Autowired
	public void cadeauDAO(CadeauDAO cadeauDAO) {
		this.cadeauDAO = cadeauDAO;
	}

}
