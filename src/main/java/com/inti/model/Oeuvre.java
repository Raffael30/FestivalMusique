package com.inti.model;

import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "oeuvre")
public class Oeuvre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num;
	
	@Column(name = "name", length = 20)
	private String nom;
	
	@Column(name = "duration")
	private LocalTime duree;
	
	@ManyToMany
	@JoinTable(name = "oeuvre_soliste",
					joinColumns = @JoinColumn(name = "num_oeuvre"),
					inverseJoinColumns = @JoinColumn(name = "num_soliste"))
	List<Soliste> listSolistes;

	public Oeuvre(int num, String nom, LocalTime duree) {
		super();
		this.num = num;
		this.nom = nom;
		this.duree = duree;
	}

	public Oeuvre(String nom, LocalTime duree) {
		super();
		this.nom = nom;
		this.duree = duree;
	}

	public Oeuvre() {
		super();
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public LocalTime getDuree() {
		return duree;
	}

	public void setDuree(LocalTime duree) {
		this.duree = duree;
	}
	
	
	
}
