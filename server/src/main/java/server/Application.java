package server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main function including dashboard and backend startup.
 *
 * @author TODO
 */
@SpringBootApplication
public class Application {

	/**
	 * Application main function
	 *
	 * Runs setup and start up processes and initialises the frontend dashboard.
	 *
	 * @param args Optional additional arguments that are needed.
	 */
	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}
}
