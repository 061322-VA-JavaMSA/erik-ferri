package com.revature.dtos;

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
	private String reimbDescription;
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
		reimbDescription = re.getReimbDescription();
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
	public String getReimbDescription() {
		return reimbDescription;
	}
	public void setReimbDescription(String reimbDescription) {
		this.reimbDescription = reimbDescription;
	}
	public int getUserId() {
		return userId;
	}
	public void setUser(int userId) {
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
		&& reimbAmount == other.reimbAmount && Objects.equals(reimbDescription, other.reimbDescription) && userId == other.userId;
	}
	@Override
	public String toString() {
		return "ReimbursementDTO [id=" + id + ", reimb_type=" + reimbType + ", reimb_status=" + reimbStatus + ", reimb_amount=" + reimbAmount + ", reimb_description=" + reimbDescription + ", ers_users_fk_author=" + userId + "]";
	}
}