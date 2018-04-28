package net.winfield.demo;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@EnableAutoConfiguration
public class Example {
    @RequestMapping(value="/", headers = "Accept=text/plain;charset=UTF-8")
    String home() {
        System.out.print("My first Springboot program.");
        return "Hello Worlds!";
    }

    @RequestMapping(value="/plus")
    public int plus(@RequestBody Map<String,Object> reqMap){
        System.out.print("come here");
        String param1 = reqMap.get("param1").toString();
        String param2 = reqMap.get("param2").toString();
        //return "kaka";
        return Integer.parseInt(param1) + Integer.parseInt(param2);
    }

    @RequestMapping(value="/minus")
    public int minus(@RequestBody Map<String,Object> reqMap){
        System.out.print("come here");
        String param1 = reqMap.get("param1").toString();
        String param2 = reqMap.get("param2").toString();
        //return "kaka";
        return Integer.parseInt(param1) - Integer.parseInt(param2);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Example.class, args);
    }
}
