package com.app.pojos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User extends AbstractedEntity {

	@Column(name = "user_name", length = 50)
	private String username;
	@Column(name = "email_id", unique = true, length = 50)
	private String email;
	@Column(name = "user_password", length = 40)
	private String password;

	// List of shayari of respective user
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Shayari> shayariList = new ArrayList<Shayari>();

	// List of poem of respective user
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Poem> poemList = new ArrayList<Poem>();
	
	@OneToMany(mappedBy = "sender",cascade = CascadeType.ALL)
	private List<InvList> senderList=new ArrayList<InvList>();

	@OneToMany(mappedBy = "receiver",cascade = CascadeType.ALL)
	private List<InvList> receiverList=new ArrayList<InvList>();

	
	public User() {
		System.out.println("In " + getClass().getName() + " " + new Exception().getStackTrace()[0].getMethodName());
		;
	}

	public User(String username, String email, String password) {
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

	
//	public List<User> getSendedInvitation() {
//		return sendedInvitation;
//	}
//
//	public void setSendedInvitation(List<User> sendedInvitation) {
//		this.sendedInvitation = sendedInvitation;
//	}
//
//	public List<User> getReceivedInvitation() {
//		return receivedInvitation;
//	}
//
//	public void setReceivedInvitation(ArrayList<User> receivedInvitation) {
//		this.receivedInvitation = receivedInvitation;
//	}

	

	public List<Shayari> getShayariList() {
		return shayariList;
	}

	
	public List<InvList> getSenderList() {
		return senderList;
	}

	public void setSenderList(List<InvList> senderList) {
		this.senderList = senderList;
	}

	public List<InvList> getReceiverList() {
		return receiverList;
	}

	public void setReceiverList(List<InvList> receiverList) {
		this.receiverList = receiverList;
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
//	public List<Integer> getInvitation() {
//		return invitation;
//	}
//	public void setInvitation(List<Integer> invitation) {
//		this.invitation = invitation;
//	}

	public void addShayariInList(Shayari s) {
		shayariList.add(s);
		s.setUser(this);
	}

	public void removeShayariFromList(Integer sid) {
		for (Shayari s : shayariList) {
			if (s.getId() == sid) {
				shayariList.remove(s);
				s.setUser(null);
				break;
			}
		}
	}

	public void addPoemInList(Poem p) {
		poemList.add(p);
		p.setUser(this);
	}

	public void removePoemFromList(Integer pid) {
		for (Poem p : poemList) {
			if (p.getId() == pid) {
				poemList.remove(p);
				p.setUser(null);
				break;
			}
		}
	}

	public void addInSenderList(InvList i)
	{
		
		senderList.add(i);
		
		i.setSender(this);
	}
	public void addInReceiverList(InvList i)
	{
		i.setReceiver(this);
		receiverList.add(i);
	}
//	public void addReceivedInvitation(User u) {
//		this.receivedInvitation.add(u);
//	}
//
//	public void addSendedInvitation(User u) {
//		this.sendedInvitation.add(u);
//	}

	@Override
	public String toString() {
		return "User [id=" + getId() + ", username=" + username + ", email=" + email + "]";
	}
}
