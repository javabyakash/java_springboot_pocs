package com.neosoft.service;

public class ProductService {

	private IInvoiceService invService;

	public ProductService(IInvoiceService invService) {
		this.invService = invService;
	}

	public double getFinalAmt(String code, Double disc) {
		return invService.getInvoiceAmtByCode(code) * disc / 100.0;
	}
}
