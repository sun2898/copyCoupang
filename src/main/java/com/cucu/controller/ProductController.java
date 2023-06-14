package com.cucu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cucu.product.model.ProductVO;
import com.cucu.product.service.ProductService;
import com.cucu.product.service.ProductServiceImpl;
import com.cucu.review.model.ReviewVO;
import com.cucu.review.service.ReviewService;
import com.cucu.review.service.ReviewServiceImplements;


@WebServlet("*.pd") //상품
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public ProductController() {

		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);

	}

	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");

		String uri = request.getRequestURI();
		String conPath = request.getContextPath();

		String command = uri.substring( conPath.length() );

		System.out.println(command);

		ProductService service = new ProductServiceImpl();
		ReviewService rservice = new ReviewServiceImplements();
		
		//상품등록화면
		if(command.equals("/product/product_regist.pd")) {

			request.getRequestDispatcher("product_regist.jsp").forward(request, response);
		
		//상품등록기능
		}else if(command.equals("/product/registProduct.pd")) {
			
			service.insertProduct(request, response);
			session.setAttribute("product_seller", request.getAttribute("seller"));
			response.sendRedirect("product_list.pd");
			
		//리스트출력
		} else if(command.equals("/product/product_list.pd")) {
      
			List<ProductVO> list = service.getList(request, response);
			request.setAttribute("list", list);
			request.getRequestDispatcher("product_list.jsp").forward(request, response);
			

		} else if(command.equals("/product/product_detail.pd")) {
			List<ReviewVO> list = rservice.getReview(request, response);
			ProductVO vo = service.getProduct(request, response);
			request.setAttribute("vo", vo);
			request.setAttribute("list", list);

			request.getRequestDispatcher("product_detail.jsp").forward(request, response);
		} else if(command.equals("/product/mainpage.pd")) {

			response.sendRedirect("mainpage.jsp");
		//나의판매목록
		} else if(command.equals("/product/member_myselllist.pd")) {
			
			List<ProductVO> list = service.getList(request, response);
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("member_myselllist.jsp").forward(request, response);
		}

	}
}
