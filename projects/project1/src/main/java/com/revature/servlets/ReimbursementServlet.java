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
import com.revature.dtos.UserDTO;
import com.revature.exceptions.ReimbursementNotCreatedException;
import com.revature.exceptions.ReimbursementNotFoundException;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.services.ReimbursementService;
import com.revature.util.CorsFix;

public class ReimbursementServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ReimbursementService rs = new ReimbursementService();
	// object to convert to JSON format
	private ObjectMapper om = new ObjectMapper();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		// Specifying that the response content-type will be JSON
		CorsFix.addCorsHeader(req.getRequestURI(), res);
		res.addHeader("Content-Type", "application/json");
		
		String pathInfo = req.getPathInfo();
		
		if (pathInfo.equals("/pending")) {
			List<Reimbursement> reimbursements = rs.getPendingReimbursements();
			List<ReimbursementDTO> reimbursementsDTO = new ArrayList<>();

			// converting Reimbursements to ReimbursementsDTO for data transfer
			reimbursements.forEach(re -> reimbursementsDTO.add(new ReimbursementDTO(re)));

			// retrieving print writer to write to the Response body
			PrintWriter pw = res.getWriter();
			// writing toString representation of Reimbursements to body
			pw.write(om.writeValueAsString(reimbursementsDTO));

			pw.close();
//		Remove last character of pathInfo
		} else if (pathInfo.substring(0, pathInfo.length() - 1).equals("/pending/")){
			int id = Integer.parseInt(pathInfo.substring(9));

			List<Reimbursement> reimbursements = rs.getPendingReimbursementsByUserId(id);
			List<ReimbursementDTO> reimbursementsDTO = new ArrayList<>();
			
			// converting Reimbursements to ReimbursementDTOs for data transfer
			reimbursements.forEach(re -> reimbursementsDTO.add(new ReimbursementDTO(re)));

			// retrieving print writer to write to the Response body
			PrintWriter pw = res.getWriter();
			// writing toString representation of Reimbursements to body
			pw.write(om.writeValueAsString(reimbursementsDTO));

			pw.close();
		} else if(pathInfo.equals("/resolved")) {
			// retrieving resolved reimbursements from db using ReimbursementService
			List<Reimbursement> reimbursements = rs.getResolvedReimbursements();
			List<ReimbursementDTO> reimbursementsDTO = new ArrayList<>();

			// converting Users to UserDTOs for data transfer
			reimbursements.forEach(re -> reimbursementsDTO.add(new ReimbursementDTO(re)));

			// retrieving print writer to write to the Response body
			PrintWriter pw = res.getWriter();
			// writing toString representation of Users to body
			pw.write(om.writeValueAsString(reimbursementsDTO));

			pw.close();
		} else if(pathInfo.substring(0, pathInfo.length() - 1).equals("/resolved/")) {
			int id = Integer.parseInt(pathInfo.substring(10));

			List<Reimbursement> reimbursements = rs.getResolvedReimbursementsByUserId(id);
			List<ReimbursementDTO> reimbursementsDTO = new ArrayList<>();
			
			// converting Reimbursements to ReimbursementDTOs for data transfer
			reimbursements.forEach(re -> reimbursementsDTO.add(new ReimbursementDTO(re)));

			// retrieving print writer to write to the Response body
			PrintWriter pw = res.getWriter();
			// writing toString representation of Reimbursements to body
			pw.write(om.writeValueAsString(reimbursementsDTO));

			pw.close();
		} else {
			int id = Integer.parseInt(pathInfo.substring(1));
			
			List<Reimbursement> reimbursements = rs.getReimbursementsByUserId(id);
			List<ReimbursementDTO> reimbursementsDTO = new ArrayList<>();
			
			// converting Reimbursements to ReimbursementDTOs for data transfer
			reimbursements.forEach(re -> reimbursementsDTO.add(new ReimbursementDTO(re)));

			// retrieving print writer to write to the Response body
			PrintWriter pw = res.getWriter();
			// writing toString representation of Reimbursements to body
			pw.write(om.writeValueAsString(reimbursementsDTO));

			pw.close();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
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
	
	  @Override
	  protected void doPut(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
			// Specifying that the response content-type will be JSON
			CorsFix.addCorsHeader(req.getRequestURI(), res);
			res.addHeader("Content-Type", "application/json");
			
			int id = Integer.parseInt(req.getParameter("id"));
			String reimbStatus = req.getParameter("reimbStatus");
			String reimbResolver = req.getParameter("reimbResolver");

			try {
				rs.updateReimbursement(id, reimbStatus, reimbResolver);
			} catch (ReimbursementNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  }
}
