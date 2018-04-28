package com.springboot.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the trainingstatus database table.
 * 
 */
@Entity
@NamedQuery(name="Trainingstatus.findAll", query="SELECT t FROM Trainingstatus t")

public class Trainingstatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int trainingStatusId;

	private String lastUpdatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdatedDate;

	private String trainingStatus;

	//bi-directional many-to-one association to AppUser
	@OneToMany(mappedBy="trainingstatus" ,fetch=FetchType.EAGER)
	//@JsonBackReference
	@JsonBackReference
	@JsonIgnore
	private List<AppUser> appUsers;

	public Trainingstatus() {
	}

	public int getTrainingStatusId() {
		return this.trainingStatusId;
	}

	public void setTrainingStatusId(int trainingStatusId) {
		this.trainingStatusId = trainingStatusId;
	}

	public String getLastUpdatedBy() {
		return this.lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getLastUpdatedDate() {
		return this.lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getTrainingStatus() {
		return this.trainingStatus;
	}

	public void setTrainingStatus(String trainingStatus) {
		this.trainingStatus = trainingStatus;
	}

	public List<AppUser> getAppUsers() {
		return this.appUsers;
	}

	public void setAppUsers(List<AppUser> appUsers) {
		this.appUsers = appUsers;
	}

	public AppUser addAppUser(AppUser appUser) {
		getAppUsers().add(appUser);
		appUser.setTrainingstatus(this);

		return appUser;
	}

	public AppUser removeAppUser(AppUser appUser) {
		getAppUsers().remove(appUser);
		appUser.setTrainingstatus(null);

		return appUser;
	}

}