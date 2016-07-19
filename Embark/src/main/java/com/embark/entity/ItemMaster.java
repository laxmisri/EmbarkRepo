package com.embark.entity;

// Generated 18 Jul, 2016 5:56:24 PM by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ItemMaster generated by hbm2java
 */
@Entity
@Table(name = "item_master", catalog = "salex")
public class ItemMaster implements java.io.Serializable {

	private int itemId;
	private OrganizationMaster organizationMaster;
	private DivisionMaster divisionMaster;
	private GroupMaster groupMaster;
	private String extItemId;
	private String extItemDescription;
	private String model;
	private String uom;
	private Integer ownerId;
	private Boolean isInternal;
	private Integer createdBy;
	private Date createdDate;
	private Integer lastModifiedBy;
	private Date lastModifiedDate;
	private String attribute1;
	private String attribute2;
	private String attribute3;
	private Set<DealerItemMaster> dealerItemMasters = new HashSet<DealerItemMaster>(
			0);

	public ItemMaster() {
	}

	public ItemMaster(int itemId, OrganizationMaster organizationMaster,
			DivisionMaster divisionMaster, GroupMaster groupMaster,
			String extItemId) {
		this.itemId = itemId;
		this.organizationMaster = organizationMaster;
		this.divisionMaster = divisionMaster;
		this.groupMaster = groupMaster;
		this.extItemId = extItemId;
	}

	public ItemMaster(int itemId, OrganizationMaster organizationMaster,
			DivisionMaster divisionMaster, GroupMaster groupMaster,
			String extItemId, String extItemDescription, String model,
			String uom, Integer ownerId, Boolean isInternal, Integer createdBy,
			Date createdDate, Integer lastModifiedBy, Date lastModifiedDate,
			String attribute1, String attribute2, String attribute3,
			Set<DealerItemMaster> dealerItemMasters) {
		this.itemId = itemId;
		this.organizationMaster = organizationMaster;
		this.divisionMaster = divisionMaster;
		this.groupMaster = groupMaster;
		this.extItemId = extItemId;
		this.extItemDescription = extItemDescription;
		this.model = model;
		this.uom = uom;
		this.ownerId = ownerId;
		this.isInternal = isInternal;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.lastModifiedBy = lastModifiedBy;
		this.lastModifiedDate = lastModifiedDate;
		this.attribute1 = attribute1;
		this.attribute2 = attribute2;
		this.attribute3 = attribute3;
		this.dealerItemMasters = dealerItemMasters;
	}

	@Id
	@Column(name = "Item_Id", unique = true, nullable = false)
	public int getItemId() {
		return this.itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Org_Id", nullable = false)
	public OrganizationMaster getOrganizationMaster() {
		return this.organizationMaster;
	}

	public void setOrganizationMaster(OrganizationMaster organizationMaster) {
		this.organizationMaster = organizationMaster;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Div_Id", nullable = false)
	public DivisionMaster getDivisionMaster() {
		return this.divisionMaster;
	}

	public void setDivisionMaster(DivisionMaster divisionMaster) {
		this.divisionMaster = divisionMaster;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Group_Id", nullable = false)
	public GroupMaster getGroupMaster() {
		return this.groupMaster;
	}

	public void setGroupMaster(GroupMaster groupMaster) {
		this.groupMaster = groupMaster;
	}

	@Column(name = "Ext_Item_Id", nullable = false, length = 20)
	public String getExtItemId() {
		return this.extItemId;
	}

	public void setExtItemId(String extItemId) {
		this.extItemId = extItemId;
	}

	@Column(name = "Ext_Item_Description", length = 20)
	public String getExtItemDescription() {
		return this.extItemDescription;
	}

	public void setExtItemDescription(String extItemDescription) {
		this.extItemDescription = extItemDescription;
	}

	@Column(name = "Model", length = 20)
	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Column(name = "UOM", length = 20)
	public String getUom() {
		return this.uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	@Column(name = "Owner_Id")
	public Integer getOwnerId() {
		return this.ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	@Column(name = "Is_Internal")
	public Boolean getIsInternal() {
		return this.isInternal;
	}

	public void setIsInternal(Boolean isInternal) {
		this.isInternal = isInternal;
	}

	@Column(name = "Created_By")
	public Integer getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Created_Date", length = 19)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "Last_Modified_By")
	public Integer getLastModifiedBy() {
		return this.lastModifiedBy;
	}

	public void setLastModifiedBy(Integer lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Last_Modified_Date", length = 19)
	public Date getLastModifiedDate() {
		return this.lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	@Column(name = "Attribute_1", length = 20)
	public String getAttribute1() {
		return this.attribute1;
	}

	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}

	@Column(name = "Attribute_2", length = 20)
	public String getAttribute2() {
		return this.attribute2;
	}

	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
	}

	@Column(name = "Attribute_3", length = 20)
	public String getAttribute3() {
		return this.attribute3;
	}

	public void setAttribute3(String attribute3) {
		this.attribute3 = attribute3;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "itemMaster")
	public Set<DealerItemMaster> getDealerItemMasters() {
		return this.dealerItemMasters;
	}

	public void setDealerItemMasters(Set<DealerItemMaster> dealerItemMasters) {
		this.dealerItemMasters = dealerItemMasters;
	}

}
