package demo;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="/Cucumber/src/demo.feature",glue= {"demo"})
public class testRunner {

}
