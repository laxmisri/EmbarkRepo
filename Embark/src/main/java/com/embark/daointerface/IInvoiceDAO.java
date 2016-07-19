package com.embark.daointerface;

import com.embark.entity.TallyInvoice;

public interface IInvoiceDAO extends IBaseDAO {
	public boolean saveInvoices(TallyInvoice invoice) throws Exception;
}
