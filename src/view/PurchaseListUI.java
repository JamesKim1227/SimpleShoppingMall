package view;

import java.util.List;

import model.Item;
import model.Purchase;
import dao.PurchaseDao;
import dao.ItemDao;

public class PurchaseListUI extends AbstractUI {

	private PurchaseDao purchaseDao;
	private ItemDao itemDao;
	
	
	public void setPurchaseDao(PurchaseDao purchaseDao) {
		this.purchaseDao = purchaseDao;
	}
	
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}
	
	
	@Override
	public void show() {
		List<Item> itemList = itemDao.getItemList();
		List<Purchase> purchaseList = purchaseDao.getPurchaseList();
		
		if (itemList.isEmpty()) {
			System.out.println("상품이 존재하지 않습니다.");
		}
		
		if (purchaseList.isEmpty()) {
			System.out.println("구매 목록이 존재하지 않습니다.");
		}
		
		for (Purchase purchase : purchaseList) {
			for (Item item : itemList) {
				
				if (purchase.getItemId().equals(item.getItemId())) {
					System.out.println("[상품]: " + item.getName() + 
							           ", [수량]: " + purchase.getItemCount().toString());
				}
				
			}
		}
	}

}
