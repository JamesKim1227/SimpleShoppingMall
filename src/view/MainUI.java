package view;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainUI extends AbstractUI {
	
	private BalanceUI balanceUI;
	private ItemListUI itemListUI;
	private OrderUI orderUI;
	private PurchaseListUI purchaseListUI;
	
	
	public void setBalanceUI(BalanceUI balanceUI) {
		this.balanceUI = balanceUI;
	}
	
	public void setItemListUI(ItemListUI itemListUI) {
		this.itemListUI = itemListUI;
	}
	
	public void setOrderUI(OrderUI purchaseUI) {
		this.orderUI = purchaseUI;
	}
	
	public void setPurchaseListUI(PurchaseListUI purchaseListUI) {
		this.purchaseListUI = purchaseListUI;
	}
	
	
	public void showMenu() {
		System.out.println("");
		System.out.println("==========================================");
		System.out.println("|  Welcome to Hello World Shopping Mall  |");
		System.out.println("==========================================");
		System.out.println();
		System.out.println("1. 잔고 조회");
		System.out.println("2. 상품 목록 조회");
		System.out.println("3. 상품 구매");
		System.out.println("4. 구매 목록 조회");
		System.out.println("5. 종료");
		System.out.println("");
		System.out.print("입력 : ");
	}
	
	@Override
	public void show() {
		showMenu();
		
		String str = getInputString();
		
		int index = Integer.parseInt(str);
		
		switch (index) {
		case 1:
			balanceUI.show();
			break;
		case 2:
			itemListUI.show();
			break;
		case 3:
			orderUI.show();
			break;
		case 4:
			purchaseListUI.show();
			break;
		case 5:
			System.exit(0);
			break;
		default:
			System.out.println("잘못 입력하셨습니다. 다시 시도해 주세요.");
			this.show();
		}
	}
	
	public static void main(String [] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MainUI main = (MainUI)context.getBean("mainUI");
		
		while (true) {
			main.show();
		}
	}
}
