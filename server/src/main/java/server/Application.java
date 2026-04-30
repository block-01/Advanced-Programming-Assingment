package server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main function including dashboard and backend startup.
 *
 * @author Lily Wilks
 * @since 1.0.0
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
		try{
			SpringApplication.run(Application.class, args);
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
