package com.app.dao;

import java.util.List;

import com.app.pojos.Shayari;

public interface IShayariDao {

	String addShayari(Shayari s,Integer uid);
	String removeShayari(Integer sid,Integer uid);
	List<Shayari> getShayariList(Integer uid);
}
