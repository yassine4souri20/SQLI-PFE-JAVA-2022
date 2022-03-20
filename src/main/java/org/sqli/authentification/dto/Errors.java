package org.sqli.authentification.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Errors {

    private String message;

}
