package com.database;

import com.models.Product;
import com.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Database {
    public static final Logger logger = LoggerFactory.getLogger(Database.class); //nam trong phan thuoc tinh
    @Bean //khoi tao data cho H2 Database
    CommandLineRunner initDatabase(ProductRepository productRepository){
        //logger
    return new CommandLineRunner() { //tao ra 1 doi tuong interface
        @Override
        public void run(String... args) throws Exception {
                Product productA = new Product("Macbook pro 16", 2021, 50.0, "");
                Product productB = new Product( "Macbook pro 14", 2020, 20.0, "");
                logger.info("insert data: "+productRepository.save(productA)); //an ban ghi vao trong database
                logger.info("insert data: "+productRepository.save(productB));
        }
    };
    }
}
