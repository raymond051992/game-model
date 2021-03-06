package com.creatingskies.game.core;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import com.creatingskies.game.model.IAuditRecord;

@Entity(name="gTileImage")
public class TileImage implements IAuditRecord{

	private static final long serialVersionUID = 75752093358133615L;

	private Integer idNo;
	private byte[] image;
	private String fileName;
	private String fileType;
	private Long fileSize;
	
	private String owner;
	private Integer difficulty = 0;
	private Boolean systemDefined = false;
	
	private Integer verticalTilt = 0;
	private Integer horizontalTilt = 0;
	
	private Boolean archived = false;
	
	private String entryBy;
	private Date entryDate;
	private String editBy;
	private Date editDate;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdNo() {
		return idNo;
	}
	
	public void setIdNo(Integer idNo) {
		this.idNo = idNo;
	}
	
	@Column(nullable=false)
	@Lob
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
	@Column(nullable=false)
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	@Column(nullable=false)
	public String getFileType() {
		return fileType;
	}
	
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
	@Column(nullable=false)
	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Integer getVerticalTilt() {
		return verticalTilt;
	}

	public void setVerticalTilt(Integer verticalTilt) {
		this.verticalTilt = verticalTilt;
	}

	public Integer getHorizontalTilt() {
		return horizontalTilt;
	}

	public void setHorizontalTilt(Integer horizontalTilt) {
		this.horizontalTilt = horizontalTilt;
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

	public Integer getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Integer difficulty) {
		this.difficulty = difficulty;
	}

	public Boolean getSystemDefined() {
		return systemDefined;
	}

	public void setSystemDefined(Boolean systemDefined) {
		this.systemDefined = systemDefined;
	}
	
	public Boolean getArchived() {
		return archived;
	}
	
	public void setArchived(Boolean archived) {
		this.archived = archived;
	}
}
