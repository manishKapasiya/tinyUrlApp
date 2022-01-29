package com.manish.tinyUrlApp.web.resources;

import com.manish.tinyUrlApp.service.ITinyUrlService;
import com.manish.tinyUrlApp.web.request.GetTinyUrlRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tinyUrl")
public class TinyUrlResource {

    private ITinyUrlService tinyUrlService;

    public TinyUrlResource(@Autowired ITinyUrlService tinyUrlService){
        this.tinyUrlService = tinyUrlService;
    }

    @PostMapping
    public ResponseEntity<String> createTinyURl(@RequestBody GetTinyUrlRequest request){
        if(request==null) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(tinyUrlService.getTinyUrl(request),
                HttpStatus.OK);
    }

}
