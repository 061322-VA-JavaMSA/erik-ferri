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
	public Reimbursement getReimbursementByType(String reimbursementType) {
		Reimbursement reimbursement = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession();){
			// SELECT * FROM ERS_REIMBURSEMENTS WHERE REIMB_TYPE = '';
			
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Reimbursement> cq = cb.createQuery(Reimbursement.class);
			// define entity to be searched
			Root<Reimbursement> root = cq.from(Reimbursement.class);
			
			//define conditions
			Predicate predicateForUsername = cb.equal(root.get("reimb_type"), reimbursementType);
//			Predicate predicateForSomethingElse = cb.equal(root.get("password"), password);
//			Predicate predicateFromUnameAndPass = cb.and(predicateForUsername, predicateForSomethingElse);
			
			cq.select(root).where(predicateForUsername);
			
			// retrieves the result
			reimbursement = (Reimbursement) s.createQuery(cq).getSingleResult();
		}
		
		return reimbursement;
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