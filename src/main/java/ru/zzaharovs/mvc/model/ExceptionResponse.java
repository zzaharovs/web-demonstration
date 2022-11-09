package ru.zzaharovs.mvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ExceptionResponse {

    private Integer status;
    private String message;

}
