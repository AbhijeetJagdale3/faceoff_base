package com.app.dao;

import java.util.List;

import com.app.pojos.Poem;

public interface IPoemDao {
	String addPoem(Poem p,Integer uid);
	String removePoem(Integer pid,Integer uid);
	List<Poem> getPoemList(Integer uid);

}
