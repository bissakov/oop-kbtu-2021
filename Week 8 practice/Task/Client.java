public class Client {
	private String name;
	private String phone;
	private String ID;

	public Client(String name, String phone, String ID) {
		this.name = name;
		this.phone = phone;
		this.ID = ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getId() {
		return ID;
	}

}