//package com.foxmided.carrestapi.Controllers;
//
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.client.RestTemplate;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@Controller
//public class UserController {
//    private String managementApiToken;
//
//    @GetMapping(value="/users")
//    @ResponseBody
//    public ResponseEntity<String> users(HttpServletRequest request, HttpServletResponse response) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.set("Authorization", "Bearer " + getManagementApiToken());
//
//        HttpEntity<String> entity = new HttpEntity<String>(headers);
//
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> result = restTemplate
//                .exchange("https://dev-example.auth0.com/api/v2/users", HttpMethod.GET, entity, String.class);
//        return result;
//    }
//
//    public String getManagementApiToken() {
//        return managementApiToken;
//    }
//
//    public void setManagementApiToken(String managementApiToken) {
//        this.managementApiToken = managementApiToken;
//    }
//}