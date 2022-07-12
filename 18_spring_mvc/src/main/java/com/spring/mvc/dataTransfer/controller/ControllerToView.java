package com.spring.mvc.dataTransfer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.dataTransfer.dto.MemberDto;

@Controller		// @Controller를 작성하여 해당 클래스가 Controller임을 스프링 bean에 등록한다.(선언한다)
public class ControllerToView {
	
	/*
	 * 
	 *  예시 1) Model
	 *  
	 *  - 메서드의 파라미터로 Model을 추가하여 addAddtribute("속성명","값") 메서드로 뷰에서 사용할 데이터를 전송 한다.
	 * 
	 * */
	
	//value에는 url주소를 명시, method는 요청 타입을 명시한다. (생략시 GET, POST 둘다 사용)
	@RequestMapping(value="/modelEx" , method=RequestMethod.GET)
	public String modelEx(Model model) {
		
		List<MemberDto> memberList = new ArrayList<MemberDto>(); // Spring은 왼쪽은 인터페이스 형으로 만드는 것이 기본이다. 
		
		for (int i = 1; i < 11; i++) {
			
			MemberDto memberDto = new MemberDto();
			memberDto.setMemberId("memberId" + i);
			memberDto.setMemberName("익명유저" + i);
			memberDto.setHp("010-0000-0000");
			memberDto.setMemberGender("M");
			memberDto.setEmail("anonymous@gmail.com");
			memberDto.setRegidence("서울특별시");
			memberList.add(memberDto);
			
		}
		
		model.addAttribute("method" , "Model");			// 타입 명시
		model.addAttribute("memberList" , memberList);	// data 태움
		
		return "dataTransfer/memberList"; // servlet-context.xml에 명시된 대로 포워딩 시킬 jsp파일을 작성해 준다.
	}
	

	/*
	 * 
	 * 예시 2) ModelAndView
	 * 
	 * - ModelAndView객체를 생성하여  addObject("속성명", "값") 메서드로 뷰에서 사용할 데이터를 전달 한다.
	 * - 관용적으로 객체명으로 mv 혹은 mav로 작성한다.
	 * 
	 * */
	@RequestMapping(value="/ModelAndView" , method=RequestMethod.GET)
	public ModelAndView modelAndViewEx() {
		
		List<MemberDto> memberList = new ArrayList<MemberDto>(); // Spring은 왼쪽은 인터페이스 형으로 만드는 것이 기본이다. 
		
		for (int i = 11; i < 21; i++) {
			
			MemberDto memberDto = new MemberDto();
			memberDto.setMemberId("memberId" + i);
			memberDto.setMemberName("익명유저" + i);
			memberDto.setHp("010-0000-0000");
			memberDto.setMemberGender("F");
			memberDto.setEmail("anonymous@gmail.com");
			memberDto.setRegidence("경기도");
			memberList.add(memberDto);
			
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("dataTransfer/memberList"); // jsp이동
		mv.addObject("method" , "ModelAndView"); 	 // 타입 알려준다.
		mv.addObject("memberList" , memberList); 	 // data 태운다.
		
		return mv; // 객체 반환(object)
	}
	


	/*
	 * 
	 * 예시 3) httpServeletRequest
	 * 
	 * - HttpServletRequest객체를 생성하여 setAttribute("속성명", "값") 메서드로 뷰에서 사용할 데이터를 전달 한다.
	 * 
	 * */



	/*
	 *
	 *	# 예시 4) ResponseBody  
	 *	
	 *	- ResponseBody와 기능이 같으며 헤더와 상태 코드를 제외한 html 본문만 전송한다.
	 *	- 한글 데이터가 전송이 되지 않으며 한글 전송시 ResponseEntity의 객체의 
	 *	  객체명.add("Content-Type", "text/html; charset=utf-8") 메서드를 이용하여 헤더 정보를 추가하여 사용한다.
	 *
	 */



	/*
	 *
	 *	# 예시 5) ResponseEntity
	 *
	 *	 - HTTP에서 Request와 Response 동작시 전송되는 정보는 크게 body(몸체) , headers(헤더), status code(상태 코드)가 있다.
	 *	 - @ResponseBody 에는 없는 헤더와 상태코드가 함께 들어간다.
	 *	
	 *	1. body (옵션)
	 *	- HTTP의 request 또는 response가 전송하는 데이터(본문)
	 *	
	 *	2. headers (옵션)
	 *	- HTTP의 request 또는 response에 대한 부가적인 정보
	 *	
	 *	3. status code (필수)
	 *	- 클라이언트의 요청이 성공적으로 처리되었는지 상태를 알려주는 것 
	 *
	 *
	 */

	/*
	 *
	 *	# 예시 6) RestController 이용 
	 *	
	 *	- ResponseBody와 기능이 같으며 헤더와 상태 코드를 제외한 html 본문만 전송한다.
	 *	- 클래스에 @RestController어노테이션을 작성하여 구현한다. 
	 *
	 */

}
