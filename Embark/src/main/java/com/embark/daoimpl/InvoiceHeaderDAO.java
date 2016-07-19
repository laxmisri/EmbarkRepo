package com.embark.daoimpl;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.embark.daointerface.IInvoiceDAO;
import com.embark.entity.TallyInvoice;

@Repository
public class InvoiceHeaderDAO extends BaseDAO implements IInvoiceDAO {
	private static final Logger LOGGER = Logger.getLogger(InvoiceHeaderDAO.class);

	@Override
	@Transactional
	public boolean saveInvoices(TallyInvoice invoice) throws Exception {
		boolean saveStatus = false;
		try {
			/*LOGGER.info("Data 1: "+invoice.getId());
			LOGGER.info("Data 2: "+invoice.getExternalVoucherkey());
			LOGGER.info("Data 1: "+invoice.getLedgerName());
			LOGGER.info("Data 1: "+invoice.getPartyLedgerName());
			LOGGER.info("Data 1: "+invoice.getPartyName());
			LOGGER.info("Data 1: "+invoice.getStockItemName());
			LOGGER.info("Data 1: "+invoice.getBilledQty());
			LOGGER.info("Data 1: "+invoice.getRate());
			LOGGER.info("Data 1: "+invoice.getVoucherKey());
			LOGGER.info("Data 1: "+invoice.getCreateDate());
			LOGGER.info("Data 1: "+invoice.getInvoiceDate());
			LOGGER.info("Data 1: "+invoice.getLastMdfDate());*/
			
			
			/*for(TallyInvoice invoice : invoiceList){
				LOGGER.info("Size of the array---> "+invoiceList.size());
				saveOrUpdate(invoice);
				if(status!=null){
					LOGGER.info("Record added sucessfully");
					saveStatus = true;
				}else{
					LOGGER.error("Data inserting failed...");
					saveStatus = false;
					break;
				}
			}*/
			LOGGER.info("invvoice ..."+invoice.getId());
			save(invoice);
		} catch (Exception e) {
			LOGGER.error("Error in --> saveInvoices ---> "+e.getMessage());
		}
		return saveStatus;
	}
}
