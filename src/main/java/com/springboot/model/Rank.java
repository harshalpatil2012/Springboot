package com.springboot.model;
// Generated 28 Apr, 2018 5:35:48 PM by Hibernate Tools 4.3.5.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.opensaml.ws.wspolicy.All;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Rank generated by hbm2java
 */
@Entity
@Table(name = "rank", catalog = "testdb")
public class Rank implements java.io.Serializable {

	private Integer rankId;
	private String rank;
	private String lastUpdatedBy;
	private Date lastUpdatedDate;
	private Set<AppUser> appUsers = new HashSet<AppUser>(0);

	public Rank() {
	}

	public Rank(String rank, String lastUpdatedBy, Date lastUpdatedDate) {
		this.rank = rank;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public Rank(String rank, String lastUpdatedBy, Date lastUpdatedDate, Set<AppUser> appUsers) {
		this.rank = rank;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastUpdatedDate = lastUpdatedDate;
		this.appUsers = appUsers;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "rankId", unique = true, nullable = false)
	public Integer getRankId() {
		return this.rankId;
	}

	public void setRankId(Integer rankId) {
		this.rankId = rankId;
	}

	@Column(name = "rank", nullable = false, length = 45)
	public String getRank() {
		return this.rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	@Column(name = "lastUpdatedBy", nullable = false, length = 45)
	public String getLastUpdatedBy() {
		return this.lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lastUpdatedDate", nullable = false, length = 19)
	public Date getLastUpdatedDate() {
		return this.lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rank")
	@JsonBackReference
	//@JsonManagedReference
	@JsonIgnore
	public Set<AppUser> getAppUsers() {
		return this.appUsers;
	}

	public void setAppUsers(Set<AppUser> appUsers) {
		this.appUsers = appUsers;
	}

}
