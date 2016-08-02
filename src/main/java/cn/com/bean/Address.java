package cn.com.bean;

import java.sql.Timestamp;

public class Address {
	private short address_id;
	private String address;
	private String address2;
	private String district;
	private short city_id;
	private String postal_code;
	private String phone;
	private Timestamp last_update;

	public short getAddress_id() {
		return address_id;
	}
	public void setAddress_id(short address_id) {
		this.address_id = address_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public short getCity_id() {
		return city_id;
	}
	public void setCity_id(short city_id) {
		this.city_id = city_id;
	}
	public String getPostal_code() {
		return postal_code;
	}
	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Timestamp getLast_update() {
		return last_update;
	}
	public void setLast_update(Timestamp last_update) {
		this.last_update = last_update;
	}
	public Address() {
		
	}
	@Override
	public String toString() {
		return "Address [address_id=" + address_id + ", address=" + address + "]";
	}
	
}
