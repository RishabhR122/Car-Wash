package com.Admin.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.Admin.model.WashPacks;

public interface WashPackService {
	
	public WashPacks addWP(WashPacks washPacks);
	public List<WashPacks> findallWP();
	 public ResponseEntity<WashPacks> findoneWP(String id);
	 public WashPacks findbyname(String name);
	 public ResponseEntity<Map<String,Boolean>> deleteWP(String id);
	 public ResponseEntity<WashPacks> updateWP(String id,WashPacks washPacks);

}
