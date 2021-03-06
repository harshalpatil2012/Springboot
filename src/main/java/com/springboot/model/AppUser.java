package com.springboot.model;
// Generated 28 Apr, 2018 5:35:48 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * AppUser generated by hbm2java
 */
@Entity
@Table(name = "app_user", catalog = "testdb")
public class AppUser implements java.io.Serializable {

	private Integer id;
	private Rank rank;
	private Trainingstatus trainingstatus;
	private String name;
	private int age;
	private double salary;

	public AppUser() {
	}

	public AppUser(Rank rank, Trainingstatus trainingstatus, String name, int age, double salary) {
		this.rank = rank;
		this.trainingstatus = trainingstatus;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rankId", nullable = false)
	//@JsonBackReference
	@JsonManagedReference
	public Rank getRank() {
		return this.rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "trainingStatusId", nullable = false)
	//@JsonBackReference
	@JsonManagedReference
	//@JsonBackReference
	//@JsonIgnore
	public Trainingstatus getTrainingstatus() {
		return this.trainingstatus;
	}

	public void setTrainingstatus(Trainingstatus trainingstatus) {
		this.trainingstatus = trainingstatus;
	}

	@Column(name = "name", nullable = false, length = 30)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "age", nullable = false)
	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Column(name = "salary", nullable = false, precision = 22, scale = 0)
	public double getSalary() {
		return this.salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
