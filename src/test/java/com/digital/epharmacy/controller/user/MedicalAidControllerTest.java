//package com.digital.epharmacy.controller.user;
//
//import com.digital.epharmacy.entity.User.MedicalAid;
//import com.digital.epharmacy.factory.User.MedicalAidFactory;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
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
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@RunWith(SpringRunner.class)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class MedicalAidControllerTest {
//
//
//    private static MedicalAid medicalAid = MedicalAidFactory.createMedicalAid(
//           485723,
//           "Health Med",
//           "High Benefits"
//    );
//
//    private static String SECURITY_USERNAME = "medicaluser";
//    private static String SECURITY_PASSWORD = "medicaluserpassword";
//
//    @Autowired
//    private TestRestTemplate restTemplate;
//
//    private String baseURL = "http://localhost:8080/medical_aids";
//
//    @Order(1)
//    @Test
//    public void a_create() {
//        String url = baseURL + "/create";
//        System.out.println("URL: " + url);
//        System.out.println("POST Data: " + medicalAid);
//
//        ResponseEntity<MedicalAid> response = restTemplate
//                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
//                .postForEntity(url, medicalAid, MedicalAid.class);
//
//        assertNotNull(response);
//        assertNotNull(response.getBody());
//        medicalAid = response.getBody();
//
//        System.out.println("Saved Data: " + medicalAid);
//        assertEquals(medicalAid.getMedical_aid_name(), response.getBody().getMedical_aid_name());
//    }
//
//    @Order(2)
//    @Test
//    public void b_read() {
//        String url = baseURL + "/read/" + medicalAid.getMedical_aid_name();
//        System.out.println("URL: " + url);
//
//        ResponseEntity<MedicalAid> response = restTemplate
//                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
//                .getForEntity(url, MedicalAid.class);
//        assertEquals(medicalAid.getMedical_aid_name(), response.getBody().getMedical_aid_name());
//        System.out.println(response);
//        System.out.println(response.getBody());
//    }
//
//    @Order(3)
//    @Test
//    public void c_update() {
//        MedicalAid medicalAidUpdate = new MedicalAid
//                .Builder()
//                .copy(medicalAid)
//                .setMedical_aid_name(
//                        "Grants Medical"
//                )
//                .build();
//        String url = baseURL + "/update/"; // + medicalAid.getMedicalAidId();
//
//        System.out.println("URL: " + url);
//        System.out.println("POST Data: " + medicalAidUpdate);
//
//        ResponseEntity<MedicalAid> response = restTemplate
//                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
//                .postForEntity(url, medicalAidUpdate, MedicalAid.class);
//        medicalAid = response.getBody();
//        assertEquals("Grants Medical", response.getBody().getMedical_aid_name());
//
//    }
//
//    @Order(4)
//    @Test
//    public void d_getAll() {
//        String url = baseURL + "/all";
//        System.out.println("URL: " + url);
//        HttpHeaders headers = new HttpHeaders();
//        HttpEntity<String> entity = new HttpEntity<>(null, headers);
//
//        ResponseEntity<String> response = restTemplate
//                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
//                .exchange(url, HttpMethod.GET, entity, String.class);
//        System.out.println(response);
//        System.out.println(response.getBody());
//    }
//
//    @Order(5)
//    @Test
//    public void e_delete() {
//        String url = baseURL + "/delete/" + medicalAid.getMedical_aid_id();
//        System.out.println("URL: " + url);
//        restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).delete(url);
//    }
//}