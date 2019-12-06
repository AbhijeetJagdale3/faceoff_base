package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table
@Entity
public class Competition extends AbstractedEntity {
	//newly added need some more work
	private String nameOfComp; 
	
	private User user1;
	private User user2;
	private Integer likes1;
	private Integer likes2;
	private Poem poem1;
	private Poem poem2;
	
	
	public Competition() {
		System.out.println("In "+getClass().getName()+" "+new Exception().getStackTrace()[0].getMethodName());
		
	}
	public Competition(String nameOfComp, User user1, User user2, Integer likes1, Integer likes2, Poem poem1,
			Poem poem2) {
		super();
		this.nameOfComp = nameOfComp;
		this.user1 = user1;
		this.user2 = user2;
		this.likes1 = likes1;
		this.likes2 = likes2;
		this.poem1 = poem1;
		this.poem2 = poem2;
	}
	public String getNameOfComp() {
		return nameOfComp;
	}
	public void setNameOfComp(String nameOfComp) {
		this.nameOfComp = nameOfComp;
	}
	public User getUser1() {
		return user1;
	}
	public void setUser1(User user1) {
		this.user1 = user1;
	}
	public User getUser2() {
		return user2;
	}
	public void setUser2(User user2) {
		this.user2 = user2;
	}
	public Integer getLikes1() {
		return likes1;
	}
	public void setLikes1(Integer likes1) {
		this.likes1 = likes1;
	}
	public Integer getLikes2() {
		return likes2;
	}
	public void setLikes2(Integer likes2) {
		this.likes2 = likes2;
	}
	public Poem getPoem1() {
		return poem1;
	}
	public void setPoem1(Poem poem1) {
		this.poem1 = poem1;
	}
	public Poem getPoem2() {
		return poem2;
	}
	public void setPoem2(Poem poem2) {
		this.poem2 = poem2;
	}
	@Override
	public String toString() {
		return "Competition [nameOfComp=" + nameOfComp + ", user1=" + user1 + ", user2=" + user2 + ", likes1=" + likes1
				+ ", likes2=" + likes2 + ", poem1=" + poem1 + ", poem2=" + poem2 + "]";
	}
	
	

}
