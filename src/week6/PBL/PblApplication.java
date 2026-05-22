package week6.PBL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages = {
                "week6.PBL",
                "week7.PBL"
        }
)
public class PblApplication {

    public static void main(String[] args) {
        SpringApplication.run(PblApplication.class, args);
    }
}