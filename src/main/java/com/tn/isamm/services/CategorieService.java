package com.tn.isamm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tn.isamm.dao.CategorieDAO;

@Service
public class CategorieService {
	private CategorieDAO categorieDao;
	@Autowired
	public void setCategorieDao(CategorieDAO categorieDao) {
		this.categorieDao = categorieDao;
	}
	

}
