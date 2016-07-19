package com.embark.utilityimpl;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.embark.utilityinterface.ITallyRequest;

@Service
public class TallyRequest implements ITallyRequest {
	private static final Logger LOGGER = Logger.getLogger(TallyRequest.class);

	private String createRequest() {
		String TXML = null;

		TXML = "<ENVELOPE>"
				+ "<HEADER><TALLYREQUEST>Import Data</TALLYREQUEST></HEADER>"
				+ "<BODY>"
				+ "<IMPORTDATA>"
				+ "<REQUESTDESC><REPORTNAME>Vouchers</REPORTNAME><STATICVARIABLES><SVCURRENTCOMPANY>Lexicon Networks</SVCURRENTCOMPANY></STATICVARIABLES></REQUESTDESC>"
				+ "<REQUESTDATA>"
				+ "<TALLYMESSAGE xmlns:UDF=\"TallyUDF\">"
				+ "<VOUCHER REMOTEID=\"00000001\" VCHTYPE=\"Receipt\" ACTION=\"Create\" OBJVIEW=\"Accounting Voucher View\">"
				+ "<DATE>20160501</DATE>"
				+ "<VOUCHERTYPENAME>sales</VOUCHERTYPENAME>"
				+ "<VOUCHERNUMBER>3</VOUCHERNUMBER>"
				+ "<PARTYLEDGERNAME>cash</PARTYLEDGERNAME>"
				+ "<PERSISTEDVIEW>Accounting Voucher View</PERSISTEDVIEW>"
				+ "<ALLLEDGERENTRIES.LIST>" + "<LEDGERNAME>cash</LEDGERNAME>"
				+ "<ISDEEMEDPOSITIVE>No</ISDEEMEDPOSITIVE>"
				+ "<AMOUNT>5000.00</AMOUNT>" + "</ALLLEDGERENTRIES.LIST>"
				+ "<ALLLEDGERENTRIES.LIST>" + "<LEDGERNAME>Cash</LEDGERNAME>"
				+ "<ISDEEMEDPOSITIVE>Yes</ISDEEMEDPOSITIVE>"
				+ "<AMOUNT>-5000.00</AMOUNT>" + "</ALLLEDGERENTRIES.LIST>"
				+ "</VOUCHER>" + "</TALLYMESSAGE>" + "</REQUESTDATA>"
				+ "</IMPORTDATA>" + "</BODY>" + "</ENVELOPE>";
		return TXML;
	}

	@Override
	public String sendToTally() throws Exception {
		String Url = "http://172.25.16.38:9000/";

		String SOAPAction = "";

		String Voucher = this.createRequest();

		// Create the connection where we're going to send the file.
		URL url = new URL(Url);
		URLConnection connection = url.openConnection();
		HttpURLConnection httpConn = (HttpURLConnection) connection;
		ByteArrayInputStream bin = new ByteArrayInputStream(Voucher.getBytes());
		ByteArrayOutputStream bout = new ByteArrayOutputStream();

		// Copy the SOAP file to the open connection.

		copy(bin, bout);

		byte[] b = bout.toByteArray();

		// Set the appropriate HTTP parameters.
		httpConn.setRequestProperty("Content-Length", String.valueOf(b.length));
		httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
		httpConn.setRequestProperty("SOAPAction", SOAPAction);
		httpConn.setRequestMethod("POST");
		httpConn.setDoOutput(true);
		httpConn.setDoInput(true);

		// Everything's set up; send the XML that was read in to b.
		OutputStream out = httpConn.getOutputStream();
		out.write(b);
		out.close();

		// Read the response and write it to standard out.

		InputStreamReader isr = new InputStreamReader(httpConn.getInputStream());
		BufferedReader in = new BufferedReader(isr);
		String output = "";
		String inputLine;

		while ((inputLine = in.readLine()) != null) {
			output = output + inputLine;
		}

		in.close();
		return output;
	}

	public static void copy(InputStream in, OutputStream out)
			throws IOException {

		// do not allow other threads to read from the
		// input or write to the output while copying is
		// taking place

		synchronized (in) {
			synchronized (out) {

				byte[] buffer = new byte[256];
				while (true) {
					int bytesRead = in.read(buffer);
					if (bytesRead == -1) {
						break;
					}
					out.write(buffer, 0, bytesRead);
				}
			}
		}
	}
}
