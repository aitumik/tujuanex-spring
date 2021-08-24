package com.aitumik.tujuanex;

import com.aitumik.tujuanex.greetingservice.Greeting;
import com.aitumik.tujuanex.greetingservice.GreetingsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class LoadDatabase {
    private static final Logger logger = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(GreetingsRepository repository) {
        logger.debug("Starting the command line runner......");
        return args -> {
            logger.info("Preloading..." + repository.save(
                    new Greeting("English","Hello",true)
            ));
            logger.info("Preloading..." + repository.save(
                    new Greeting("Spanish","Ola",true)
            ));
            logger.info("Preloading..." + repository.save(
                    new Greeting("Russian","Prevyet",true)
            ));
        };
    }
}
