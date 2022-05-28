package vn.hcmute.nhom16.config;

import com.stc.vietnamstringutils.VietnameseStringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Fri, 5/27/2022
 * Time     : 23:18
 * Filename : ApplicationConfiguration
 */
@Configuration
public class ApplicationConfiguration {

    @Bean
    public VietnameseStringUtils getVietnameseStringUtils() {
        return new VietnameseStringUtils();
    }


}
