package tests.day16_pageObjectModel;

import org.testng.annotations.Test;

public class C02_XmlFiles {

    @Test
    public void test01(){
        System.out.println("test 1 calisti");
    }

    @Test(groups = "smoke")
    public void test02(){
        System.out.println("test 2 calisti");
    }

    @Test(groups = {"smoke", "regression"})
    public void test03(){
        System.out.println("test 3 calisti");
    }

    @Test(groups = "regression")
    public void test04(){
        System.out.println("test 4 calisti");
    }

    @Test
    public void test05(){
        System.out.println("test 5 calisti");
    }
}
