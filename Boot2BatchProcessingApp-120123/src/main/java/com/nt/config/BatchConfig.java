package com.nt.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.nt.listner.ProductJobListner;
import com.nt.model.Product;
import com.nt.processor.ProductProcessor;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	
	//1. ItemReader
	@Bean
	public ItemReader<Product> getItemReader(){
		//a. create reader object
		FlatFileItemReader<Product> reader = new FlatFileItemReader<>();
		
		//b. set CSV file location
		reader.setResource(new ClassPathResource("products.csv"));
		
		//c. read data line by line
		reader.setLineMapper(new DefaultLineMapper<>() {{
			//tokenize data and provide name for one line
			setLineTokenizer(new DelimitedLineTokenizer() {{
				setDelimiter(",");
				setNames("prodId","prodCode","prodCost");
			}});
			
			//convert to object and provide data to variables
			setFieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
				setTargetType(Product.class);
			}});
		}});
		return reader;
	} 
	
	//2. ItemProccessor
	@Bean
	public ItemProcessor<Product, Product> getProductProccessor() {
		return new ProductProcessor();
	}
	
	//3. ItemWriter
	@Bean
	public ItemWriter<Product> getItemWriter(){
		JdbcBatchItemWriter<Product> writer = new JdbcBatchItemWriter<>();
		writer.setDataSource(ds);
		writer.setSql("INSERT INTO PRODUCTS(PID,PCODE,PCOST,PDISC,PGST) VALUES(:prodId,:prodCode,:prodCost,:prodDisc,:prodGst)");
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
		return writer;
	}
	
	//4. DataSource
	@Autowired
	private DataSource ds;
	
	//NOTE: IF WE ARE CREATING DATASOURCE OBJECT BY USING @Bean Then in this case we are getting 
	// Cyclick Injection Problem
	
	/*
	 * @Bean public DataSource getDs() { DriverManagerDataSource dmds = new
	 * DriverManagerDataSource();
	 * dmds.setDriverClassName("com.mysql.cj.jdbc.driver");
	 * dmds.setUrl("jdbc:mysql://localhost:3306/bootbatch");
	 * dmds.setUsername("root"); dmds.setPassword("root"); return dmds; }
	 */
	
	//5. StepBuilderFactory Autowired
	@Autowired
	private StepBuilderFactory sf;
	
	//6. Step Object Configuration
	@Bean
	public Step stepA() {
		return sf.get("stepA")
				.<Product,Product>chunk(3)
				.reader(getItemReader())
				.processor(getProductProccessor())
				.writer(getItemWriter())
				.build();
	}
	
	//7. JobExecutionListener Object
	@Bean
	public JobExecutionListener listener() {
		return new ProductJobListner();
	}
	
	//8. JobBuilderFactory Autowired
	@Autowired
	private JobBuilderFactory jf;
	
	//9. Job Object Configuration
	@Bean
	public Job job() {
		return jf.get("jobA")
				.listener(listener())
				.incrementer(new RunIdIncrementer())
				.start(stepA())
				.build();
	}
}
