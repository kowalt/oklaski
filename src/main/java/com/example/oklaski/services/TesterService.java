package com.example.oklaski.services;

import com.example.oklaski.dto.TesterBugDTO;
import com.example.oklaski.entites.Bug;
import com.example.oklaski.entites.Tester;
import com.example.oklaski.mapper.TesterMapper;
import com.example.oklaski.repositories.BugRepository;
import com.example.oklaski.repositories.TesterRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TesterService {

    @Autowired
    public TesterRepository testerRepository;
    @Autowired
    public BugRepository bugRepository;
    @Autowired
    public TesterMapper testerMapper;

    public List<TesterBugDTO> getTestersByBugs(List<String> countries, List<String> descriptions) {
        return testerRepository.findByCountryIn(countries).stream()
                .map(t -> testerMapper.toTesterBugDTO(t, bugRepository.countByDeviceAndTester(descriptions, t.getId())))
                .collect(Collectors.toList());
    }
}
