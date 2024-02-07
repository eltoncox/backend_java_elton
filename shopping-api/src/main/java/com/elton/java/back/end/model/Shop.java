package com.elton.java.back.end.model;

import java.time.LocalDateTime;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import com.elton.java.back.end.dto.ShopDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name = "shop")
public class Shop {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private long id;
	private String userIdentifier;
	private float total;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
	private LocalDateTime date;
	
	@ElementCollection(fetch = FetchType.EAGER)// 
	@CollectionTable(name = "item", joinColumns = @JoinColumn(name="shop_id"))
	private List<Item> items;

	public long getId() {return id;}
	public void setId(long id) {this.id = id;}

	public String getUserIdentifier() {	return userIdentifier;}
	public void setUserIdentifier(String userIdentifier) {this.userIdentifier = userIdentifier;}	

	public float getTotal() {	return total;}
	public void setTotal(float total) {this.total = total;	}

	public LocalDateTime getDate() {return date;}
	public void setDate(LocalDateTime date) {this.date = date;}
	
	public List<Item> getItems() {return items;}
	public void setItems(List<Item> items) {this.items = items;}
	
	
	public static Shop convert(ShopDTO shopDTO ) {
		Shop shop = new Shop();
		shop.setUserIdentifier(shopDTO.getUserIdentifier());
		shop.setTotal(shopDTO.getTotal());
		shop.setDate(shopDTO.getDate());		
		shop.setItems(shopDTO.getItems()
				.stream()
				.map(Item::convert)
				.collect(Collectors.toList()));
		
		return shop;
		
	}
	
	
	

}
