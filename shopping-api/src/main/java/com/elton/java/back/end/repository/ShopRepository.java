package com.elton.java.back.end.repository;

import java.time.LocalDateTime;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elton.java.back.end.model.Shop;

public interface ShopRepository extends JpaRepository<Shop, Long> {
	
	public List<Shop> findAllByUserIdentifier(String userIdentifier);
	
	public List<Shop> findAllByTotalGreaterThan(Float total);
	
	public List<Shop> findAllByDateGreaterThan(LocalDateTime localDateTime);	

}
