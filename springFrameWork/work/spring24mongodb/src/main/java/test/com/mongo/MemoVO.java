package test.com.mongo;

import lombok.Data;

@Data
public class MemoVO {
	
	private String mid;//(_언다바)인식 오류를 대비한 변수
	private String _id;
	private int age;
	private String name;
	private String office;
	private String phone;

}
