package com.ezen.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.ProductDAO;
import com.ezen.vo.ProductVO;

public class ProductListAction implements Action{

	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDAO pDao = ProductDAO.getInstance();
		List<ProductVO> list = pDao.productAllSelect();
		
		// 데이터가 있으면 list에 DB데이터 담기, DB에 저장된 데이터가 없으면 크롤링한 내용을 DB에 저장하고 list에 담아 화면으로 전달
		if(list.size() == 0) {
			list = pDao.productAllAdd();
		}
		request.setAttribute("productList", list);
		
		// 페이징
		int page = 1; // 시작 페이지

		int itemsInAPage = 20;						// 한 페이지에 출력할 게시물 수
		int totalCount = pDao.countProduct();		// DB에서 전체 게시물 카운트
		int totalPage = (int) Math.ceil(totalCount / (double) itemsInAPage);
		request.setAttribute("totalCount", totalCount);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("page", page);
		
		
		String url = "/product/productList.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
	}
}	
