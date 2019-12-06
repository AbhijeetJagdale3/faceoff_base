package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Poem extends AbstractedEntity{
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	private String pname;
	private String pm;
	
	
	public Poem() {
		System.out.println("In "+getClass().getName()+" "+new Exception().getStackTrace()[0].getMethodName());
	}
	
	public Poem(User user, String pname, String pm) {
		super();
		this.user = user;
		this.pname = pname;
		this.pm = pm;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getPm() {
		return pm;
	}
	public void setPm(String pm) {
		this.pm = pm;
	}
	
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	@Override
	public String toString() {
		return "Poem [poem=" + pm+ "]";
	}
	
	
}
