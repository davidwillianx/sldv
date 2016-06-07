package br.com.sldv.config;


import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.junit.Assert.assertTrue;


public class AppTest {

    private App app;

    @Before
    public void setUp(){
        app = new App();
    }

    @Test
    public void testShouldHaveWebMvcConfigureAdpterInheritance(){
        assertTrue( app instanceof WebMvcConfigurerAdapter);
    }


    @Test
    public void testShouldHaveInternalViewResolved(){
        InternalResourceViewResolver viewResolver;

        viewResolver = app.viewResolver();

        assertTrue(viewResolver instanceof InternalResourceViewResolver);
    }


}
