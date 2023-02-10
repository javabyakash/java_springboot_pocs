package com.nt.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
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

import com.nt.listener.StudentJobListener;
import com.nt.model.Student;
import com.nt.processor.StudentProcessor;

@EnableBatchProcessing
@Configuration
public class BatchConfig {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	//1. ItemReader Object
	@Bean
	public ItemReader<Student> getItemReader(){
		log.info("INSIDE GET ITEM READER");
		//a. create reader object
		FlatFileItemReader<Student> reader = new FlatFileItemReader<>();
		
		//b. set CSV file location
		reader.setResource(new ClassPathResource("students.csv"));
		
		//c. read data line by line
		reader.setLineMapper(new DefaultLineMapper<>() {{
			//Tokenize data and provide name for one line
			setLineTokenizer(new DelimitedLineTokenizer() {{
				setDelimiter(",");
				setNames("studId","studName","studBranch","mark1","mark2","mark3");
			}});
			
			//convert to object and provide name to variable
			setFieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
				setTargetType(Student.class);
			}});
		}});
		
		return reader;
	}
	
	//2. ItemProcessor Object
	@Bean
	public StudentProcessor getStudentProcessor() {
		return new StudentProcessor();
	}
	
	//3. ItemWriter Object
	@Bean
	ItemWriter<Student> getItemWriter(){
		log.info("INSIDE GET ITEM WRITER");
		JdbcBatchItemWriter<Student> writer = new JdbcBatchItemWriter<>();
		writer.setDataSource(ds);
		writer.setSql("INSERT INTO STUDENTS(ID,NAME,BRANCH,M1,M2,M3,PERCENTAGE,GRADE) VALUES(:studId,:studName,:studBranch,:mark1,:mark2,:mark3,:percentage,:grade)");
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
		return writer;
	}
	//4. Data Source Autowired
	@Autowired
	private DataSource ds;
	
	
	//6. StepBuilderFactory Autowired
	@Autowired
	public StepBuilderFactory sf;
	
	//5. Step object configuration
	@Bean
	public Step stepA() {
		return sf.get("stepA")
				.<Student,Student>chunk(3)
				.reader(getItemReader())
				.processor(getStudentProcessor())
				.writer(getItemWriter())
				.build();
	}

	//7. JobExecutionListener Object 
	@Bean
	public JobExecutionListener listener() {
		return new StudentJobListener();	
	}
	
	//8. JobBuilderFactory Autowired
	@Autowired
	public JobBuilderFactory jf;
	
	//9. Job object
	@Bean
	public Job jobA() {
		return jf.get("jobA").listener(listener()).incrementer(new RunIdIncrementer()).start(stepA()).build();
	}
}
