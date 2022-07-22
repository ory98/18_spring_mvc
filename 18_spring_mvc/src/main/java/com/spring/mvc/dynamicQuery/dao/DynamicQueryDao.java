package com.spring.mvc.dynamicQuery.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mvc.dataTransfer.dto.ProductDto;

@Repository
public class DynamicQueryDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<Map<String, Object>> selectOrderList() { // DB에서 꺼내와 
		return sqlSession.selectList("dynamicQuery.list"); // controller에게 return해줌 
	}
	
	public List<Map<String, Object>> ifEx(Map<String, String> searchMap) { // searchMap에서 데이터를 넘겨주고 DB에서 꺼내와 
		return sqlSession.selectList("dynamicQuery.ifEx" , searchMap); // controller에게 return해줌 
	}
	
	public List<Map<String, Object>> chooseEx01(Map<String, String> searchMap) { // 컨트롤러에서 chooseEx01 searchMap의 데이터를 받고 DB에 보낸후  
		return sqlSession.selectList("dynamicQuery.chooseEx01" , searchMap); // 조건에 맞는 데이터를 controller에게 return해줌 
	}
	
	public List<Map<String, Object>> chooseEx02(String deliveryState) { // 컨트롤러에서 chooseEx02 deliveryState의 단일데이터를 받고 DB에 보낸후  
		return sqlSession.selectList("dynamicQuery.chooseEx02" , deliveryState); // 조건에 맞는 데이터를 controller에게 return해줌 
	}
	public void foreachEx01(List<ProductDto> productList) {
		sqlSession.insert("dynamicQuery.foreachEx01" , productList); // mapper에게 넘김 (collection에는 list라고만 입력)
	}
	public List<Map<String, Object>> foreachEx02(String[] memberIdList) { // 배열을 넘긴다.   
		return sqlSession.selectList("dynamicQuery.foreachEx02" , memberIdList); 
	}
	
}
