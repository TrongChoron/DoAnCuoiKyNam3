package vn.hcmute.nhom16.config;

import com.stc.vietnamstringutils.VietnameseStringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Sat, 4/23/2022
 * Time     : 4:36 PM
 * Filename : ApplicationSecurityConfig
 */
@Order
@Configuration
public class WebSecurityConfig {
    @Bean
    public VietnameseStringUtils getVietnameseStringUtils() {
        return new VietnameseStringUtils();
    }

}
