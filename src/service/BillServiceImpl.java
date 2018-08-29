package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.Billdao;
import entity.Bill;
import entity.Page;
import entity.Provider;

@Service("billService")
public class BillServiceImpl implements BillService {

	@Autowired
	private Billdao billdao;

	//查询所有数据加分页
	@Override
	public List<Bill> Query(String name, String ment, Page page) {
		List<Bill> list = new ArrayList<Bill>();
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("name",name);
		map.put("isPayment",ment);
		map.put("currentPageNo",(page.getCurrentPageNo()-1)*5);
		list = billdao.Query(map);
		return list;
	}

	
	//计算总页数
	@Override
	public int count(String name, String ment) {
		int count = 0;
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("name", name);
		map.put("isPayment", ment);
		int count1 = billdao.count(map);
		count = count1%5==0?count1/5:(count1/5)+1;
		return count;
	}


	
	//查询总记录数
	@Override
	public int count1(String name, String ment) {
		int count = 0;
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("name", name);
		map.put("isPayment", ment);
		count = billdao.count1(map);
		return count;
	}


	@Override
	public List<Provider> GetByName() {
		List<Provider> list =billdao.GetByName();
		return list;
	}



}
