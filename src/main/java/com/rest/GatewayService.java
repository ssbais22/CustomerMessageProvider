package com.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/getway")
public class GatewayService {
	@POST
	@Produces("application/xml")
	@Consumes(value = { "application/vnd-account", "application/vnd-student" })
	public String createCommon(Common common) {

		if (common.getStudent() == null) {
			return common.getAccount().toString();
		} else {
			return common.getStudent().toString();
		}

	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response getObject() {

		if (1==1) {
			Student student = new Student();
			student.setStudentId(2323);
			student.setName("dfdsfsd");
			 return Response.ok()
		                .entity(student).build();
		} else {
			Account account = new Account();
			account.setAccountId(2323);
			account.setBalance(2323);
			 return Response.ok()
		                .entity(account).build();
		}

	}

}