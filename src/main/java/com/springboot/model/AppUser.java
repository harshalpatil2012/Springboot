package com.springboot.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


/**
 * The persistent class for the app_user database table.
 * 
 */
@Entity
@Table(name="app_user")
@NamedQuery(name="AppUser.findAll", query="SELECT a FROM AppUser a")
public class AppUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;

	private int age;

	private String name;

	private double salary;

	//bi-directional many-to-one association to Rank
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="rankId")
	@JsonManagedReference
	@JsonIgnore
	private Rank rank;

	//bi-directional many-to-one association to Trainingstatus
	@ManyToOne
	@JoinColumn(name="trainingStatusId")
	//@JsonManagedReference
	@JsonBackReference
	@JsonIgnore
	private Trainingstatus trainingstatus;

	public AppUser() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return this.salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Rank getRank() {
		return this.rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public Trainingstatus getTrainingstatus() {
		return this.trainingstatus;
	}

	public void setTrainingstatus(Trainingstatus trainingstatus) {
		this.trainingstatus = trainingstatus;
	}

}