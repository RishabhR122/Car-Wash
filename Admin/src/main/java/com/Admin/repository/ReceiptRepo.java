package com.Admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Admin.model.Receipt;

public interface ReceiptRepo extends JpaRepository<Receipt, Integer>{

}
