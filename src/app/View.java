package app;

import java.util.ArrayList;
import java.util.Scanner;

import com.frame.Biz;
import com.user.UserBiz;
import com.vo.UserVO;

public class View {
	public static void main(String[] args) {
		Scanner sc = null;
		aa: while (true) {
			Biz<UserVO, String> biz = new UserBiz();
			System.out.print("1.��ü��ȸ ");
			System.out.print("2.������ȸ ");
			System.out.print("3.�Է� ");
			System.out.print("4.���� ");
			System.out.print("5.���� ");
			System.out.println("9.����");
			System.out.print("�۾��� �����ϼ���>>");
			sc = new Scanner(System.in);					
			int i = sc.nextInt();
			switch (i) {
			case 1:
				try {
					ArrayList<UserVO> list = biz.get();
					System.out.println("===��ü��ȸ===");
					for (UserVO v : list) {
						System.out.println(v);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				System.out.print("�˻��� id�� �Է��ϼ���>>");
				String id1 = sc.next();
				try {
					UserVO user = biz.get(id1);
					System.out.println("===������ȸ===");
					System.out.println(user);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:
				System.out.print("id�� �Է��ϼ���>>");
				String id2 = sc.next();
				System.out.println("\npassword�� �Է��ϼ���>>");
				String pwd = sc.next();
				System.out.println("\nname�� �Է��ϼ���>>");
				String name = sc.next();
				UserVO user = new UserVO(id2, pwd, name); 
				try {
					biz.register(user);
					System.out.println(user+"�ԷµǾ����ϴ�.");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 4:
				System.out.print("id�� �Է��ϼ���>>");
				String id3 = sc.next();
				System.out.println("\npassword�� �Է��ϼ���>>");
				String pwd2 = sc.next();
				System.out.println("\nname�� �Է��ϼ���>>");
				String name2 = sc.next();
				UserVO user2 = new UserVO(id3, pwd2, name2);
				try {
					biz.modify(user2);
					System.out.println(user2+"�����Ǿ����ϴ�.");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 5:
				System.out.print("id�� �Է��ϼ���>>");
				String id4 = sc.next();
				try {
					biz.remove(id4);
					System.out.println(id4+"�����Ǿ����ϴ�.");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 9:
				sc.close();
				break aa;
			default:
				break;
			}
		}
	}

}
