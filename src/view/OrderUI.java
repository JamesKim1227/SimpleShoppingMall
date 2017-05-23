package view;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import model.Item;
import model.Purchase;
import model.User;
import dao.ItemDao;
import dao.UserDao;
import dao.PurchaseDao;


public class OrderUI extends AbstractUI {

	private ItemDao itemDao;
	private UserDao userDao;
	private PurchaseDao purchaseDao;
	
	
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void setPurchaseDao(PurchaseDao purchaseDao) {
		this.purchaseDao = purchaseDao;
	}
	
	
	protected void showItemList(List<Item> itemList) {
		for (Item item : itemList) {
			System.out.println(item);
		}
	}
	
//	public boolean isBuyable(Integer userBalance, Integer itemId, Integer count, List<Item> itemList)
//	{
//		for (Item item : itemList) {
//			if (item.getItemId().equals(itemId)) {
//				int totalSum = item.getPrice().intValue() * count.intValue();
//				
//				if (userBalance.intValue() >= totalSum){
//					return true;
//				}
//				
//				System.out.println("You do not have enough money.");
//				return false;
//			}
//		}
//		
//		System.out.println("Item id is wrong.");
//		return false;
//	}
	
	@Override
	@Transactional
	public void show() {
		System.out.print("사용자 ID 입력: ");
		String strUserId = getInputString();
		
		System.out.print("상품 ID 입력: ");
		String strItemId = getInputString();
		
		System.out.print("구매 수량 입력: ");
		String strCount = getInputString();
		
		
		Integer intUserId = Integer.parseInt(strUserId);
		Integer intItemId = Integer.parseInt(strItemId);
		Integer intCount = Integer.parseInt(strCount);
		// get user object
		User user = userDao.getUser(intUserId);
		
		if (user == null) {
			System.out.println("존재하지 않는 사용자 입니다. 다시 시도해 주세요.");
			return;
		}
		
		// check if balance is available
		List<Item> itemList = itemDao.getItemList();
		
		if (itemList.isEmpty()) {
			System.out.println("상품이 존재하지 않습니다.");
			return;
		}

		int totalSum = 0;
		for (Item item : itemList) {
			if (item.getItemId().equals(intItemId)) {
				totalSum = item.getPrice().intValue() * intCount.intValue();
				
				if (user.getBalance().intValue() < totalSum){
					System.out.println("잔고가 충분하지 않습니다. 당신의 잔고는 " + user.getBalance() + " 입니다.");
					return;
				}
			}
		}
		
		// add purchase list
		Purchase purchaseList = new Purchase();
		purchaseList.setItemId(intItemId);
		purchaseList.setItemCount(intCount);

		purchaseDao.buy(purchaseList);
		
		// subtract user balance
		Integer updateBalance = user.getBalance().intValue() - totalSum;
		user.setBalance(updateBalance);
		
		userDao.updateUser(user);
	}

}
