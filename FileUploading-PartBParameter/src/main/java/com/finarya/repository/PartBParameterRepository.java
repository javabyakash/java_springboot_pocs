package com.finarya.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finarya.entity.Document;

public interface PartBParameterRepository extends JpaRepository<Document, Integer> {

}
