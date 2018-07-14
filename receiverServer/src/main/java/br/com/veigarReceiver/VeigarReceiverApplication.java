package br.com.veigarReceiver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class VeigarReceiverApplication {

	public static void main(String[] args) {
		SpringApplication.run(VeigarReceiverApplication.class, args);
	}
}
