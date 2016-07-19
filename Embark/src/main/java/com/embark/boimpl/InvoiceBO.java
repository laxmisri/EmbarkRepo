package com.embark.boimpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.embark.bointerface.IInvoiceBO;
import com.embark.daointerface.IInvoiceDAO;
import com.embark.entity.TallyInvoice;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Service
public class InvoiceBO implements IInvoiceBO {
private static final Logger LOGGER = Logger.getLogger(InvoiceBO.class);
	@Autowired
	private IInvoiceDAO iInvoiceDAO;
	public static JSONObject parse(JSONObject json ) throws Exception{
		Iterator<String> keys = json.keys();
	    JSONObject out =new JSONObject();
	    while(keys.hasNext()){
	        String key = keys.next();
	       String oldval=key;
	        
	        
	        	key=key.replace("_", " ");
	        	key=toCamelCase(key);
	        	key=key.replace(" ", "");
	        	
	        	if(key.equalsIgnoreCase("lastMdfDate") || key.equalsIgnoreCase("createDate") || key.equalsIgnoreCase("invoiceDate")  ){
	        		String val=json.getString(oldval);
	        		val=val.substring(0, 10);
	        		out.put(key,val);
	        	}else{
	        		out.put(key,json.get(oldval));
	        	}
	           
	        
	    }
	    return out;
	}
	public static String toCamelCase(String inputString) {
	       String result = "";
	       if (inputString.length() == 0) {
	           return result;
	       }
	       char firstChar = inputString.charAt(0);
	       char firstCharToUpperCase = Character.toLowerCase(firstChar);
	       result = result + firstCharToUpperCase;
	       for (int i = 1; i < inputString.length(); i++) {
	           char currentChar = inputString.charAt(i);
	           char previousChar = inputString.charAt(i - 1);
	           if (previousChar == ' ') {
	               char currentCharToUpperCase = Character.toUpperCase(currentChar);
	               result = result + currentCharToUpperCase;
	           } else {
	               char currentCharToLowerCase = Character.toLowerCase(currentChar);
	               result = result + currentCharToLowerCase;
	           }
	       }
	       return result;
	   }
	
	
	@Override
	public boolean insertDataIntoDatabase(String requestData) throws Exception {
		boolean insertionStatus = false;
		JSONArray sqliteData = new JSONArray(requestData);
		List<String> invoiceList = new ArrayList<String>();
		
		try {
			
			LOGGER.info("sqliteData: "+sqliteData.toString());
			for(int arrayCount = 0; arrayCount < sqliteData.length(); arrayCount++){
				
					JSONObject parsed=parse((JSONObject) sqliteData.get(arrayCount));
					LOGGER.info("sqliteData:11 "+parsed.toString());
					try{
						GsonBuilder invoiceGsonBuilder = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setDateFormat("DateFormat.LONG");
						Gson invoiceGson = invoiceGsonBuilder.create();
						TallyInvoice invoice = invoiceGson.fromJson(parsed.toString(), TallyInvoice.class);
						LOGGER.info("sqliteData:13 "+invoice.getLedgerName());
						invoice.setId(invoice.getId()+arrayCount);
						iInvoiceDAO.saveInvoices(invoice);
					}
					catch(Exception e){
						e.printStackTrace();
					}
				
				
				//
			}
//			LOGGER.info("Length: "+sqliteData.length());
//			int count = 0;
//
//			TallyInvoice invoice = new TallyInvoice();
//			while( count < sqliteData.length()){
//				String currentRecord = sqliteData.get(count).toString();
//				JSONObject jsonObj = new JSONObject(currentRecord);
//				
//				invoiceList.add(count, jsonObj.getString("VOUCHER_KEY"));
//				//LOGGER.info(count+" INFO--> "+invoiceList.toString());
//				//invoice.setVoucherKey(Integer.valueOf(jsonObj.getString("VOUCHER_KEY")));
//				LOGGER.info("*currentRecordsss: "+invoiceList.get(count));
//				
//				
//				/*invoice.setPartyLedgerName(jsonObj.getString("PARTY_LEDGER_NAME"));
//				invoice.setLedgerName(jsonObj.getString("LEDGER_NAME"));
//				invoice.setPartyName(jsonObj.getString("PARTY_NAME"));
//				invoice.setExternalVoucherkey(Integer.valueOf(jsonObj.getString("EXTERNAL_VOUCHERKEY")));
//				invoice.setStockItemName(jsonObj.getString("STOCK_ITEM_NAME"));
//				invoice.setRate(Float.valueOf(jsonObj.getString("RATE")));
//				invoice.setBilledQty(Integer.valueOf(jsonObj.getString("BILLED_QTY")));
//				//For Created Date
//				String create_date = jsonObj.getString("CREATE_DATE");
//				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//				Date cDate = (Date) sdf.parse(create_date);
//				invoice.setCreateDate(cDate);
//				// For Invoice Date
//				String invoice_date = jsonObj.getString("INVOICE_DATE");
//				SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//				Date date = (Date) sd.parse(invoice_date);
//				invoice.setCreateDate(date);
//				//For Last_Mdf_Date
//				String last_mdf__date = jsonObj.getString("LAST_MDF_DATE");
//				SimpleDateFormat lsd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//				Date last = (Date) lsd.parse(last_mdf__date);
//				invoice.setCreateDate(last);*/
//				
//				//TallyInvoice invoice = invoiceGson.fromJson(currentRecord, TallyInvoice.class);
//				//LOGGER.info("1Invoice: ....:  "+invoice.getLedgerName() +" "+invoice.getExternalVoucherkey());
//				//iInvoiceDAO.saveInvoices(invoice);
//				count++;
//			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return insertionStatus;
	}
	

}
