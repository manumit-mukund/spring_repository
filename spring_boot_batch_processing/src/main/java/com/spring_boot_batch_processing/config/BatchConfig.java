package com.spring_boot_batch_processing.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.spring_boot_batch_processing.model.Person;

@Configuration
public class BatchConfig {

	@Bean
	public FlatFileItemReader<Person> reader() {
		return new FlatFileItemReaderBuilder<Person>().name("personItemReader")
				.resource(new ClassPathResource("data.csv")).delimited().names(new String[] { "firstName", "lastName" })
				.fieldSetMapper(fieldSet -> {
					Person person = new Person();
					person.setFirstName(fieldSet.readString("firstName"));
					person.setLastName(fieldSet.readString("lastName"));
					return person;
				}).build();
	}

	@Bean
	public JdbcBatchItemWriter<Person> writer(DataSource dataSource) {
		return new JdbcBatchItemWriterBuilder<Person>()
				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
				.sql("INSERT INTO people (first_name, last_name) VALUES (:firstName, :lastName)").dataSource(dataSource)
				.build();
	}

	@Bean
	public Step step(JobRepository jobRepository, PlatformTransactionManager transactionManager,
			FlatFileItemReader<Person> reader, JdbcBatchItemWriter<Person> writer) {
		return new StepBuilder("step", jobRepository).<Person, Person>chunk(10, transactionManager) // You can still use
																									// chunk with
																									// JobRepository and
																									// TransactionManager
				.reader(reader).writer(writer).build();
	}

	@Bean
	public Job job(JobRepository jobRepository, Step step) {
		return new JobBuilder("importUserJob", jobRepository).start(step).build();
	}

	@Bean
	public CommandLineRunner runJob(JobLauncher jobLauncher, Job job) {
		return args -> {
			try {
				// Create unique JobParameters
				JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis()) // unique
																														// parameter
						.toJobParameters();

				jobLauncher.run(job, jobParameters);
				System.out.println("Batch job has been invoked.");
			} catch (JobExecutionException e) {
				System.err.println("Job failed: " + e.getMessage());
			}
		};
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new ResourcelessTransactionManager(); // For simple batch processing without needing a real database
														// transaction manager.
	}
}