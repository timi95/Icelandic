package Iceland.Tech.Test.iceland.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * HelloWorldController
 */

@RestController
public class HelloWorldController {

    @GetMapping(path="/hello-world")
    public String HelloWorld(   ) {
        return "Hello world !";
    }
    
    
}