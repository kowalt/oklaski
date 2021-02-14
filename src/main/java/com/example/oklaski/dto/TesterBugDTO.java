package com.example.oklaski.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class TesterBugDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String country;
    private Integer numOfBugs;
}
