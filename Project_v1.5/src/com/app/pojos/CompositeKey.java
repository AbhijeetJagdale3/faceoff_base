package com.app.pojos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CompositeKey implements Serializable {

	@Column
	private Integer senderId;
	
	@Column
	private Integer receiveId;

	public Integer getSenderId() {
		return senderId;
	}

	public void setSenderId(Integer senderId) {
		this.senderId = senderId;
	}

	public Integer getReceiveId() {
		return receiveId;
	}

	public void setReceiveId(Integer receiveId) {
		this.receiveId = receiveId;
	}

	public CompositeKey(Integer senderId, Integer receiveId) {
		super();
		this.senderId = senderId;
		this.receiveId = receiveId;
	}

	public CompositeKey() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "InvListKey [senderId=" + senderId + ", receiveId=" + receiveId + "]";
	}
	
	
	
}
