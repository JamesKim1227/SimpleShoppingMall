package view;

import model.User;
import dao.UserDao;

public class BalanceUI extends AbstractUI {

	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public void show() {
		System.out.print("사용자 ID 입력: ");
		String id = getInputString();
		
		if ( id == null || id.equals(""))
		{
			System.out.print("잘못 입력하셨습니다. 다시 시도해 주세요.");
			show();
		}
		
		Integer intUserId = Integer.parseInt(id); 
		
		User user = userDao.getUser(intUserId);
		
		if (user == null) {
			System.out.print("존재하지 않는 유저 입니다. 다시 시도해 주세요.");
			show();
		}
		
		System.out.println("Your balance is " + user.getBalance());
	}
	
}
