package com.example.oklaski.mapper;

import com.example.oklaski.dto.TesterBugDTO;
import com.example.oklaski.entites.Tester;
import org.springframework.stereotype.Component;

@Component
public class TesterMapper {
    public TesterBugDTO toTesterBugDTO(Tester tester, Integer numOfBugs) {
        return TesterBugDTO.builder()
                .id(tester.getId())
                .firstName(tester.getFirstName())
                .lastName(tester.getLastName())
                .country(tester.getCountry())
                .numOfBugs(numOfBugs)
                .build();
    }
}
