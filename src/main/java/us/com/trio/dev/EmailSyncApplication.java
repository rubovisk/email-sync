package us.com.trio.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages="us.com.trio.dev")
public class EmailSyncApplication {
	public static void main(String[] args) {
		SpringApplication.run(EmailSyncApplication.class, args);
	} 
	
}
