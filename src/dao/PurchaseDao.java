package dao;

import java.util.List;

import model.Purchase;

public interface PurchaseDao {
	void buy(Purchase purchaseList);
	
	List<Purchase> getPurchaseList();
}
