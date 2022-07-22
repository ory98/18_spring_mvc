package com.spring.mvc.dynamicQuery.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

}
