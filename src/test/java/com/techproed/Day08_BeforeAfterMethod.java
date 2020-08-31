package com.techproed;

import org.junit.*;

public class Day08_BeforeAfterMethod {

    //@Before her @Test ten once calisir, ne kadar test varsa o kadar calisir
    //@After her @Test den sonra calisir, ne kadar test varsa o kadar calisir

    @BeforeClass
    public static void setup(){
        System.out.println("setup calisti");
    }
    @AfterClass
    public static void tearDown(){
        System.out.println("tearDown calisti");
    }

    @Before
    public void beforeMethod(){
        System.out.println("beforeMethod calisti");
    }
    @After
    public void afterMethod(){
        System.out.println("afterMethod calisti");
    }


    @Test
    public void test01(){
        System.out.println("TEst01 calisti");
    }
    @Test
    public void test02(){
        System.out.println("TEst02 calisti");
    }



}
