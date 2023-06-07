package it.unibo.sweng.simplegwt.shared;

import java.io.Serializable;

public abstract class Card implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
	private int Id;
	//TODO: Lista Possesso
	//TODO: Lista Desiderio

	public Card() {}
	
	public Card(String nome, int Id)
	{
		this.name=nome;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getId()
	{
		return this.Id;
	}
	
	public void setId(int Id)
	{
		this.Id=Id;
	}
	
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public abstract String returnCard();

}
