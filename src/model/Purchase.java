package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PURCHASE")
public class Purchase implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer purchaseId;
	private Integer itemId;
	private Integer itemCount;
	
	@Id
	@Column(name="PURCHASE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getPurchaseId() {
		return purchaseId;
	}
	
	@Column(name="ITEM_ID")
	public Integer getItemId() {
		return itemId;
	}
	
	@Column(name="ITEM_COUNT")
	public Integer getItemCount() {
		return itemCount;
	}

	
	public void setPurchaseId(Integer purchaseId) {
		this.purchaseId = purchaseId;
	}
	
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	
	public void setItemCount(Integer itemCount) {
		this.itemCount = itemCount;
	}
}
