package com.revature.daos;

import java.util.List;

import com.revature.models.Reimbursement;

public interface ReimbursementDAO {
	Reimbursement insertReimbursement(Reimbursement re);
	Reimbursement getReimbursementById(int id);
	List<Reimbursement> getPendingReimbursements();
	List<Reimbursement> getReimbursements();
}