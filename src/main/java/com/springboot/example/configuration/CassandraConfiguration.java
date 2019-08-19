package com.springboot.example.configuration;

import com.datastax.driver.core.AuthProvider;
import com.datastax.driver.core.PlainTextAuthProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.convert.MappingCassandraConverter;
//import org.springframework.data.cassandra.core.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories(basePackages = "com.springboot.example.repository")
//@Import(RepositoryRestMvcConfiguration.class)
@EnableAutoConfiguration
@EnableConfigurationProperties(CassandraProperties.class)
public class CassandraConfiguration extends AbstractCassandraConfiguration {

    @Autowired
    private CassandraConnectionFactory cassandraConnectionFactory;

//    @Autowired
//    private CassandraOperations cassandraTemplate;

    @Override
    protected String getKeyspaceName() {
        return cassandraConnectionFactory.getProperties().getKeyspaceName();
    }

    @Override
    protected String getContactPoints() {
        return cassandraConnectionFactory.getProperties().getContactPoints().get(0);
    }

    @Override
    protected int getPort() {
        return cassandraConnectionFactory.getProperties().getPort();
    }

    @Override
    protected AuthProvider getAuthProvider() {
        return new PlainTextAuthProvider(cassandraConnectionFactory.getProperties().getUsername(), cassandraConnectionFactory.getProperties().getPassword());
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE;
        //return SchemaAction.RECREATE_DROP_UNUSED; // Please note that, in production, you would want a different schema
    }
    protected boolean getMetricsEnabled() { return false; }

//    @Bean
//    public CassandraOperations operations() throws Exception {
//        return new CassandraTemplate(
//                session().getObject(), new MappingCassandraConverter(new CassandraMappingContext()));
//    }

    @Bean
    public CassandraConnectionFactory cassandraConnectionFactory() {
        return new CassandraConnectionFactory();
    }

}
