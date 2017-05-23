package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer userId;
	private String name;
	private Integer balance;
	
	@Id
	@Column(name="USER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getUserId() {
		return userId;
	}
	
	@Column(name="USER_NAME")
	public String getName() {
		return name;
	}
	
	@Column(name="USER_BALANCE")
	public Integer getBalance() {
		return balance;
	}
	
	// setter
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
}
