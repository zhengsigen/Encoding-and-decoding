package data.storage;

import java.io.IOException;
import java.util.Scanner;

public class Test {
	
	static UserManager um= new UserManager();
	
	static {
		
		try {
			
			um.dataLoading();
			
		} catch (ClassNotFoundException e) {	
		} catch (IOException e) {	
		}
	}

	private static Scanner sc;

	public static void main(String[] args) throws IOException {
		
		sc = new Scanner(System.in);
		
	
		
		while(true) {
			
			System.out.println("1.�����û� 2.�޸��û� 3.��ѯ�û� 4.ɾ���û� 5.�û��б� 6.�˳�");
			
			int mark =sc.nextInt();
			
			if(mark==UserFinal.ADD_USER) {
				
				um.addUser();
				
			}else if(mark==UserFinal.UPDATE_USER) {
				
				um.updateUser();
				
			}else if(mark==UserFinal.CHERK_USER) {
				
				um.cherkUser();
				
			}else if(mark==UserFinal.DEL_USER) {
				
				um.delUser();
				
			}else if(mark==UserFinal.USER_LIST) {
				
				um.UserLisr();
				
			}else if(mark==6) {
				
				um.dataStorage();
				
				break;
			}
		}
	}
}
