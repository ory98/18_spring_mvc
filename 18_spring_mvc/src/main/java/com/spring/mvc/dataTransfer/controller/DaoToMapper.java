package com.spring.mvc.dataTransfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.mvc.dataTransfer.dao.DataTransferDao;
import com.spring.mvc.dataTransfer.dto.ProductDto;

// 2번으로 만든다.
@Controller
public class DaoToMapper { // IoC : 제어의 역행, 제어의 역전 > @를 사용하여 스프링이 관리자가 된다. > 일체형 배터리와 조립형 배터리의 차이가 이유다.
	
	// private DataTransferDao temp = new DataTransferDao();
	
	// 1번으로 스프링이 new를 한다. (조립형 배터리 - 의존,결합성을 낮춘다.)
	@Autowired
	private DataTransferDao dataTransferDao;
	
	// 예시 1) 단일 데이터 전송
	@RequestMapping(value="/getInfo",method=RequestMethod.GET)
	public String getInfo() { 
		dataTransferDao.memberInfo("user7"); // 아이디가 user7
		return "home";
	}

	// 예시 2) DTO 전송
	@RequestMapping(value="/addProduct",method=RequestMethod.GET)
	public String addProduct() {
		
		ProductDto productDto = new ProductDto();
		productDto.setProductCode("newProduct1");
		productDto.setProductName("신상품");
		productDto.setProductPrice(100000);
		productDto.setProductDeliveryPrice(2500);
		
		dataTransferDao.insertProduct(productDto);
		
		return "home";
	}
	
	
	// 예시 3) Map 전송
	
	

}
