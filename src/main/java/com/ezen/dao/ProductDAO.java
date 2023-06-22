package com.ezen.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.ezen.vo.ProductVO;

import util.DBManager;


public class ProductDAO {
	private static ProductDAO instance = new ProductDAO();
	
	private ProductDAO() {}
	
	public static ProductDAO getInstance() {
		return instance;
	}
	
	public List<ProductVO> productAllSelect() {	
		
		List<ProductVO> list = new ArrayList<ProductVO>();
		
		ProductDAO pDao = ProductDAO.getInstance();
		
		try {
			int k = 1;
			for(int i=1; i<=1; i++) {
				Document doc = Jsoup.connect("http://www.theskinfood.com/shop/shopbrand.html?type=P&xcode=019&sort=&page="+i).get();
				Elements images = doc.select("img.MS_prod_img_l");
				Elements name = doc.select("span.goods_name");
				Elements price = doc.select("span.sale_price");
				
				for(int j=0; j<images.size(); j++) {
					try {
//						System.out.println("번호 : " + k);
//						System.out.println("images : "	+ images.get(j).attr("src"));
//						System.out.println("name : " + name.get(j).text());
//						System.out.println("price : " + price.get(j).text());
						
						
						ProductVO vo = new ProductVO();
						vo.setCode(k);
						vo.setImage(images.get(j).attr("src"));
						vo.setName(name.get(j).text());
						vo.setPrice(price.get(j).text().substring(2)); 
						// 20,000 등으로 찍힘 int로 DB에 넣으려니까 오류남 / 중간에 , 잘라낼 방법 검색
						
						list.add(vo);
						pDao.productInsert(vo);
						
						k++;
						
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
		}catch(Exception e) {
		e.printStackTrace();
		}
		return list;
	}

	public void productInsert(ProductVO vo) {
		int result = -1;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into productlist values (?,?,?,?)";
				
		try {
			conn = DBManager.getConnection();
			
			System.out.println(conn);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getCode());
			pstmt.setString(2, vo.getName());
			pstmt.setInt(3, Integer.parseInt(vo.getPrice()));
			pstmt.setString(4, vo.getImage());
			
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				DBManager.close(conn, pstmt);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
