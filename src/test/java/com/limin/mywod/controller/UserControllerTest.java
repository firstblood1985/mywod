package com.limin.mywod.controller;


import com.limin.mywod.entity.user.User;
import com.limin.mywod.test_utility.TestUtility;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest extends TestUtility{

    private RestTemplateBuilder builder;

    @Before
    public void setup(){
        builder = new RestTemplateBuilder();
    }



    @Test
    public void testSignup(){


    }

    public static void main(String[] args)
    {
        RestTemplateBuilder builder = new RestTemplateBuilder();
        RestTemplate tempalte = builder.build();
     //   User user = generateUser();
        User user = new User();
        user.setLogin("limengm");
        user.setPassword("helloworld");

        String url = new String("http://localhost:8080/user/signup");
        User returned = new User();
        try {
            returned = tempalte.postForObject(url, user, User.class);
        }catch (HttpStatusCodeException e)
        {
            System.out.println(e.getStatusCode());
            System.out.println(e.getResponseBodyAsString());
        }
        System.out.println(returned);

    }
}
