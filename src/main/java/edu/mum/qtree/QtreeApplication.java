package edu.mum.qtree;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class QtreeApplication {

    public static void main(String[] args) {

        //SpringApplication.run(QtreeApplication.class, args);

        ConfigurableApplicationContext context =
                new SpringApplication().run(edu.mum.qtree.QtreeApplication.class);
    }

}
