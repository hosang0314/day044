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
			System.out.print("1.전체조회 ");
			System.out.print("2.선택조회 ");
			System.out.print("3.입력 ");
			System.out.print("4.수정 ");
			System.out.print("5.삭제 ");
			System.out.println("9.종료");
			System.out.print("작업을 선택하세요>>");
			sc = new Scanner(System.in);					
			int i = sc.nextInt();
			switch (i) {
			case 1:
				try {
					ArrayList<UserVO> list = biz.get();
					System.out.println("===전체조회===");
					for (UserVO v : list) {
						System.out.println(v);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				System.out.print("검색할 id를 입력하세요>>");
				String id1 = sc.next();
				try {
					UserVO user = biz.get(id1);
					System.out.println("===선택조회===");
					System.out.println(user);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:
				System.out.print("id를 입력하세요>>");
				String id2 = sc.next();
				System.out.println("\npassword를 입력하세요>>");
				String pwd = sc.next();
				System.out.println("\nname을 입력하세요>>");
				String name = sc.next();
				UserVO user = new UserVO(id2, pwd, name); 
				try {
					biz.register(user);
					System.out.println(user+"입력되었습니다.");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 4:
				System.out.print("id를 입력하세요>>");
				String id3 = sc.next();
				System.out.println("\npassword를 입력하세요>>");
				String pwd2 = sc.next();
				System.out.println("\nname을 입력하세요>>");
				String name2 = sc.next();
				UserVO user2 = new UserVO(id3, pwd2, name2);
				try {
					biz.modify(user2);
					System.out.println(user2+"수정되었습니다.");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 5:
				System.out.print("id를 입력하세요>>");
				String id4 = sc.next();
				try {
					biz.remove(id4);
					System.out.println(id4+"삭제되었습니다.");
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
