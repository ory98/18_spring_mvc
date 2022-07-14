package com.spring.mvc.dataTransfer.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mvc.dataTransfer.dto.ProductDto;

@Repository
public class DataTransferDao {
	
	@Autowired
	private SqlSession sqlSession; // SqlSession 객체를 주입 
	
	/*
	 * 
	 * # Mapper To Dao
	 * 
	 *  - 한개의 데이터를 조회할 경우       .selectOne() 메서드를 사용한다.
	 *  - 한개 이상의 데이터를 조회할 경우  .selectList() 메서드를 사용하며 반환데이터는 List로 처리할 수 있다.
	 *      주의) Mapper 파일에서 반환타입(resultType)이 List가 아니고 selectList() 메서드로 List를 처리한다.
	 *  
	 *  - insert쿼리를 사용할 경우 .insert() 메서드를 사용한다.
	 *  - update쿼리를 사용할 경우 .update() 메서드를 사용한다.
	 *  - delete쿼리를 사용할 경우 .delete() 메서드를 사용한다.
	 *  
	 * */
	
	public void selectData1() {
		
		int count = sqlSession.selectOne("dataTransfer.select1");
		
		System.out.println("\n selectData1 \n");
		System.out.println("count : " + count);
	}
	
	public void selectData2() {
		
		System.out.println("\n selectData2 \n");
		
		List<ProductDto> productList =  sqlSession.selectList("dataTransfer.select2");
		for (ProductDto productDto : productList) {
			System.out.println(productDto);
		}
		
		
	}
	
	public void selectData3() {
		
		System.out.println("\n selectData3 \n");
	}
	
	public void selectData4() {
		
		System.out.println("\n selectData4 \n");
		
	}
	
	public void selectData5() {
		
		System.out.println("\n selectData5 \n");
		
	}

}
