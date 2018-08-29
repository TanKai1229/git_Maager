package service;

import java.util.List;
import java.util.Map;

import entity.Bill;
import entity.Page;
import entity.Provider;

public interface BillService {

	//查看订单列表
    public List<Bill> Query(String name,String ment,Page page);
	
    //计算总页数
	public int count(String name,String ment);
	
	//查询总记录数
	public int count1(String name, String ment);
	
	/**
	 * 查询供应商
	 * @return
	 */
	public List<Provider> GetByName();
}
