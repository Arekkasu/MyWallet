package arekkasu.mywallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

@SpringBootApplication
public class MyWalletApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyWalletApplication.class, args);
        checkIfWarOrJar();
    }

    private static void checkIfWarOrJar() {
        try {
            String path = MyWalletApplication.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            String decodedPath = java.net.URLDecoder.decode(path, StandardCharsets.UTF_8.name());

            if (decodedPath.endsWith(".jar")) {
                System.out.println("Running as JAR");
            } else if (decodedPath.endsWith(".war")) {
                System.out.println("Running as WAR");
            } else {
                System.out.println("Not running as executable JAR or WAR");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
