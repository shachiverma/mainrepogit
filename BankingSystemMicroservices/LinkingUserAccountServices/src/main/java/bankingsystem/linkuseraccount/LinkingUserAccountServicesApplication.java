package bankingsystem.linkuseraccount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class LinkingUserAccountServicesApplication {


	public static void main(String[] args) {
		SpringApplication.run(LinkingUserAccountServicesApplication.class, args);
	}


}
