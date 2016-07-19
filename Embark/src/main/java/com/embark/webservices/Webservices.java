package com.embark.webservices;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.embark.boimpl.InvoiceBO;
import com.embark.bointerface.IInvoiceBO;
import com.embark.utilityinterface.IDisplayTable;
import com.embark.utilityinterface.ISqliteDataInsertion;
import com.embark.utilityinterface.ITallyRequest;
import com.embark.utilityinterface.ITallyResponse;
import com.embark.utilityinterface.IXmlParsing;

@Component
@Path("/webservice")
public class Webservices {
private static final Logger LOGGER = Logger.getLogger(Webservices.class);
@Autowired
private ITallyRequest iTallyRequest;
@Autowired
private ITallyResponse iTallyResponse;
@Autowired
private ISqliteDataInsertion iSqliteDataInsertion;
@Autowired
private IInvoiceBO iInvoiceBO;
@Autowired
private IDisplayTable iDisplayTable;
@Autowired
private IXmlParsing iXmlParsing;

@GET
@Produces(MediaType.APPLICATION_ATOM_XML)
	@Path("/giveTallyRequest")
	public String giveTallyRequest() {
		String xmlResponse = "";
		try {
			xmlResponse = iTallyRequest.sendToTally();
		} catch (Exception e) {
			LOGGER.error("Error---> giveTallyRequest---> "+e.getMessage());
		}
		return xmlResponse;
		}

		@GET
		@Produces(MediaType.APPLICATION_ATOM_XML)
		@Path("/getTallyResponse")
		public String getTallyResponse() {
			String tallyResponse = "";
			try {
				tallyResponse = iTallyResponse.tallyToConsole();
			} catch (Exception e) {
				LOGGER.error("Error---> getTallyResponse---> "+e.getMessage());
			}
			return tallyResponse;
		}
		
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		@Path("/xmlParsing")
		public String xmlParsing() {
			JSONArray xmlParsedData = new JSONArray();
			try {
				xmlParsedData = iXmlParsing.xmlConversion();
			} catch (Exception e) {
				LOGGER.error("Error---> xmlParsing---> "+e.getMessage());
			}
			return xmlParsedData.toString();
		}
		
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		@Path("/sqliteDataInsertion")
		public String sqliteDataInsertion() {
			String insersationStatus = "";
			String dataInsertionStatus = "{\"isSuccess\":\"false\"}";
			try {
				insersationStatus = iSqliteDataInsertion.dataInsertion();
			} catch (Exception e) {
				LOGGER.error("Error---> sqliteDataInsertion---> "+e.getMessage());
			}
/*
			if(insersationStatus){
				dataInsertionStatus = "{\"isSuccess\":\"true\"}";
			}*/
			
			return insersationStatus;
		}
    @POST
    @Produces(MediaType.APPLICATION_JSON)
	@Path("/insertDataInHibernate")
	public String insertDataInHibernate( String requestData) {
    	System.out.println("Request Params: -> "+requestData);
		boolean insertionStatus = false;
		String returnString = "";
		try {
			JSONArray jsonArr = new JSONArray(requestData);
			//LOGGER.info("Request Parameter " + requestData);
			insertionStatus = iInvoiceBO.insertDataIntoDatabase(requestData); 
		} catch (Exception e) {
			LOGGER.error("Error---> Hibernate Insertion---> "+e.getMessage());
			e.printStackTrace();
		}
		
		if(insertionStatus){
			returnString = "{\"isSuccess\":\"true\"}";
		}else{
			returnString = "{\"isSuccess\":\"false\"}";
		}
		return returnString;
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/displayData")
	public Response displaySqliteData() {
		//boolean insertionStatus = false;
		String displayStatus = "";
		try {
			displayStatus = iDisplayTable.displayTable().toString(); 
		} catch (Exception e) {
			LOGGER.error("Error---> Getting Data From Sqlite---> "+e.getMessage());
			e.printStackTrace();
		}
		
		/*if(displayStatus != null){
			displayStatus = "{\"isSuccess\":\"true\"}";
		}else{
			displayStatus = "{\"isSuccess\":\"false\"}";
		}*/
		return Response.status(200).entity(displayStatus).build();
	}
	
}
