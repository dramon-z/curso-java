package mx.gob.tabasco.seguro.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("mx.gob.tabasco.seguro.repositories")
@EnableTransactionManagement
@ComponentScan(basePackages = { "mx.gob.tabasco.seguro.services" })
public class JpaConfig {

	@Bean
	public EntityManagerFactory entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		bean.setPersistenceUnitName("seguro");
		bean.afterPropertiesSet();
		
		return bean.getObject();
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager bean = new JpaTransactionManager();
		bean.setEntityManagerFactory(entityManagerFactory());
		
		return bean;
	}
	
}
