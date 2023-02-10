package com.neosoft.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.neosoft.service.IInvoiceService;
import com.neosoft.service.ProductService;

public class TestProductService {

	@Mock
	private IInvoiceService invoiceService;

	ProductService productService;
	Double expInv, expFinal, invInput;
	String code;

	@BeforeEach()
	public void setupCode() {
		MockitoAnnotations.initMocks(this);
		code = "ABC";
		invInput = 10.0;
		expInv = 5000.0;
		expFinal = 500.0;
	}

	@Test
	void testGetFinalAmt() {
		when(invoiceService.getInvoiceAmtByCode(code)).thenReturn(expInv);

		assertEquals(expInv, invoiceService.getInvoiceAmtByCode(code));

		// Injecting Mocked object
		productService = new ProductService(invoiceService);

		double actual = productService.getFinalAmt(code, invInput);
		assertEquals(expFinal, actual);
	}
}
