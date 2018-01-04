package com.limin.mywod;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Duration;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MywodApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void testDuration(){
		Duration d =  Duration.ofHours(1).plusMinutes(25).plusSeconds(24);
		System.out.println("Duration is "+d.toString());

		Duration t = Duration.parse(d.toString());
		Assert.assertEquals(t.toMinutes()-t.toHours()*60,25);
		Assert.assertEquals(t.getSeconds()-t.toMinutes()*60,24);
	}

	@Test
	public void testjson(){


	}
}
