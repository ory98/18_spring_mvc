package com.spring.mvc.dynamicQuery.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.dataTransfer.dto.OrderDto;
import com.spring.mvc.dataTransfer.dto.ProductDto;
import com.spring.mvc.dynamicQuery.dao.DynamicQueryDao;

@Controller
@RequestMapping("/dynamicQuery")
public class DynamicQueryController {
	
	@Autowired
	private DynamicQueryDao dynamicQueryDao;
	
	@RequestMapping(value="/list" , method=RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("dynamicQuery/dynamicQueryList");
		mv.addObject("orderMapList", dynamicQueryDao.selectOrderList());
		return mv;
	}
	
	@RequestMapping(value="/ifEx" , method=RequestMethod.GET)
	public ModelAndView ifEx(@RequestParam Map<String, String> searchMap) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("dynamicQuery/dynamicQueryList");
		mv.addObject("orderMapList", dynamicQueryDao.ifEx(searchMap));
		return mv;
	}
	
	@RequestMapping(value="/chooseEx01" , method=RequestMethod.GET)
	public ModelAndView chooseEx01(@RequestParam Map<String, String> searchMap) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("dynamicQuery/dynamicQueryList");
		mv.addObject("orderMapList", dynamicQueryDao.chooseEx01(searchMap));
		return mv;
	}
	
	@RequestMapping(value="/chooseEx02" , method=RequestMethod.GET)
	public ModelAndView chooseEx02(@RequestParam("deliveryState") String deliveryState) { // (라디오)값이 하나일 경우 
		ModelAndView mv = new ModelAndView();
		mv.setViewName("dynamicQuery/dynamicQueryList");
		mv.addObject("orderMapList", dynamicQueryDao.chooseEx02(deliveryState));
		return mv;
	}
	
	@RequestMapping(value="/foreachEx01" , method=RequestMethod.GET)
	public String foreachEx01() {
		
		List<ProductDto> productList = new ArrayList<ProductDto>();
		for (int i = 50; i < 61; i++) {
			ProductDto productDto = new ProductDto();
			productDto.setProductCode("newProduct" + i);
			productDto.setProductName("새로등록된상품" + i);
			productDto.setProductPrice(77777);
			productDto.setProductDeliveryPrice(2500);
			productList.add(productDto);
		}
		
		dynamicQueryDao.foreachEx01(productList);
		
		return "home";
	}
	
	@RequestMapping(value="/foreachEx02" , method=RequestMethod.GET)
	public ModelAndView foreachEx02() {
		
		String[] memberIdList = new String[3];
		memberIdList[0] = "user1";
		memberIdList[1] = "user3";
		memberIdList[2] = "user7";
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("dynamicQuery/dynamicQueryList");
		mv.addObject("orderMapList", dynamicQueryDao.foreachEx02(memberIdList));
		return mv;
	}
	
	@RequestMapping(value="/whereEx" , method=RequestMethod.GET)
	public String whereEx() {
		
		// 1) memberId와 productCode가 모두 있을 경우 > 정상
//		OrderDto orderDto = new OrderDto();
//		orderDto.setMemberId("user1");
//		orderDto.setProductCode("product1");
		
		// 2) memberId만 있을 경우 > 정상 
//		OrderDto orderDto = new OrderDto();
//		orderDto.setMemberId("user1");
		
		// 3) productCode만 있을 경우 > 에러
		OrderDto orderDto = new OrderDto();
		orderDto.setProductCode("product1");
		
		dynamicQueryDao.whereEx(orderDto);
		
		return "home";
	}
	
	@RequestMapping(value="/setEx" , method=RequestMethod.GET)
	public String setEx() {
	
		ProductDto productDto = new ProductDto();
		productDto.setProductCode("product10");
		
		// 1) productPrice와 productDeliveryPrice가 모두 있을 경우 > 정상
//		productDto.setProductPrice(1);
//		productDto.setProductDeliveryPrice(1);
		
		// 2) productPrice만 있을 경우 > 에러 발생
		productDto.setProductPrice(-2);
		
		// 3) productDeliveryPrice만 있을 경우 > 정상
//		productDto.setProductDeliveryPrice(-2);
		
		dynamicQueryDao.setEx(productDto);
		
		return "home";
		
	}

}
