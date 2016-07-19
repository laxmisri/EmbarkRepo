package com.embark.utilityimpl;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.embark.utilityinterface.IXmlParsing;

@Service
public class XmlParsing implements IXmlParsing {
	private static final Logger LOGGER = Logger.getLogger(XmlParsing.class);
	
	@Override
	public JSONArray xmlConversion() throws Exception{
		 JSONArray attributesArray = new JSONArray();
		 int k=0;
		 //int salesCount = 0;
			try{
				 File inputFile = new File("Embark_1.xml");
		         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		         Document doc = dBuilder.parse(inputFile);
		         doc.getDocumentElement().normalize();
		         NodeList nList = doc.getElementsByTagName("TALLYMESSAGE");
		         
		         System.out.println("----------*****-----------");
		         
		         for (int temp = 0; temp < nList.getLength() - 1; temp++) {
		            Node nNode = nList.item(temp);
		            
		            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		               Element eElement = (Element) nNode;
		               String voucherType = eElement.getElementsByTagName("VOUCHERTYPENAME").item(0).getTextContent();
		               voucherType = voucherType.trim().toString();
		               //System.out.println("Total Sales Count: "+""+ ++salesCount);
		               if(voucherType.equals( "Sales")){
		            	   
		            	   String date = eElement.getElementsByTagName("DATE").item(0).getTextContent();
		            	   String yyyy = date.substring(0,4);
		            	   String mm = date.substring(4,6);
		            	   String dd = date.substring(6,8);
		            	   date  = yyyy + "-" + mm + "-" + dd;
		            	   
		            	   NodeList inventoryList = eElement.getElementsByTagName("ALLINVENTORYENTRIES.LIST");
							for (int i = 0; i < inventoryList.getLength(); i++) {
								//System.out.println("Total Sales Count: "+""+ ++salesCount);
								Node itemNode = inventoryList.item(i);
								Element itemElement = (Element) itemNode;
								try {
								   JSONObject attributesJson = new JSONObject();
					               attributesJson.put("voucherType", voucherType);
								   attributesJson.put("invoiceDate", date);
				            	   String voucherKey =  eElement.getElementsByTagName("VOUCHERKEY").item(0).getTextContent();
				            	   attributesJson.put("voucherKey", voucherKey);
				            	   String partyName =  eElement.getElementsByTagName("PARTYNAME").item(0).getTextContent();
				            	   attributesJson.put("partyName", partyName);
				            	   String ledgerName =  eElement.getElementsByTagName("LEDGERNAME").item(0).getTextContent();
				            	   attributesJson.put("ledgerName", ledgerName);
				            	   String partyLedgerName = eElement.getElementsByTagName("PARTYLEDGERNAME").item(0).getTextContent();
				            	   attributesJson.put("partyLedgerName", partyLedgerName);
				            	   String externalVoucherKey =  eElement.getElementsByTagName("VOUCHERKEY").item(0).getTextContent();
				            	   attributesJson.put("externalVoucherKey", externalVoucherKey+(Integer.toString(k)));
								   String stockItemName = itemElement.getElementsByTagName("STOCKITEMNAME").item(0).getTextContent();
								   attributesJson.put("stockItemName", stockItemName);
								   String rate = itemElement.getElementsByTagName("RATE").item(0).getTextContent();
								   rate = rate.replace("/NO", "");
								   attributesJson.put("rate", rate);
								   String billedQty = itemElement.getElementsByTagName("BILLEDQTY").item(0).getTextContent();
								   billedQty = billedQty.replace("NO", "");
								   attributesJson.put("billedQty", billedQty);
								   //System.out.println("DATA: "+attributesJson);
								   								
								   k++;
								   attributesArray.put(attributesJson);
								
								} catch (Exception e) {
									e.printStackTrace();
								}	
															
								
								
							}
		  	           }
		               
		            }
		            
		            }
		         
		      } catch (Exception e) {
		         e.printStackTrace();
		      }
			 return attributesArray;
		   }

	}
		 
