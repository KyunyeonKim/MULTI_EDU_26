package test.com.member;

import lombok.Data;

@Data
public class MemberVO {
	
	private String mid;//(_언다바)인식 오류를 대비한 변수
	private String _id;
	private int num;
	private String id;
	private String pw;
	private String name;
	private String tel;

}
