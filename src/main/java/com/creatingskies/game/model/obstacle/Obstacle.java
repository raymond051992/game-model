package com.creatingskies.game.model.obstacle;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import com.creatingskies.game.model.IAuditRecord;

@Entity(name = "gObstacle")
public class Obstacle implements IAuditRecord {

	private static final long serialVersionUID = 350816085414876366L;
	
	private Integer idNo;
	private String name;
	
	private Boolean forRowing = false;
	private Boolean forCycling = false;
	private Integer difficulty = 0;
	private Integer radius = 0;
	
	private byte[] image;
	private String imageFileName;
	private String imageFileType;
	
	private String entryBy;
	private Date entryDate;
	private String editBy;
	private Date editDate;

	@Id
	@Override
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdNo() {
		return idNo;
	}
	
	public void setIdNo(Integer idNo) {
		this.idNo = idNo;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(nullable = false)
	public Integer getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Integer difficulty) {
		this.difficulty = difficulty;
	}

	@Lob
	@Column(nullable = false)
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	@Column(nullable = false)
	public String getEntryBy() {
		return entryBy;
	}

	@Override
	public void setEntryBy(String entryBy) {
		this.entryBy = entryBy;
	}

	@Override
	@Column(nullable = false)
	public Date getEntryDate() {
		return entryDate;
	}

	@Override
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	@Override
	public String getEditBy() {
		return editBy;
	}

	@Override
	public void setEditBy(String editBy) {
		this.editBy = editBy;
	}

	@Override
	public Date getEditDate() {
		return editDate;
	}

	@Override
	public void setEditDate(Date editDate) {
		this.editDate = editDate;
	}

	@Column(nullable = false)
	public Boolean getForRowing() {
		return forRowing;
	}

	public void setForRowing(Boolean forRowing) {
		this.forRowing = forRowing;
	}

	@Column(nullable = false)
	public Boolean getForCycling() {
		return forCycling;
	}

	public void setForCycling(Boolean forCycling) {
		this.forCycling = forCycling;
	}

	@Column(nullable = false)
	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	@Column(nullable = false)
	public String getImageFileType() {
		return imageFileType;
	}

	public void setImageFileType(String imageFileType) {
		this.imageFileType = imageFileType;
	}

	public Integer getRadius() {
		return radius;
	}

	public void setRadius(Integer radius) {
		this.radius = radius;
	}
	
}

