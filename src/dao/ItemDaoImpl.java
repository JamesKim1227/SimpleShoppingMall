package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Item;

public class ItemDaoImpl implements ItemDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Item> getItemList() {
		List<Item> itemList = em.createQuery(" FROM Item ", Item.class).getResultList();
		
		if (itemList.isEmpty()) {
			return null;
		}
		
		return itemList;
	}

}
