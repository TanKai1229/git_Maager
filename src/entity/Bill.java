package entity;

import java.sql.Date;

public class Bill {
	public int id;//主键
    public String code;//订单编号
    public String name;//商品名称
    public String supplier;//供应商
    public double money;//订单金额
    public int isPayment;//是否支付
    public Date time;//创建时间
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public int getIsPayment() {
		return isPayment;
	}
	public void setIsPayment(int isPayment) {
		this.isPayment = isPayment;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
}
