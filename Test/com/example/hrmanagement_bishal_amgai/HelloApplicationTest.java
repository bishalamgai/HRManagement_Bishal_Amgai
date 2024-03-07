package com.example.hrmanagement_bishal_amgai;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloApplicationTest {

    @Test
    void annualsalary() {
        HelloApplication x= new HelloApplication();
        assertEquals(x.annualsalary(90000),1080000);
    }
}