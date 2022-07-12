package com.spring.mvc.dataTransfer.dto;

import org.springframework.stereotype.Component;

@Component	// @Component를 작성하여 해당 클래스가 Component임을 스프링 bean에 등록한다.(선언한다)
public class MemberDto {
	
	private String memberId;
	private String memberName;
	private String memberGender;
	private String hp;
	private String email;
	private String regidence;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberGender() {
		return memberGender;
	}
	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRegidence() {
		return regidence;
	}
	public void setRegidence(String regidence) {
		this.regidence = regidence;
	}
	
	@Override
	public String toString() {
		return "MemberDto [memberId=" + memberId + ", memberName=" + memberName + ", memberGender=" + memberGender
				+ ", hp=" + hp + ", email=" + email + ", regidence=" + regidence + "]";
	}
	
	
	
}
