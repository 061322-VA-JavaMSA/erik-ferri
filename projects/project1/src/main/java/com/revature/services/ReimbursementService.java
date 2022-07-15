package com.revature.services;

import java.util.List;

import com.revature.daos.ReimbursementDAO;
import com.revature.daos.ReimbursementHibernate;
import com.revature.exceptions.ReimbursementNotCreatedException;
import com.revature.exceptions.ReimbursementNotFoundException;
import com.revature.models.Reimbursement;

public class ReimbursementService {

	private ReimbursementDAO rd = new ReimbursementHibernate();
	
	public Reimbursement createReimbursement(Reimbursement re) throws ReimbursementNotCreatedException {
		
		Reimbursement createdReimbursement = rd.insertReimbursement(re);
		if(createdReimbursement.getId() == -1) {
			throw new ReimbursementNotCreatedException();
		}
		return createdReimbursement;
	}
	
	public Reimbursement getReimbursementById(int id) throws ReimbursementNotFoundException {
		Reimbursement re = rd.getReimbursementById(id);
		if (re == null) {
			throw new ReimbursementNotFoundException();
		}
		return re;
	}

	public int updateReimbursement(int id, String status, String reimbResolver) throws ReimbursementNotFoundException {
		int result = rd.updateReimbursement(id, status, reimbResolver);
		if (result == 0) {
			throw new ReimbursementNotFoundException();
		}
		return result;
	}

	public List<Reimbursement> getPendingReimbursements() {
		List<Reimbursement> reimbursements = rd.getPendingReimbursements();
		return reimbursements;
	}

	public List<Reimbursement> getPendingReimbursementsByUserId(int id) {
		List<Reimbursement> reimbursements = rd.getPendingReimbursementsByUserId(id);
		return reimbursements;
	}

	public List<Reimbursement> getResolvedReimbursementsByUserId(int id) {
		List<Reimbursement> reimbursements = rd.getResolvedReimbursementsByUserId(id);
		return reimbursements;
	}	
	
	public List<Reimbursement> getResolvedReimbursements() {
		List<Reimbursement> reimbursements = rd.getResolvedReimbursements();
		return reimbursements;
	}
	
	public List<Reimbursement> getReimbursementsByUserId(int id) {
		List<Reimbursement> reimbursements = rd.getReimbursementsByUserId(id);
		return reimbursements;
	}

}