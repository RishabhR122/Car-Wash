package com.Admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Admin.model.WashPacks;

@Repository
public interface WashPackRepo  extends JpaRepository<WashPacks, String>{

}
