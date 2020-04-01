package com.nfinity.demo.petsdemotest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
public class PetsdemotestApplicationTests {

	@Test
	public void contextLoads() {
	}

}

