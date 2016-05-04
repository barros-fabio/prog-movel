package com.example.bookofpicaretation.entity;

public class Issue {
	private long id;
	private String name;
	private String description;
	private double value;
	private long type;
	private boolean closed;
	private Collaborator collaborator;
	
	public static long NOMONEYINVOLVED = 0;
	public static long TOPAY = 1;
	public static long TORECEIVE = 2;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public long getType() {
		return type;
	}
	public void setType(long type) {
		this.type = type;
	}
	public boolean isClosed() {
		return closed;
	}
	public void setClosed(boolean closed) {
		this.closed = closed;
	}
	public Collaborator getCollaborator() {
		return collaborator;
	}
	public void setCollaborator(Collaborator collaborator) {
		this.collaborator = collaborator;
	}
	
	@Override
	public String toString() {
		StringBuilder ret = new StringBuilder(name);
		if(type == 1) 	//to pay
			ret.append(" : -" + value);
		
		if(type == 2) 	//to receive
			ret.append(" : +" + value);
			
		return ret.toString();
	}
}
