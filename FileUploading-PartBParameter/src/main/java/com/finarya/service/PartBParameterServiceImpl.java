package com.finarya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finarya.entity.Document;
import com.finarya.repository.PartBParameterRepository;

@Service
public class PartBParameterServiceImpl implements IPartBParameterService {

	@Autowired
	private PartBParameterRepository repo;
	
	@Override
	public void saveDocument(Document doc) {
		repo.save(doc);
	}

}
