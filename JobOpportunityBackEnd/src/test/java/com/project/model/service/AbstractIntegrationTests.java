package com.project.model.service;

import java.util.Locale;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.project.JobOpportunityApplication;
import com.project.TestApplication;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {TestApplication.class, JobOpportunityApplication.class})
public abstract class AbstractIntegrationTests {
	
	@Before
	public void beforeTest() {
		Locale.setDefault( new Locale( "pt") );
	}
}