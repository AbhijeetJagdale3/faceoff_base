package com.app.pojos;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class InvList {
	
	@EmbeddedId
	CompositeKey id;
	
	    @ManyToOne
	    @JoinColumn(name = "sender_id")
	    private User sender;
	 
	    @ManyToOne
	    @JoinColumn(name = "receiver_id")
	    private User receiver;

		public CompositeKey getId() {
			return id;
		}

		public void setId(CompositeKey id) {
			this.id = id;
		}

		public User getSender() {
			return sender;
		}

		public void setSender(User sender) {
			this.sender = sender;
		}

		public User getReceiver() {
			return receiver;
		}

		public void setReceiver(User receiver) {
			this.receiver = receiver;
		}

		public InvList(CompositeKey id, User sender, User receiver) {
			super();
			this.id = id;
			this.sender = sender;
			this.receiver = receiver;
		}

		public InvList(CompositeKey id) {
			super();
			this.id = id;
		}
		public InvList() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "InvList [id=" + id + ", sender=" + sender + ", receiver=" + receiver + "]";
		}
		
	 

	    

}
