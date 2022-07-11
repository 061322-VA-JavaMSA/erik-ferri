package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import com.revature.models.Reimbursement;
import com.revature.util.HibernateUtil;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class ReimbursementHibernate implements ReimbursementDAO {

	@Override
	public Reimbursement insertReimbursement(Reimbursement re) {
		re.setId(-1);
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			int id = (int) s.save(re);
			re.setId(id);
			tx.commit();	
		} catch(ConstraintViolationException e) {
			//log it
		}
		return re;
	}

	@Override
	public Reimbursement getReimbursementById(int id) {
		Reimbursement reimbursement = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession();){
			reimbursement = s.get(Reimbursement.class, id);
		}
		
		return reimbursement;
	}

	@Override
	public List<Reimbursement> getPendingReimbursements() {
		List<Reimbursement> reimbursements = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			reimbursements = s.createQuery("select re from Reimbursement re where re.reimbStatus = 'pending'", Reimbursement.class).list();
		}
		
		return reimbursements;
	}

	@Override
	public List<Reimbursement> getReimbursements() {
		List<Reimbursement> reimbursements = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			reimbursements = s.createQuery("from Reimbursement", Reimbursement.class).list();
		}
		
		return reimbursements;
	}

}