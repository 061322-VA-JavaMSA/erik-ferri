package com.revature.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dtos.ReimbursementDTO;
import com.revature.exceptions.ReimbursementNotCreatedException;
//import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Reimbursement;
import com.revature.services.ReimbursementService;
import com.revature.util.CorsFix;

public class ReimbursementServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ReimbursementService rs = new ReimbursementService();
	// object to convert to JSON format
	private ObjectMapper om = new ObjectMapper();

//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//
//	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		InputStream reqBody = req.getInputStream();

		Reimbursement newReimbursement = om.readValue(reqBody, Reimbursement.class);

		try {
			rs.createReimbursement(newReimbursement);

			res.setStatus(201); // Status: Created
		} catch (Exception e) {
//			res.setStatus(400);
			res.sendError(400, "Unable to create new reimbursement.");
			e.printStackTrace();
		}
	}

}
