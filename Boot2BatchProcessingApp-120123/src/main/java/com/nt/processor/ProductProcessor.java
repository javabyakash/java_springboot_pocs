package com.nt.processor;

import org.springframework.batch.item.ItemProcessor;

import com.nt.model.Product;

public class ProductProcessor implements ItemProcessor<Product, Product> {
	
	@Override
	public Product process(Product item) throws Exception {
		//Java#10 - Local variable Type Inference
		//Best Datatype detected at compiletime 
		var cost = item.getProdCost();
		
		var disc = cost * (25/100.0);
		var gst = cost * (12/100.0);
		
		item.setProdDisc(disc);
		item.setProdGst(gst);
		
		return item;
	}
}
