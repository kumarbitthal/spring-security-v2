package kb.spsecurity.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordGenerator {

    public static void main(String[] args) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("user-1"));
        System.out.println(encoder.encode("user-2"));
        System.out.println(encoder.encode("admin-1"));
    }
}
