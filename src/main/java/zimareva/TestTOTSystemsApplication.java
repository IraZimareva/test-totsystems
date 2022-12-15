package zimareva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import zimareva.service.MainService;

@SpringBootApplication
public class TestTOTSystemsApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext =
                SpringApplication.run(TestTOTSystemsApplication.class, args);
        MainService mainService =
                configurableApplicationContext.getBean(MainService.class);
//        mainService.importData();
    }
}
