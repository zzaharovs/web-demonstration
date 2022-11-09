package ru.zzaharovs.mvc.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.zzaharovs.mvc.model.EmployeeDto;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.IOException;
import java.util.Arrays;

@RestController
@Validated
@RequestMapping("/api")
public class MvcController {


    @GetMapping("/echo")
    public String echo(String param) {
        System.out.println(param);
        return "echo " + param;
    }

    ;

    @GetMapping("/validating/{id}")
    public void printValidParam(@Valid @RequestParam @Min(0) Integer age,
                                @Valid @PathVariable @Min(0) @Max(10) Integer id) {
        System.out.printf("age %d, id %d", age, id);
    }

    @PostMapping("/print")
    public EmployeeDto printBody(@RequestBody EmployeeDto employee, HttpServletRequest request) {
        System.out.println(employee);
        System.out.println(request.getHeader("Pipiska"));
        return employee;
    }

    ;


    @PostMapping("/printValidBody")
    public void printValidBody(@RequestBody @Valid EmployeeDto employee) {
        System.out.println(employee);
    }

    ;

    @PostMapping("/file")
    public void file(MultipartFile file) throws IOException {
        System.out.println(file.getName());
        System.out.println(file.getContentType());
        System.out.println(file.getSize());
        System.out.println(Arrays.toString(file.getBytes()));
    }

    ;


}
