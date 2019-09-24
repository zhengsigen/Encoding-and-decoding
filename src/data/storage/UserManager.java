package data.storage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;


public class UserManager {

	HashMap<Integer,User> users = new HashMap<>();
	
	Scanner sc = new Scanner(System.in);
	
	public void addUser() {
		
		System.out.println("�������������û�id");
		
		int id= sc.nextInt();
		
		if(users.containsKey(id)) {
			
			System.out.println("��id�ѽ����");
			
			return;
		}
		
		System.out.println("�������������û���");
		
		String name =sc.next();
		
		System.out.println("�������������û�����");
		
		String password=sc.next();
		
		users.put(id,new User(id, name, password));
		
		System.out.println("�����ɹ�");
	}
	
	public void updateUser() {
		
		System.out.println("�������û�id");
		
		int id = sc.nextInt();
		
		if(!users.containsKey(id)) {
			
			System.out.println("��id������");
			
			return;
		}
		
		System.out.println("�������޸ĺ���û���");
		
		String name = sc.next();
		
		System.out.println("�������޸ĺ���û�����");
		
		String passwod= sc.next();
		
		users.put(id, new User(id,name,passwod));
		
		System.out.println("�޸ĳɹ�");
	}
	
	public void cherkUser() {
		
		System.out.println("�������û�id");
		
		int id = sc.nextInt();
		
		if(!users.containsKey(id)) {
			
			System.out.println("��id������");
			
			return;
		}
		
		System.out.println(users.get(id));
	}
	
	public void delUser() {
		
		System.out.println("�������û�id");
		
		int id = sc.nextInt();
		
		if(!users.containsKey(id)) {
			
			System.out.println("��id������");
			
			return;
		}
		
		users.remove(id);
		
		System.out.println("ɾ���ɹ�");
	}
	
	public void UserLisr() {
		
		System.out.println("�����û���Ϣ���£�");
		
		Set<Integer>key = users.keySet();
		
		for(Integer u: key) {
			
			User user = users.get(u);
			
			System.out.println(user);
		}
	}
	
	public void dataLoading() throws IOException, ClassNotFoundException{
	
		FileInputStream fis =new FileInputStream("UserDatas.txt");

		ObjectInputStream ois = new ObjectInputStream(fis);
		
		while(true) {
			
			try {
				
				User user = (User) ois.readObject();
				
				users.put(user.getId(),user);
				
			}catch (Exception e) {
				
				break;
				
			}	
		}
		
		ois.close();
		
		System.out.println("�û����ݳɹ���ȡ");
	}
	
	public void dataStorage() throws IOException {
		
		FileOutputStream fos = new FileOutputStream("UserDatas.txt");
		
		ObjectOutputStream oos =new ObjectOutputStream(fos);
		
		Set<Integer>key = users.keySet();
		
		for(Integer u: key) {
			
			User user = users.get(u);
			
			oos.writeObject(user);
			
		}
		
		oos.flush();
		
		oos.close();	
		
		System.out.println("�û����ݳɹ�����");
	}
	
	
}
