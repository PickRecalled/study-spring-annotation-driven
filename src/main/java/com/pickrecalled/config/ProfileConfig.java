package com.pickrecalled.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.pickrecalled.bean.Yellow;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;

@Profile("dev")
@Configuration
@PropertySource("classpath:/dataSource.properties")
public class ProfileConfig implements EmbeddedValueResolverAware {

	@Bean
	public Yellow yellow() {
		return new Yellow();
	}

	@Value("${db.user}")
	private String dbUser;

	private String dbDriverClass;

	@Value("${db.jdbcUrl}")
	private String dbJdbcUrl;

	@Profile("dev")
	@Bean("devDataSources")
	public DataSource dataSourcesDev(@Value("${db.pwd}") String dbPwd) throws Exception {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(dbUser);
		dataSource.setPassword(dbPwd);
		dataSource.setJdbcUrl(dbDriverClass);
		dataSource.setDriverClass(dbJdbcUrl);
		return dataSource;
	}

	@Profile("test")
	@Bean("testDataSources")
	public DataSource dataSourcesTest(@Value("${db.pwd}") String dbPwd) throws Exception {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(dbUser);
		dataSource.setPassword(dbPwd);
		dataSource.setJdbcUrl(dbDriverClass);
		dataSource.setDriverClass(dbJdbcUrl);
		return dataSource;
	}

	@Profile("prod")
	@Bean("prodDataSources")
	public DataSource dataSourcesProd(@Value("${db.pwd}") String dbPwd) throws Exception {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(dbUser);
		dataSource.setPassword(dbPwd);
		dataSource.setJdbcUrl(dbDriverClass);
		dataSource.setDriverClass(dbJdbcUrl);
		return dataSource;
	}

	@Override
	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		dbDriverClass = resolver.resolveStringValue("db.driverClass");
	}
}
