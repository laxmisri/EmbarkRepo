package com.embark.utilityimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.embark.utilityinterface.ISqliteDataInsertion;
import com.embark.utilityinterface.IXmlParsing;

@Service
public class SqliteDataInsertion implements ISqliteDataInsertion {
	private static final Logger LOGGER = Logger.getLogger(SqliteDataInsertion.class);

    @Autowired
	private IXmlParsing iXmlParsing;
	@Override
	public String dataInsertion() {
		Connection con = null;
		Statement psmt = null;
		JSONArray xmlParsedData = new JSONArray();
		JSONObject currentRecord  = new JSONObject();
		try {
			xmlParsedData = iXmlParsing.xmlConversion();
			
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:Embark.db");
			LOGGER.info("Opened database successfully");
			psmt = con.createStatement();
			for(int count = 0; count < xmlParsedData.length(); count++){
				currentRecord = (JSONObject) xmlParsedData.get(count);
				String query = "INSERT OR IGNORE INTO INVOICE(VOUCHER_KEY, PARTY_LEDGER_NAME, LEDGER_NAME, PARTY_NAME,EXTERNAL_VOUCHERKEY, STOCK_ITEM_NAME, RATE,BILLED_QTY, CREATE_DATE, INVOICE_DATE, LAST_MDF_DATE) VALUES("+currentRecord.getString("voucherKey")+", '"+currentRecord.getString("partyLedgerName")+"', '"+currentRecord.getString("ledgerName")+"', '"+currentRecord.getString("partyName")+"',"+currentRecord.getString("externalVoucherKey")+", '"+currentRecord.getString("stockItemName")+"', "+currentRecord.getString("rate")+", "+currentRecord.getString("billedQty")+", datetime('now', 'localtime'), date('"+currentRecord.getString("invoiceDate")+"'), datetime('now', 'localtime'))";
				LOGGER.info(query);
				psmt.executeUpdate(query);
			}
			con.close();
		} catch (Exception e) {
			LOGGER.error("Error---> dataInsertion---> " + e.getMessage());
			e.printStackTrace();
		}
		LOGGER.info("Data inserted successfully!");
		return xmlParsedData.toString();
		}
}
