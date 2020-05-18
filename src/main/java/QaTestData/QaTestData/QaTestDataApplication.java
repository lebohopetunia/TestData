package QaTestData.QaTestData;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = { "QaTestData.QaTestData" })
public class QaTestDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(QaTestDataApplication.class, args);
	}

}
