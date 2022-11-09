package ru.zzaharovs.mvc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
@Builder
public class EmployeeDto {

    private Integer id;
    @NotNull(message = "name cannot be null")
    private String name;

}
