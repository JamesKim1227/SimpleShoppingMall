package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Purchase;

public class PurchaseDaoImpl implements PurchaseDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void buy(Purchase purchaseList) {
		em.persist(purchaseList);
	}

	@Override
	public List<Purchase> getPurchaseList() {
		List<Purchase> purchaseList = em.createQuery(" FROM Purchase ", Purchase.class).getResultList();
		
		if (purchaseList.isEmpty()) {
			return null;
		}
		
		return purchaseList;
	}

}
