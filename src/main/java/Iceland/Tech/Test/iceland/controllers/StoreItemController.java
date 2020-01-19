package Iceland.Tech.Test.iceland.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Iceland.Tech.Test.iceland.dto.StoreItemDTO;
import Iceland.Tech.Test.iceland.responses.DefaultResponses;
import Iceland.Tech.Test.iceland.services.StoreService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * StoreItemController
 */
@RestController
@RequestMapping("store")
public class StoreItemController {

    private static final Logger L = LogManager.getLogger(StoreItemController.class);

    @Autowired
    private StoreService storeService;
    
    // STOREITEMS
    @GetMapping(path="item")
    public ResponseEntity getStoreItems(@RequestParam(name = "page", defaultValue = "0") int page,
                                        @RequestParam(name = "size", defaultValue = "10") int size ) {
        try {
            return ResponseEntity.ok(storeService.getItems( page,size ));
        } catch (Exception e) {
            L.error("Error during processing", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                   .body(DefaultResponses.response500("Error fetching users"+
                    "  Error Case: "+e.getClass().getName()));            
        }
    }

    @PostMapping(path="item")
    public ResponseEntity createStoreItem(@RequestBody StoreItemDTO itemDTO) {
        try {
            return ResponseEntity.ok(storeService.createStoreItem( itemDTO ));
        } catch (Exception e) {
            L.error("Error during processing", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                   .body(DefaultResponses.response500("Error fetching users"+
                    "  Error Case: "+e.getClass().getName()));            
        }
    }
    
}

// @RequestParam("date") @DateTimeFormat(pattern="yyyy.MM.dd") Date date,
// @RequestParam("localdate") @DateTimeFormat(pattern="yyyy.MM.dd") LocalDate localdate, 
//  @RequestParam("localdatetime") @DateTimeFormat(pattern="yyyy.MM.dd HH:mm:ss") LocalDateTime localdatetime