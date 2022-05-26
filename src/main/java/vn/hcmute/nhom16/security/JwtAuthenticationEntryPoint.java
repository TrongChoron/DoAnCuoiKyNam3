//package vn.hcmute.nhom16.security;
//
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.AuthenticationEntryPoint;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.Serializable;
//
///**
// * Create by: IntelliJ IDEA
// * User     : trongnt
// * Date     : Sun, 5/8/2022
// * Time     : 1:53 PM
// * Filename : JwtAuthenticationEntryPoint
// */
//public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {
//    @Override
//    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
//        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
//    }
//}
