package com.scaler.demo.project.controller;

import org.springframework.boot.autoconfigure.web.format.DateTimeFormatters;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * REST supports
 * GET :
 * POST
 * PUT
 * PATCH
 * DELETE
 */

@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * Path Variable :
     * http://localhost:8080/user/{name}
     * Request Param :
     * http://localhost:8080/user?name={value}
     */
    @GetMapping("/{from}/{to}")
    public String getName(@PathVariable("from") String userName, @PathVariable(name = "to",required = false) String toName){
        return "Hello from "+userName+" to "+toName;
    }

    @GetMapping()
    public String getNameByRequestParam(
            @RequestParam(name = "from") String userName,
            @RequestParam(name = "to", required = false) String toName,
            @RequestParam(name = "createdAt")
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate createDate
            ){
        return "Hello from "+userName+" to "+toName;
    }

    //@PostMapping()
    //@PutMapping()
    //@PatchMapping

}


