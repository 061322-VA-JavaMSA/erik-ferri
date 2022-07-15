package com.revature.models;

import java.time.OffsetDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="ers_reimbursements")
public class Reimbursement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="reimb_type")
	private String reimbType;
	@Column(name="reimb_status")
	private String reimbStatus;
	@Column(name="reimb_amount")
	private float reimbAmount;
	@Column(name="reimb_submitted")
	private OffsetDateTime reimbSubmitted;
	@Column(name="reimb_resolved")
	private OffsetDateTime reimbResolved;
	@Column(name="reimb_description")
	private String reimbDescription;
	@Column(name="reimb_resolver")
	private int reimbResolverId;
	@Column(name="ers_users_fk_author")
	private int userId;
//	@ManyToOne
//	@JoinColumn(name = "ers_users_fk_author")
//	private User user;
	
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getReimbType() {
		return reimbType;
	}
	public void setReimbType(String reimbType) {
		this.reimbType = reimbType;
	}
	
	public String getReimbStatus() {
		return reimbStatus;
	}
	public void setReimbStatus(String reimbStatus) {
		this.reimbStatus = reimbStatus;
	}
	
	public float getReimbAmount() {
		return reimbAmount;
	}
	public void setReimbAmount(float reimbAmount) {
		this.reimbAmount = reimbAmount;
	}
	
	public OffsetDateTime getReimbSubmitted() {
		return reimbSubmitted;
	}
	public void setReimbSubmitted(OffsetDateTime reimbSubmitted) {
		this.reimbSubmitted = reimbSubmitted;
	}
	
	public OffsetDateTime getReimbResolved() {
		return reimbResolved;
	}
	public void setReimbResolved(OffsetDateTime reimbResolved) {
		this.reimbResolved = reimbResolved;
	}
	
	public String getReimbDescription() {
		return reimbDescription;
	}
	public void setReimbDescription(String reimbDescription) {
		this.reimbDescription = reimbDescription;
	}
	
	public int getReimbResolverId() {
		return reimbResolverId;
	}
	public void setReimbResolverId(int reimbResolverId) {
		this.reimbResolverId = reimbResolverId;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, reimbType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement other = (Reimbursement) obj;
		return id == other.id && Objects.equals(reimbType, other.reimbType) && Objects.equals(reimbStatus, other.reimbStatus) 
		&& reimbAmount == other.reimbAmount && Objects.equals(reimbDescription, other.reimbDescription) && userId == other.userId
		&& Objects.equals(reimbSubmitted, other.reimbSubmitted) && Objects.equals(reimbResolved, other.reimbResolved) 
		&& reimbResolverId == other.reimbResolverId && userId == other.userId;
	}

	@Override
	public String toString() {
		return "ReimbursementDTO [id=" + id + ", reimb_type=" + reimbType + ", reimb_status=" + reimbStatus + ", reimb_amount=" 
		+ reimbAmount + ", reimb_submitted=" + reimbSubmitted + ", reimb_resolved=" + reimbResolved + ", reimb_description="
		+ reimbDescription + ", reimb_resolver=" + reimbResolverId + ", ers_users_fk_author=" + userId + "]";
	}
}