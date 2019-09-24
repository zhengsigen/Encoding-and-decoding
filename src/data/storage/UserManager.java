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
		
		System.out.println("请输入新增的用户id");
		
		int id= sc.nextInt();
		
		if(users.containsKey(id)) {
			
			System.out.println("该id已结存在");
			
			return;
		}
		
		System.out.println("请输入新增的用户名");
		
		String name =sc.next();
		
		System.out.println("请输入新增的用户密码");
		
		String password=sc.next();
		
		users.put(id,new User(id, name, password));
		
		System.out.println("新增成功");
	}
	
	public void updateUser() {
		
		System.out.println("请输入用户id");
		
		int id = sc.nextInt();
		
		if(!users.containsKey(id)) {
			
			System.out.println("该id不存在");
			
			return;
		}
		
		System.out.println("请输入修改后的用户名");
		
		String name = sc.next();
		
		System.out.println("请输入修改后的用户密码");
		
		String passwod= sc.next();
		
		users.put(id, new User(id,name,passwod));
		
		System.out.println("修改成功");
	}
	
	public void cherkUser() {
		
		System.out.println("请输入用户id");
		
		int id = sc.nextInt();
		
		if(!users.containsKey(id)) {
			
			System.out.println("该id不存在");
			
			return;
		}
		
		System.out.println(users.get(id));
	}
	
	public void delUser() {
		
		System.out.println("请输入用户id");
		
		int id = sc.nextInt();
		
		if(!users.containsKey(id)) {
			
			System.out.println("该id不存在");
			
			return;
		}
		
		users.remove(id);
		
		System.out.println("删除成功");
	}
	
	public void UserLisr() {
		
		System.out.println("所有用户信息如下：");
		
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
		
		System.out.println("用户数据成功读取");
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
		
		System.out.println("用户数据成功保存");
	}
	
	
}
