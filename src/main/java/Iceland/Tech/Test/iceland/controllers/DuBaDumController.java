package Iceland.Tech.Test.iceland.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import Iceland.Tech.Test.iceland.responses.DefaultResponses;
import Iceland.Tech.Test.iceland.responses.FileResponse;
import Iceland.Tech.Test.iceland.services.DuBaDumService;
import Iceland.Tech.Test.iceland.services.StorageService;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("dubadum")
public class DuBaDumController {

    private static final Logger L = LogManager.getLogger(DuBaDumController.class);
    
    @Autowired
    DuBaDumService dubadumService;

    private StorageService storageService;

    @GetMapping(path="hello-duba")
    public String HelloWorld(   ) {
        return "Hello dubadum !";
    }

    @GetMapping(path = "getfile/{filename}")
    public ResponseEntity GetFile(@RequestParam String filename) {


        try {
            return ResponseEntity.ok(storageService.getFile( filename ));
        } catch (Exception e) {
            L.error("Error during processing", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                   .body(DefaultResponses.response500("Error fetching users"+
                    "  Error Case: "+e.getClass().getName()));            
        }
        
    }



    @GetMapping("/")
    public String listAllFiles(Model model) {

        model.addAttribute("files", storageService.loadAll().map(
                path -> ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/download/")
                        .path(path.getFileName().toString())
                        .toUriString())
                .collect(Collectors.toList()));

        return "listFiles";
    }

    @GetMapping("/download/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {

        Resource resource = storageService.loadAsResource(filename);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @PostMapping("/upload-file")
    @ResponseBody
    public FileResponse uploadFile(@RequestParam("file") MultipartFile file) {
        String name = storageService.store(file);

        String uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(name)
                .toUriString();

        return new FileResponse(name, uri, file.getContentType(), file.getSize());
    }

    @PostMapping("/upload-multiple-files")
    @ResponseBody
    public List<FileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.stream(files)
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }


}