package net.winfield.demo.computer.sb.controller;

import net.winfield.demo.computer.sb.service.ComputerService;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@EnableAutoConfiguration
public class Compute {
    @RequestMapping(value = "/", headers = "Accept=text/plain;charset=UTF-8")
    String home() {
        System.out.print("My first Springboot program.");
        return "Hello Worlds!";
    }

    @RequestMapping(value = "/plus")
    public int plus(@RequestBody Map<String, Object> reqMap) {
        System.out.print("come here");
        String param1 = reqMap.get("param1").toString();
        String param2 = reqMap.get("param2").toString();
        //return "kaka";
        return Integer.parseInt(param1) + Integer.parseInt(param2);
    }

    @RequestMapping(value = "/minus")
    public int minus(@RequestBody Map<String, Object> reqMap) {
        System.out.print("come here");
        String param1 = reqMap.get("param1").toString();
        String param2 = reqMap.get("param2").toString();
        //return "kaka";
        System.out.print(getComputerService().plus(Float.valueOf(param1), Float.valueOf(param2)));
        return Integer.parseInt(param1) - Integer.parseInt(param2);
    }

    @Bean
    public ComputerService getComputerService() {
        return new ComputerService();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Compute.class, args);
    }
}
