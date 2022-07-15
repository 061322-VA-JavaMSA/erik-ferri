package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import com.revature.models.Reimbursement;
import com.revature.util.HibernateUtil;

import jakarta.persistence.Query;
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
	public int updateReimbursement(int id, String reimbStatus, int reimbResolverId) {
		Transaction transaction = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession();){
            // start a transaction
            transaction = s.beginTransaction();

            // save the Reimbursement object
            String hql = "update Reimbursement set reimbStatus = :reimbStatus, reimbResolverId = :reimbResolverId where id = :reimbId";
            Query query = s.createQuery(hql);
            query.setParameter("reimbStatus", reimbStatus);
            query.setParameter("reimbResolverId", reimbResolverId);
            query.setParameter("reimbId", id);
            int result = query.executeUpdate();
            System.out.println("Rows affected: " + result);

            // commit transaction
            transaction.commit();
            return result;
		}
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
	public List<Reimbursement> getPendingReimbursementsByUserId(int id) {
		List<Reimbursement> reimbursements = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			reimbursements = s.createQuery("from Reimbursement re where re.reimbStatus = 'pending' and re.userId = :id")
			.setParameter("id", id)
			.list();
			
		}
		
		return reimbursements;
	}
	
	@Override
	public List<Reimbursement> getResolvedReimbursementsByUserId(int id) {
		List<Reimbursement> reimbursements = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			reimbursements = s.createQuery("from Reimbursement re where re.reimbStatus != 'pending' and re.userId = :id")
			.setParameter("id", id)
			.list();
			
		}
		
		return reimbursements;
	}

	@Override
	public List<Reimbursement> getResolvedReimbursements() {
		List<Reimbursement> reimbursements = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			reimbursements = s.createQuery("from Reimbursement where reimbStatus !='pending'", Reimbursement.class).list();
		}
		
		return reimbursements;
	}
}