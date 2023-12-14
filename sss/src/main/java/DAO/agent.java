package DAO;

public class agent {

	private int  id ;
	
    private String fullname ;
	
	private String username ;
	
	private String email ;
	
	private String number ;
	
	private String password ;
	
	private int gender ;
	
	
	public agent(String fullname, String username, String email, String number, String password, int gender2) {
		this.fullname = fullname;
		this.username = username;
		this.email = email;
		this.number = number;
		this.password = password;
		this.gender = gender2;
	}
	
	

	public agent() {
		super();
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	
	
}
