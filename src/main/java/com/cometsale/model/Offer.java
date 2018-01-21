package com.cometsale.model;

public class Offer {
	
	Student buyer;
	boolean lock;
	
	public Offer() {
		this.buyer=null;
		this.lock=false;
	}
	
	public Offer(Student buyer) {
		this.buyer=buyer;
	}
	
	public Student getBuyer() {
		return buyer;
	}
	public void setBuyer(Student buyer) {
		this.buyer = buyer;
	}
	
	public void setLock(Boolean Lock) {
		this.lock=Lock;
	}
	
	public Boolean getLock() {
		return this.lock;
	}

	
	public void lockOffer(){
		this.lock = true;
	}
	public void unlockOffer(){
		this.lock = false;
		
	}

}
