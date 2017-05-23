package view;

import java.util.List;

import model.Item;
import dao.ItemDao;

public class ItemListUI extends AbstractUI {

	private ItemDao itemDao;
	
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}
	
	protected void showItemList(List<Item> itemList) {
		for (Item item : itemList) {
			System.out.println(item);
		}
	}
	
	@Override
	public void show() {
		List<Item> itemList = itemDao.getItemList();
		
		if (itemList == null) {
			System.out.println("상품이 존재하지 않습니다.");
			return;
		}
		
		showItemList(itemList);
	}

}
