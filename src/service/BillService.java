package service;

import java.util.List;
import java.util.Map;

import entity.Bill;
import entity.Page;
import entity.Provider;

public interface BillService {

	//�鿴�����б�
    public List<Bill> Query(String name,String ment,Page page);
	
    //������ҳ��
	public int count(String name,String ment);
	
	//��ѯ�ܼ�¼��
	public int count1(String name, String ment);
	
	/**
	 * ��ѯ��Ӧ��
	 * @return
	 */
	public List<Provider> GetByName();
}
