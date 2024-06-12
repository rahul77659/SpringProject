package com.iotronicsinnovations.springbootproject.Controllers;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDto {
    private String message;
    private String StatusCode;
    private String errorDetails;


}
