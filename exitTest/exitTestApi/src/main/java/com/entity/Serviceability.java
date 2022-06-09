package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="serviceability")
public class Serviceability {

	@Id
	int id;
	 @Column(name="pincodes")
	int pincodes;
	 @Column(name="pid")
		int pid;
	 @Column(name="estimateddays")
		int estimateddays;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPincodes() {
		return pincodes;
	}
	public void setPincodes(int pincodes) {
		this.pincodes = pincodes;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getEstimateddays() {
		return estimateddays;
	}
	public void setEstimateddays(int estimateddays) {
		this.estimateddays = estimateddays;
	}
	@Override
	public String toString() {
		return "Serviceability [id=" + id + ", pincodes=" + pincodes + ", pid=" + pid + ", estimateddays="
				+ estimateddays + "]";
	}
	 
}