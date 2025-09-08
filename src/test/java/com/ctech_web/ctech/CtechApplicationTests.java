package com.ctech_web.ctech;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import ctech.CtechApplication;

@SpringBootTest(classes = CtechApplication.class)  // ← ADICIONE ESTA LINHA
class CtechApplicationTests {

    @Test
    void contextLoads() {
    }
}
