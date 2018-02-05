package entity;

public class check {
	private int phone_number ,qq_id;
	private String first_wish;
	private String second_wish;
	private String reason;
	private String favourite;
	public check() {
		super();
		
	}
	public int getQq_id() {
		return qq_id;
	}
	public void setQq_id(int qq_id) {
		this.qq_id = qq_id;
	}
	public int getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	}
	public String getFirst_wish() {
		return first_wish;
	}
	public void setFirst_wish(String first_wish) {
		this.first_wish = first_wish;
	}
	public String getSecond_wish() {
		return second_wish;
	}
	public void setSecond_wish(String second_wish) {
		this.second_wish = second_wish;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getFavourite() {
		return favourite;
	}
	public void setFavourite(String favourite) {
		this.favourite = favourite;
	}

}
