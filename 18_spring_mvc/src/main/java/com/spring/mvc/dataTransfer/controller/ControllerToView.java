package com.spring.mvc.dataTransfer.controller;

import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.dataTransfer.dto.MemberDto;


/*
 * < Controller에서 화면으로 넘어가는 메서드 > 
 * 
 * 예시 4,5,6 은 글자만 내보내기 때문에 ajax와 자주 사용한다. 
 * 
 * */

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
	public String modelEx(Model model) { //view로 넘겨줘야하기 때문에 리턴타입이 String
		
		List<MemberDto> memberList = new ArrayList<MemberDto>(); // Spring은 왼쪽은 인터페이스 형으로 만드는 것이 기본이다. 
		
		for (int i = 1; i < 11; i++) {
			
			MemberDto memberDto = new MemberDto();
			memberDto.setMemberId("memberId" + i);
			memberDto.setMemberName("익명유저" + i);
			memberDto.setHp("010-0000-0000");
			memberDto.setMemberGender("M");
			memberDto.setEmail("anonymous@gmail.com");
			memberDto.setResidence("서울특별시");
			memberList.add(memberDto);
			
		}
		
		model.addAttribute("method" , "Model");			// 전송할 data 작성
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
	@RequestMapping(value="/modelAndViewEx" , method=RequestMethod.GET)
	public ModelAndView modelAndViewEx() { //return 타입은 String이 아닌 ModelAndView(혼자서 다 처리) 클래스를 작성한다.
		
		List<MemberDto> memberList = new ArrayList<MemberDto>(); // Spring은 왼쪽은 인터페이스 형으로 만드는 것이 기본이다. 
		
		for (int i = 11; i < 21; i++) {
			
			MemberDto memberDto = new MemberDto();
			memberDto.setMemberId("memberId" + i);
			memberDto.setMemberName("익명유저" + i);
			memberDto.setHp("010-0000-0000");
			memberDto.setMemberGender("F");
			memberDto.setEmail("anonymous@gmail.com");
			memberDto.setResidence("경기도");
			memberList.add(memberDto);
			
		}
		// setViewName 메서드 대신 생성자의 인수로 jsp 파일경로를 작성할 수 있다.
		// ModelAndView mv = new ModelAndView("dataTransfer/memberList"); > 밑에 두줄과 같음 	
		
		ModelAndView mv = new ModelAndView(); 		// ModelAndView객체를 생성한다.
		mv.setViewName("dataTransfer/memberList");	// setViewName을 통해 포워딩할 jsp파일 경로를 작성한다.
		
		mv.addObject("method" , "ModelAndView"); 	// addObject를 통해 view로 전송할 데이터를 작성한다.
		mv.addObject("memberList" , memberList); 	// List에 데이터를 넣는다.
		
		return mv; 									// ModelAndView객체를 반환한다.
	}
	


	/*
	 * 
	 * 예시 3) httpServeletRequest
	 * 
	 * - HttpServletRequest객체를 생성하여 setAttribute("속성명", "값") 메서드로 뷰에서 사용할 데이터를 전달 한다.
	 * 
	 * */
	
	@RequestMapping(value="/requestEx" , method=RequestMethod.GET)
	public String requestEx(HttpServletRequest request) {
		
		List<MemberDto> memberList = new ArrayList<MemberDto>(); // Spring은 왼쪽은 인터페이스 형으로 만드는 것이 기본이다. 
		
		for (int i = 21; i < 31; i++) {
			
			MemberDto memberDto = new MemberDto();
			memberDto.setMemberId("memberId" + i);
			memberDto.setMemberName("익명유저" + i);
			memberDto.setHp("010-0000-0000");
			memberDto.setMemberGender("M");
			memberDto.setEmail("anonymous@gmail.com");
			memberDto.setResidence("강원도");
			memberList.add(memberDto);
			
		}
		
		request.setAttribute("method", "HttpServletRequest");
		request.setAttribute("memberList", memberList );
		
		
		return "dataTransfer/memberList";
	}



	/*
	 *
	 *	# 예시 4) ResponseBody  
	 *	
	 *	- ResponseBody와 기능이 같으며 헤더와 상태 코드를 제외한 html 본문만 전송한다.
	 *	- 한글 데이터가 전송이 되지 않으며 **** 한글 전송시 ResponseEntity의 객체의 
	 *	  객체명.add("Content-Type", "text/html; charset=utf-8") 메서드를 이용하여 헤더 정보를 추가하여 사용한다.
	 *
	 */
	
	//간단한 jsp를 java에서 처리해서 화면으로 보내줌 
	@RequestMapping(value="/responseBodyEx" , method=RequestMethod.GET)
	public @ResponseBody String responseBodyEx() { // @ResponseBody이 붙으면 html로 화면에 나감 		
		
		// String data = "<h1> BoardMain </h1>"; 
		
		String data = "<script>";
			   data += "alert('로그인 성공');";
			   data += "location.href='modelEx';";
			   data += "</script>";
		
		return data; // 새로운 html파일이 나타남 
	}

	/*
	 *
	 *	# 예시 5) ResponseEntity(응답개체)
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
	
	@RequestMapping(value="/responseEntityEx" , method=RequestMethod.GET)
	public ResponseEntity<Object> responseEntityEx() { // 한글을 쓰기위한 메서드
		
		// 1) 필수
		// return new ResponseEntity<Object>(HttpStatus.OK); // 빈화면 , 응답은 함
		
		// 2)
		// return new ResponseEntity<Object>("<h1>html페이지를 반환합니다.</h1>" , HttpStatus.OK); // 한글이 화면에 나오지 않음
		
		// 3) 
		// return new ResponseEntity<Object>("<h1>html페이지를 반환합니다.</h1>" , new HttpHeaders() , HttpStatus.OK); // 한글이 화면에 나오지 않음
		
		// 한글화 처리 과정 
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Content-Type", "text/html; charset=UTF-8"); //jsp파일의 contentType="text/html; charset=UTF-8"
		
		return new ResponseEntity<Object>("<h1>html 페이지를 반환합니다.</h1>" , httpHeaders , HttpStatus.OK);
		
	}
	
}

/*
 *
 *	# 예시 6) RestController 
 *	
 *	- ResponseBody와 기능이 같으며 헤더와 상태 코드를 제외한 html 본문만 전송한다.
 *	- 클래스에 @RestController어노테이션을 작성하여 구현한다. 
 *
 */

@RestController // html로 화면에 나감 
class RestControllerEx {
	
	@RequestMapping(value="/restControllerEx" , method=RequestMethod.GET)
	public String responseBodyEx() { 
		
		String data = "<script>";
			   data += "alert('success login');";
			   data += "location.href='modelEx';";
			   data += "</script>";
		
		return data; 
	}
}
