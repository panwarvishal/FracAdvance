package com.frac.FracAdvanced.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ReservoirLithologyVerticle")

public class ReservoirLithologyModelVerticle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String param;
	private String value;
	
	
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
	fetch=FetchType.LAZY)
@JoinColumn(name="pId", nullable=true)
private ProjectDetails rLVerticle;	
	@Override
	public String toString() {
		return "ReservoirLithologyModelVerticle [id=" + id + ", param=" + param + ", value=" + value + ", rLVerticle="
				+ rLVerticle + "]";
	}
	
	public ProjectDetails getrLVerticle() {
		return rLVerticle;
	}

	public void setrLVerticle(ProjectDetails rLVerticle) {
		this.rLVerticle = rLVerticle;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public ReservoirLithologyModelVerticle(Integer id, String param, String value, ProjectDetails rLVerticle) {
		super();
		this.id = id;
		this.param = param;
		this.value = value;
		this.rLVerticle = rLVerticle;
	}

	public ReservoirLithologyModelVerticle() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
