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
	
	public List<Reimbursement> getReimbursements() {
		List<Reimbursement> reimbursements = rd.getReimbursements();
		return reimbursements;
	}

}