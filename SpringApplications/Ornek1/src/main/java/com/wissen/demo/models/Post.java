package com.wissen.demo.models;

public class Post {
	public int id;
	public String baslik;
	public String icerik;
	
	public Post(int id, String baslik, String icerik) {
		this.id = id;
		this.baslik = baslik;
		this.icerik = icerik;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBaslik() {
		return baslik;
	}

	public void setBaslik(String baslik) {
		this.baslik = baslik;
	}

	public String getIcerik() {
		return icerik;
	}

	public void setIcerik(String icerik) {
		this.icerik = icerik;
	}
}
