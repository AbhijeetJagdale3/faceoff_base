package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "user")
public class User extends AbstractedEntity {
	
	@Column(name = "user_name",length = 50)
	private String username;
	@Column(name = "email_id",unique = true,length = 50)
	private String email;
	@Column(name = "user_password",length = 40)
	private String password;
	
	//List of shayari of respective user
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Shayari> shayariList=new ArrayList<Shayari>();
	
	//List of poem of respective user
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Poem> poemList=new ArrayList<Poem>();
	
	//Under Constuction
	
	//@ManyToMany(mappedBy = "user", cascade = CascadeType.ALL)
	//private List<Competition> participation=new ArrayList<Competition>();
	
	//private List<User> challenges=new ArrayList<User>();
	
	public User() {
		System.out.println("In "+getClass().getName()+" "+new Exception().getStackTrace()[0].getMethodName());;
	}
	public User( String username, String email, String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void addShayariInList(Shayari s)
	{
		shayariList.add(s);
		s.setUser(this);
	}
	public void removeShayariFromList(Integer sid)
	{
		for(Shayari s:shayariList)
		{
			if(s.getId()==sid)
			{
				shayariList.remove(s);
				s.setUser(null);
				break;
			}
		}
	}
	public void addPoemInList(Poem p)
	{
		poemList.add(p);
		p.setUser(this);
	}
	public void removePoemFromList(Integer pid)
	{
		for(Poem p:poemList)
		{
			if(p.getId()==pid)
			{
				poemList.remove(p);
				p.setUser(null);
				break;
			}
		}
	}
	
	public List<Shayari> getShayariList() {
		return shayariList;
	}
	public void setShayariList(List<Shayari> shayariList) {
		this.shayariList = shayariList;
	}
	public List<Poem> getPoemList() {
		return poemList;
	}
	public void setPoemList(List<Poem> poemList) {
		this.poemList = poemList;
	}
	
	/*
	 * public List<Competition> getParticipation() { return participation; } public
	 * void setParticipation(List<Competition> participation) { this.participation =
	 * participation; }
	 */

	/*
	 * public List<User> getChallenges() { return challenges; } public void
	 * setChallenges(List<User> challenges) { this.challenges = challenges; }
	 */
	@Override
	public String toString() {
		return "User [id=" + getId() + ", username=" + username + ", email=" + email + "]";
	}
	
	
	
}
