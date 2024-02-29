package com.example.turistguidedel2;

import com.example.turistguidedel2.controller.TouristController;
import com.example.turistguidedel2.repository.TourisRepository;
import com.example.turistguidedel2.service.TouristService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class TuristguideDel2ApplicationTests {

    @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
    static
    class RandomPortTest {

    }
    @LocalServerPort
    private int port;



    @Autowired
    private TouristController controller;

    @Autowired
    private TouristService touristService;


    @Autowired

    private TourisRepository tourisRepository;

    @Test
    void contextLoads(){
        assertThat(controller).isNotNull();
        assertThat(touristService).isNotNull();


        assertThat(tourisRepository).isNull();
    }





}
