package com.example.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ValidationEx {
    private String campo;
    private String messaggio;

}
