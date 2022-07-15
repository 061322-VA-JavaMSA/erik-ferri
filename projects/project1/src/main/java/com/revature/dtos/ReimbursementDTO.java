package com.revature.dtos;

import java.time.OffsetDateTime;
import java.util.Objects;

import com.revature.models.Reimbursement;

/*-
 * Data Transfer Objects
 */
public class ReimbursementDTO {

	private int id;
	private String reimbType;
	private String reimbStatus;
	private float reimbAmount;
	private OffsetDateTime reimbSubmitted;
	private OffsetDateTime reimbResolved;
	private String reimbDescription;
	private String reimbResolver;
	private String reimbAuthor;
	private int userId;
	
	public ReimbursementDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ReimbursementDTO(Reimbursement re) {
		id = re.getId();
		reimbType = re.getReimbType();
		reimbStatus = re.getReimbStatus();
		reimbAmount = re.getReimbAmount();
		reimbSubmitted = re.getReimbSubmitted();
		reimbResolved = re.getReimbResolved();
		reimbDescription = re.getReimbDescription();
		reimbResolver = re.getReimbResolver();
		reimbAuthor = re.getReimbAuthor();
		userId = re.getUserId();
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
	
	public String getReimbResolver() {
		return reimbResolver;
	}
	public void setReimbResolver(String reimbResolver) {
		this.reimbResolver = reimbResolver;
	}
	
	public String getReimbAuthor() {
		return reimbAuthor;
	}
	public void setReimbAuthor(String reimbAuthor) {
		this.reimbAuthor = reimbAuthor;
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
		ReimbursementDTO other = (ReimbursementDTO) obj;
		return id == other.id && Objects.equals(reimbType, other.reimbType) && Objects.equals(reimbStatus, other.reimbStatus) 
		&& reimbAmount == other.reimbAmount && Objects.equals(reimbSubmitted, other.reimbSubmitted) 
		&& Objects.equals(reimbResolved, other.reimbResolved) && Objects.equals(reimbDescription, other.reimbDescription) 
		&& Objects.equals(reimbResolver, other.reimbResolver) && Objects.equals(reimbAuthor, other.reimbAuthor) && userId == other.userId;
	}
	
	@Override
	public String toString() {
		return "ReimbursementDTO [id=" + id + ", reimb_type=" + reimbType + ", reimb_status=" + reimbStatus + ", reimb_amount=" 
		+ reimbAmount + ", reimb_submitted=" + reimbSubmitted + ", reimb_resolved=" + reimbResolved + ", reimb_description="
		+ reimbDescription + ", reimb_resolver=" + reimbResolver + ", reimb_author=" + reimbAuthor + ", ers_users_fk_author=" + userId + "]";
	}
}