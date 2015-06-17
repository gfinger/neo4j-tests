package composite;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterRegistry;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
@EnableNeo4jRepositories(basePackages = "composite")
@EnableAutoConfiguration
public class ApplicationConfig extends Neo4jConfiguration {
    private static final String DATABASE_PATH = "target/cmmn.db";

    public ApplicationConfig() {
        setBasePackage("composite");
    }

    @Bean
    public GraphDatabaseService graphDatabaseService() {
        GraphDatabaseService db = new GraphDatabaseFactory()
                .newEmbeddedDatabase(DATABASE_PATH);
        return db;
    }

    @Override
    @Bean
    protected ConversionService neo4jConversionService() throws Exception {
        ConversionService conversionService = super.neo4jConversionService();
        ConverterRegistry registry = (ConverterRegistry) conversionService;
        registry.removeConvertible(LocalDateTime.class, String.class);
        registry.removeConvertible(String.class, LocalDateTime.class);
        registry.addConverter(new DateToStringConverter());
        registry.addConverter(new StringToDateConverter());
        return conversionService;
    }

    private class DateToStringConverter implements Converter<LocalDateTime, String> {
        @Override
        public String convert(LocalDateTime source) {
            return source.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        }
    }

    private class StringToDateConverter implements Converter<String, LocalDateTime> {
        @Override
        public LocalDateTime convert(String source) {
            return LocalDateTime.parse(source, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        }
    }
}