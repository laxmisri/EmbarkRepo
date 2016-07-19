package com.embark.entity;

// Generated 18 Jul, 2016 5:56:24 PM by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * OrganizationMaster generated by hbm2java
 */
@Entity
@Table(name = "organization_master", catalog = "salex")
public class OrganizationMaster implements java.io.Serializable {

	private int orgId;
	private String orgCode;
	private String orgName;
	private String isInternal;
	private Integer createdBy;
	private Date createdDate;
	private Integer lastModifiedBy;
	private Date lastModifiedDate;
	private String attribute1;
	private String attribute2;
	private String attribute3;
	private Set<DealerGroupMaster> dealerGroupMasters = new HashSet<DealerGroupMaster>(
			0);
	private Set<UserProfile> userProfiles = new HashSet<UserProfile>(0);
	private Set<SeriesMaster> seriesMasters = new HashSet<SeriesMaster>(0);
	private Set<PasswordPolicy> passwordPolicies = new HashSet<PasswordPolicy>(
			0);
	private Set<Invoice> invoices = new HashSet<Invoice>(0);
	private Set<CustomerAddress> customerAddresses = new HashSet<CustomerAddress>(
			0);
	private Set<DealerItemMaster> dealerItemMasters = new HashSet<DealerItemMaster>(
			0);
	private Set<GroupMaster> groupMasters = new HashSet<GroupMaster>(0);
	private Set<FunctionAccessControl> functionAccessControls = new HashSet<FunctionAccessControl>(
			0);
	private Set<LocationMaster> locationMasters = new HashSet<LocationMaster>(0);
	private Set<SecurityQuestions> securityQuestionses = new HashSet<SecurityQuestions>(
			0);
	private Set<UserMap> userMaps = new HashSet<UserMap>(0);
	private Set<SupplierMaster> supplierMasters = new HashSet<SupplierMaster>(0);
	private Set<FunctionMaster> functionMasters = new HashSet<FunctionMaster>(0);
	private Set<PasswordSecurity> passwordSecurities = new HashSet<PasswordSecurity>(
			0);
	private Set<ItemMaster> itemMasters = new HashSet<ItemMaster>(0);
	private Set<InvoiceLine> invoiceLines = new HashSet<InvoiceLine>(0);
	private Set<User> users = new HashSet<User>(0);
	private Set<CustomerMaster> customerMasters = new HashSet<CustomerMaster>(0);
	private Set<DivisionMaster> divisionMasters = new HashSet<DivisionMaster>(0);

	public OrganizationMaster() {
	}

	public OrganizationMaster(int orgId, String orgCode) {
		this.orgId = orgId;
		this.orgCode = orgCode;
	}

	public OrganizationMaster(int orgId, String orgCode, String orgName,
			String isInternal, Integer createdBy, Date createdDate,
			Integer lastModifiedBy, Date lastModifiedDate, String attribute1,
			String attribute2, String attribute3,
			Set<DealerGroupMaster> dealerGroupMasters,
			Set<UserProfile> userProfiles, Set<SeriesMaster> seriesMasters,
			Set<PasswordPolicy> passwordPolicies, Set<Invoice> invoices,
			Set<CustomerAddress> customerAddresses,
			Set<DealerItemMaster> dealerItemMasters,
			Set<GroupMaster> groupMasters,
			Set<FunctionAccessControl> functionAccessControls,
			Set<LocationMaster> locationMasters,
			Set<SecurityQuestions> securityQuestionses, Set<UserMap> userMaps,
			Set<SupplierMaster> supplierMasters,
			Set<FunctionMaster> functionMasters,
			Set<PasswordSecurity> passwordSecurities,
			Set<ItemMaster> itemMasters, Set<InvoiceLine> invoiceLines,
			Set<User> users, Set<CustomerMaster> customerMasters,
			Set<DivisionMaster> divisionMasters) {
		this.orgId = orgId;
		this.orgCode = orgCode;
		this.orgName = orgName;
		this.isInternal = isInternal;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.lastModifiedBy = lastModifiedBy;
		this.lastModifiedDate = lastModifiedDate;
		this.attribute1 = attribute1;
		this.attribute2 = attribute2;
		this.attribute3 = attribute3;
		this.dealerGroupMasters = dealerGroupMasters;
		this.userProfiles = userProfiles;
		this.seriesMasters = seriesMasters;
		this.passwordPolicies = passwordPolicies;
		this.invoices = invoices;
		this.customerAddresses = customerAddresses;
		this.dealerItemMasters = dealerItemMasters;
		this.groupMasters = groupMasters;
		this.functionAccessControls = functionAccessControls;
		this.locationMasters = locationMasters;
		this.securityQuestionses = securityQuestionses;
		this.userMaps = userMaps;
		this.supplierMasters = supplierMasters;
		this.functionMasters = functionMasters;
		this.passwordSecurities = passwordSecurities;
		this.itemMasters = itemMasters;
		this.invoiceLines = invoiceLines;
		this.users = users;
		this.customerMasters = customerMasters;
		this.divisionMasters = divisionMasters;
	}

	@Id
	@Column(name = "Org_Id", unique = true, nullable = false)
	public int getOrgId() {
		return this.orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	@Column(name = "Org_Code", nullable = false, length = 20)
	public String getOrgCode() {
		return this.orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	@Column(name = "Org_Name", length = 20)
	public String getOrgName() {
		return this.orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	@Column(name = "Is_Internal", length = 5)
	public String getIsInternal() {
		return this.isInternal;
	}

	public void setIsInternal(String isInternal) {
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "organizationMaster")
	public Set<DealerGroupMaster> getDealerGroupMasters() {
		return this.dealerGroupMasters;
	}

	public void setDealerGroupMasters(Set<DealerGroupMaster> dealerGroupMasters) {
		this.dealerGroupMasters = dealerGroupMasters;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "organizationMaster")
	public Set<UserProfile> getUserProfiles() {
		return this.userProfiles;
	}

	public void setUserProfiles(Set<UserProfile> userProfiles) {
		this.userProfiles = userProfiles;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "organizationMaster")
	public Set<SeriesMaster> getSeriesMasters() {
		return this.seriesMasters;
	}

	public void setSeriesMasters(Set<SeriesMaster> seriesMasters) {
		this.seriesMasters = seriesMasters;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "organizationMaster")
	public Set<PasswordPolicy> getPasswordPolicies() {
		return this.passwordPolicies;
	}

	public void setPasswordPolicies(Set<PasswordPolicy> passwordPolicies) {
		this.passwordPolicies = passwordPolicies;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "organizationMaster")
	public Set<Invoice> getInvoices() {
		return this.invoices;
	}

	public void setInvoices(Set<Invoice> invoices) {
		this.invoices = invoices;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "organizationMaster")
	public Set<CustomerAddress> getCustomerAddresses() {
		return this.customerAddresses;
	}

	public void setCustomerAddresses(Set<CustomerAddress> customerAddresses) {
		this.customerAddresses = customerAddresses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "organizationMaster")
	public Set<DealerItemMaster> getDealerItemMasters() {
		return this.dealerItemMasters;
	}

	public void setDealerItemMasters(Set<DealerItemMaster> dealerItemMasters) {
		this.dealerItemMasters = dealerItemMasters;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "organizationMaster")
	public Set<GroupMaster> getGroupMasters() {
		return this.groupMasters;
	}

	public void setGroupMasters(Set<GroupMaster> groupMasters) {
		this.groupMasters = groupMasters;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "organizationMaster")
	public Set<FunctionAccessControl> getFunctionAccessControls() {
		return this.functionAccessControls;
	}

	public void setFunctionAccessControls(
			Set<FunctionAccessControl> functionAccessControls) {
		this.functionAccessControls = functionAccessControls;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "organizationMaster")
	public Set<LocationMaster> getLocationMasters() {
		return this.locationMasters;
	}

	public void setLocationMasters(Set<LocationMaster> locationMasters) {
		this.locationMasters = locationMasters;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "organizationMaster")
	public Set<SecurityQuestions> getSecurityQuestionses() {
		return this.securityQuestionses;
	}

	public void setSecurityQuestionses(
			Set<SecurityQuestions> securityQuestionses) {
		this.securityQuestionses = securityQuestionses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "organizationMaster")
	public Set<UserMap> getUserMaps() {
		return this.userMaps;
	}

	public void setUserMaps(Set<UserMap> userMaps) {
		this.userMaps = userMaps;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "organizationMaster")
	public Set<SupplierMaster> getSupplierMasters() {
		return this.supplierMasters;
	}

	public void setSupplierMasters(Set<SupplierMaster> supplierMasters) {
		this.supplierMasters = supplierMasters;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "organizationMaster")
	public Set<FunctionMaster> getFunctionMasters() {
		return this.functionMasters;
	}

	public void setFunctionMasters(Set<FunctionMaster> functionMasters) {
		this.functionMasters = functionMasters;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "organizationMaster")
	public Set<PasswordSecurity> getPasswordSecurities() {
		return this.passwordSecurities;
	}

	public void setPasswordSecurities(Set<PasswordSecurity> passwordSecurities) {
		this.passwordSecurities = passwordSecurities;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "organizationMaster")
	public Set<ItemMaster> getItemMasters() {
		return this.itemMasters;
	}

	public void setItemMasters(Set<ItemMaster> itemMasters) {
		this.itemMasters = itemMasters;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "organizationMaster")
	public Set<InvoiceLine> getInvoiceLines() {
		return this.invoiceLines;
	}

	public void setInvoiceLines(Set<InvoiceLine> invoiceLines) {
		this.invoiceLines = invoiceLines;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "organizationMaster")
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "organizationMaster")
	public Set<CustomerMaster> getCustomerMasters() {
		return this.customerMasters;
	}

	public void setCustomerMasters(Set<CustomerMaster> customerMasters) {
		this.customerMasters = customerMasters;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "organizationMaster")
	public Set<DivisionMaster> getDivisionMasters() {
		return this.divisionMasters;
	}

	public void setDivisionMasters(Set<DivisionMaster> divisionMasters) {
		this.divisionMasters = divisionMasters;
	}

}