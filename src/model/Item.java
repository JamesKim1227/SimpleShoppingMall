package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="ITEM")
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer itemId;
	private String name;
	private Integer price;
	
	
	@Id
	@Column(name="ITEM_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getItemId() {
		return itemId;
	}
	
	@Column(name="ITEM_NAME")
	public String getName() {
		return name;
	}
	
	@Column(name="ITEM_PRICE")
	public Integer getPrice() {
		return price;
	}
	
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return new String("[상품 ID]: " + itemId.toString() + ", [가격]: " + price.toString() + ", [상품명]: " + name);
	}
}
