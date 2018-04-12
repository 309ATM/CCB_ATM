package seventh.dbc;

public class Student {
	private long id;
	private String name;
	private String address;
	private long phoneNum;
	private long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(long phoneNum) {
		this.phoneNum = phoneNum;
	}
	@Override
	public String toString() {
		return "student [id=" + id + ", name=" + name + ", address=" + address + ", phoneNum=" + phoneNum + "]";
	}
	
}
