package Iceland.Tech.Test.iceland.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import Iceland.Tech.Test.iceland.responses.DefaultResponses;
import Iceland.Tech.Test.iceland.services.DuBaDumService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("dubadum")
public class DuBaDumController {

    private static final Logger L = LogManager.getLogger(DuBaDumController.class);

    @Autowired
    DuBaDumService dubadumService;

    @GetMapping(path="hello-duba")
    public String HelloWorld(   ) {
        return "Hello dubadum !";
    }

    @GetMapping(path = "getfile/{filename}")
    public ResponseEntity GetFile(@RequestParam String filename) {


        try {
            return ResponseEntity.ok(dubadumService.getFile( filename ));
        } catch (Exception e) {
            L.error("Error during processing", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                   .body(DefaultResponses.response500("Error fetching users"+
                    "  Error Case: "+e.getClass().getName()));            
        }
        
    }

}