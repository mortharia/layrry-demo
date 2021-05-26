
package layrry.demo.rest.api;

import layrry.demo.rest.api.service.DataService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Application main class.
 */
@SpringBootApplication
public class DemoApplication {

    /**
     * The main function that will launch the application.
     *
     * @param args arguments of the application
     */
    public static void main(final String[] args) {

        // ensure spring uses the module-classloader
        Thread.currentThread().setContextClassLoader(DemoApplication.class.getClassLoader());

        // we remove all controller and call plugin service "DataService" to reproduce the error
        ConfigurableApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
        DataService service = ctx.getBean(DataService.class);
        service.displayLog("my logs");

    }

}
