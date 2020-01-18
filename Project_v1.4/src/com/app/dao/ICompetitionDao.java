package com.app.dao;

import java.util.List;

import com.app.pojos.InvList;
import com.app.pojos.User;

public interface ICompetitionDao {
	public String invitUser(Integer uid,Integer invitatorId);
	public String removeInvitation(Integer uid, Integer invitatorId);
	public List<User> getInvitationList(Integer uid) ;
	public String acceptInv(Integer uid,Integer invitatorId);

}
