package org.twiliofaces.example.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class UserToken implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private Date dateMin;
	private Date dateMax;
	private String phoneNumber;

	public UserToken() {
		// TODO Auto-generated constructor stub
	}

	public UserToken(String phoneNumber, Date dateMin, Date dateMax) {
		this.phoneNumber = phoneNumber;
		this.dateMax = dateMax;
		this.dateMin = dateMin;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getDateMin() {
		return dateMin;
	}

	public void setDateMin(Date dateMin) {
		this.dateMin = dateMin;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getDateMax() {
		return dateMax;
	}

	public void setDateMax(Date dateMax) {
		this.dateMax = dateMax;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
