package net.winfield.demo.computer.sb.controller;

import net.winfield.demo.computer.sb.bean.Input;
import net.winfield.demo.computer.sb.service.ComputerService;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class Compute {
    @RequestMapping(value = "/", headers = "Accept=text/plain;charset=UTF-8")
    String home() {
        System.out.print("My first Springboot program.");
        return "Hello Worlds!";
    }

    @RequestMapping(value = "/plus")
    public String plus(@RequestBody Input input) {
        System.out.print("param1:" + input.getOperator());
        return getComputerService().plus(Float.valueOf(input.getParam1()), Float.valueOf(input.getParam2()));
    }

    @RequestMapping(value = "/minus")
    public String minus(@RequestBody Input input) {
        return getComputerService().minus(Float.valueOf(input.getParam1()), Float.valueOf(input.getParam2()));
    }

    @RequestMapping(value = "/multiple")
    public String multiple(@RequestBody Input input) {
        System.out.print("param1:" + input.getOperator());
        return getComputerService().multiple(Float.valueOf(input.getParam1()), Float.valueOf(input.getParam2()));
    }

    @RequestMapping(value = "/divide")
    public String divide(@RequestBody Input input) {
        return getComputerService().divide(Float.valueOf(input.getParam1()), Float.valueOf(input.getParam2()));
    }

    @Bean
    public ComputerService getComputerService() {
        return new ComputerService();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Compute.class, args);
    }
}
