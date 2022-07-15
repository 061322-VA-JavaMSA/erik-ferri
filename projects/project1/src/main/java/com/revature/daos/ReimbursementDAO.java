package com.revature.daos;

import java.util.List;

import com.revature.models.Reimbursement;

public interface ReimbursementDAO {
	Reimbursement insertReimbursement(Reimbursement re);
	Reimbursement getReimbursementById(int id);
	int updateReimbursement(int id, String status, int reimbResolverId);
	List<Reimbursement> getPendingReimbursements();
	List<Reimbursement> getPendingReimbursementsByUserId(int id);
	List<Reimbursement> getResolvedReimbursementsByUserId(int id);
	List<Reimbursement> getResolvedReimbursements();
	List<Reimbursement> getReimbursementsByUserId(int id);
}