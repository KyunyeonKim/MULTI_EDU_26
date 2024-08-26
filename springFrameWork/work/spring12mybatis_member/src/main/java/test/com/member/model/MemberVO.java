package test.com.member.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
public class MemberVO {
	
	private int num;
	private String id;
	private String pw;
	private String name;
	private String tel;
	
	

}
