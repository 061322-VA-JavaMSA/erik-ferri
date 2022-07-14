package com.revature.daos;

import java.util.List;

import com.revature.models.Reimbursement;

public interface ReimbursementDAO {
	Reimbursement insertReimbursement(Reimbursement re);
	Reimbursement getReimbursementById(int id);
	int updateReimbursement(int id, String status);
	List<Reimbursement> getPendingReimbursements();
	List<Reimbursement> getPendingReimbursementsByUserId(int id);
	List<Reimbursement> getReimbursements();
}