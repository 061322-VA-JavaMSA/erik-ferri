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
	
	public ReimbursementDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ReimbursementDTO(Reimbursement re) {
		id = re.getId();
		reimbType = re.getReimbType();
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
		return id == other.id && Objects.equals(reimbType, other.reimbType) && Objects.equals(reimbStatus, other.reimbStatus);
	}
	@Override
	public String toString() {
		return "ReimbursementDTO [id=" + id + ", reimb_type=" + reimbType + ", reimb_status=" + reimbStatus + "]";
	}
}