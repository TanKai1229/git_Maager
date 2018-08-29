package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.Bill;
import entity.Page;
import entity.Provider;
import service.BillService;


@Controller
@RequestMapping("/user")
public class IndexController {
	@Autowired
//	@Qualifier("billService")
	private BillService billService;
	
	@RequestMapping("/index")
	public String Query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String queryProductName = request.getParameter("queryProductName");
		System.out.println(queryProductName);
		String queryIsPayment = request.getParameter("queryIsPayment");
		int ye = 1;
		String pageindex = request.getParameter("pageIndex");
		System.out.println(pageindex);
		if (pageindex != null) {
			ye = Integer.valueOf(pageindex);
		}
		if (queryIsPayment == null || queryIsPayment.equals("0")) {
			queryIsPayment ="";
		}
		if (queryIsPayment != null || !"0".equals(queryIsPayment)) {
			request.getSession().setAttribute("queryUserRole", queryIsPayment);
		}
		Page page = new Page();
		
		int i = billService.count(queryProductName, queryIsPayment);
		int ii = billService.count1(queryProductName, queryIsPayment);
		if (ye>ii) {
			ye = ii;
		}
		
		page.setTotalCount(i);
		request.setAttribute("totalCount", ii);
		page.setTotalPageCount(ii);
		request.setAttribute("totalPageCount", i);
		page.setCurrentPageNo(ye);
		request.setAttribute("currentPageNo", ye);
		List<Bill> list = billService.Query(queryProductName, queryIsPayment, page);
		request.setAttribute("billList", list);
		List<Provider> providerlist=billService.GetByName();
		request.setAttribute("providerList", providerlist);
		return "billlist";
	}

}
