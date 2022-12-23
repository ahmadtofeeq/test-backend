package com.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "plot")
public class Plot {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id = (long) 1;
	private String name = "plot-1";
	private String owner = "Tofeeq";
	private int width;
	private int length;
	private String slot;
	private boolean irrigationStatus = false;

	public Plot(String name, String owner, int width, int length, String slot, boolean irrigationStatus) {
		this.name = name;
		this.owner = owner;
		this.width = width;
		this.length = length;
		this.slot = slot;
		this.irrigationStatus = irrigationStatus;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	public boolean isIrrigationStatus() {
		return irrigationStatus;
	}

	public void setIrrigationStatus(boolean irrigationStatus) {
		this.irrigationStatus = irrigationStatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Plot() {

	}

}
