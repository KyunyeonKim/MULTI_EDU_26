package test.com.member;


import java.util.Date;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Data
@Entity  //자바의객체와 DB테이블을 매칭시켜주는 기능
@Table(name="Member_JPA",
uniqueConstraints = 
{@UniqueConstraint(columnNames = {"user_id"})})
public class MemberVO_JPA {
	
	@Id  //pk설정
	@Column(name="num")// 컬럼이름 설정
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto_increment
	private int num;
	
	@Column(name="user_id",nullable = false)
	private String id;
	
	@Column(name="user_pw",nullable = false)
	private String pw;
	
	@Column(name="user_name",nullable = false)
	private String name;
	
	@Column(name="user_tel",nullable = false)
	private String tel;
	
	@Column(name="regdate",insertable = false,
			columnDefinition = "DATETIME(0) DEFAULT CURRENT_TIMESTAMP") //입력시 now()으로 처리,수정시 널값반영(이럴때는 new Date()처리해준다.)
	private Date regdate;

}
