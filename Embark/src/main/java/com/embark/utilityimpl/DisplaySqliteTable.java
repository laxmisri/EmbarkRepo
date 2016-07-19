package com.embark.utilityimpl;
import java.sql.*;

import com.embark.utilityimpl.TallyResponse;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.embark.utilityinterface.IDisplayTable;
import com.embark.utilityinterface.ISqliteDataInsertion;
import com.embark.utilityinterface.ITallyResponse;
import com.embark.utilityinterface.IXmlParsing;
@Service
public class DisplaySqliteTable implements IDisplayTable {
	private static final Logger LOGGER = Logger.getLogger(SqliteDataInsertion.class);
	@Autowired
	private ITallyResponse iTallyResponse;
	@Autowired
	private IXmlParsing iXmlParsing;
	@Autowired
	private ISqliteDataInsertion iSqliteDataInsertion;
	@Override
	
	public JSONArray displayTable() {
		Connection con = null;
		Statement stmt = null;
		JSONArray jsonOutput = new JSONArray();
		try{
			 String tallyResponse = iTallyResponse.tallyToConsole();
			 //JSONArray xmlParsedData = iXmlParsing.xmlConversion();
			 String insertion = iSqliteDataInsertion.dataInsertion();
			 if(!tallyResponse.isEmpty() && insertion!= null){
				 Class.forName("org.sqlite.JDBC");
				 con = DriverManager.getConnection("jdbc:sqlite:Embark.db");
				 stmt = con.createStatement();
				 LOGGER.info("Connected to the database successfully");
			     ResultSet rs=stmt.executeQuery("select * from INVOICE");
				 while (rs.next()) {
					 JSONObject js = new JSONObject();
					 js.put("id",rs.getString("ID"));
					 js.put("voucherKey",rs.getString("VOUCHER_KEY"));
					 js.put("partyLedgerName", rs.getString("PARTY_LEDGER_NAME"));
					 js.put("ledgerName",rs.getString("LEDGER_NAME"));
					 js.put("partyName", rs.getString("PARTY_NAME"));
					 js.put("externalVoucherkey",rs.getString("EXTERNAL_VOUCHERKEY"));
					 js.put("stockItemName", rs.getString("STOCK_ITEM_NAME"));
					 js.put("rate", rs.getString("RATE"));
					 js.put("billedQty", rs.getString("BILLED_QTY"));
					 js.put("createDate", rs.getString("CREATE_DATE"));
					 js.put("invoiceDate", rs.getString("INVOICE_DATE"));
					 js.put("lastMdfDate", rs.getString("LAST_MDF_DATE"));
					 jsonOutput.put(js);
				 }
			 }
			 
		con.close();
		LOGGER.info("Fetched Data From Sqlite"+ jsonOutput.toString());
		} 
		  catch(Exception e){
			LOGGER.error("Error---> dataDisplay---> " + e.getMessage());
			e.printStackTrace();
		}
		LOGGER.info("Data Display successfully!");
	return jsonOutput;
}
}