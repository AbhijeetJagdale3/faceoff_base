package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Shayari extends AbstractedEntity{
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	private String sh;
	
	public Shayari() {
		System.out.println("In "+getClass().getName()+" "+new Exception().getStackTrace()[0].getMethodName());
	}
	
	public Shayari(User user, String sh) {
		super();
		this.user = user;
		this.sh = sh;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getSh() {
		return sh;
	}
	public void setSh(String s) {
		this.sh = s;
	}
	@Override
	public String toString() {
		return "Shayari [shayari=" + sh + "]";
	}
	

}
