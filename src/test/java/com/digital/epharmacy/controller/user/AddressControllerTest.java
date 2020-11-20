//package com.digital.epharmacy.controller.user;
//
//
//import com.digital.epharmacy.entity.User.Address;
//import com.digital.epharmacy.factory.User.AddressFactory;
//import org.junit.FixMethodOrder;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.junit.runner.RunWith;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.junit.jupiter.api.Assertions.*;
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@RunWith(SpringRunner.class)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//class AddressControllerTest {
//
//
//    private static Address address = AddressFactory.createAddress(
//            01,
//            100,
//            "DeLaRay",
//            "Bellville"
//    );
//
//    private static String SECURITY_USERNAME = "addressuser";
//    private static String SECURITY_PASSWORD = "addressuserpassword";
//
//    @Autowired
//    private TestRestTemplate restTemplate;
//
//    private String baseURL = "http://localhost:8080/addresses";
//
//
//    @Order(1)
//    @Test
//    void a_create() {
//        String url = baseURL + "/create";
//        System.out.println("URL: " +url);
//        System.out.println("Post Data:" + address);
//        ResponseEntity<Address> postResponse = restTemplate
//                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
//                .postForEntity(url,address,Address.class);
//        assertNotNull(postResponse);
//        assertNotNull(postResponse.getBody());
//        System.out.println("Saved Data:" +address);
//        assertEquals(address.getAddress_id(),postResponse.getBody().getAddress_id());
//    }
//
//
//    @Order(2)
//    @Test
//    void b_read() {
//        String url = baseURL + "/read/" + address.getAddress_id();
//        System.out.println("URL: " +url);
//        ResponseEntity<Address> response = restTemplate
//                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
//                .getForEntity(url,Address.class);
//        assertEquals(address.getAddress_id(), response.getBody().getAddress_id());
//    }
//
//    @Order(3)
//    @Test
//    void c_update() {
//        Address updated = new Address.Builder().copy(address).setStreet_number(35).build();
//        String url = baseURL = "/update";
//        System.out.println("URL: " +url);
//        System.out.println("Post Data: " +updated);
//        ResponseEntity<Address> response = restTemplate
//                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
//                .postForEntity(url,updated,Address.class);
//        assertEquals(address.getAddress_id(), response.getBody().getAddress_id());
//    }
//
//    @Order(4)
//    @Test
//    void d_getAll() {
//        String url = baseURL + "/all";
//        System.out.println("URL: " +url);
//        HttpHeaders headers = new HttpHeaders();
//        HttpEntity<String> entity = new HttpEntity<>(null,headers);
//        ResponseEntity<String> response = restTemplate
//                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
//                .exchange(url, HttpMethod.GET,entity,String.class);
//        System.out.println(response);
//        System.out.println(response.getBody());
//    }
//
//    @Order(5)
//    @Test
//    void e_delete() {
//        String url = baseURL +"/delete/" + address.getAddress_id();
//        System.out.println("URL: " +url);
//        restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).delete(url);
//    }
//}