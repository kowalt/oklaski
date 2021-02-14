package com.example.oklaski.controllers;

import com.example.oklaski.dto.TesterBugDTO;
import com.example.oklaski.services.TesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/tester")
public class TesterController {

    @Autowired
    private TesterService testerService;

    @GetMapping("/byBugs/{countries}/{descriptions}")
    public List<TesterBugDTO> getTestersByBugs(@PathVariable("countries") List<String> countries, @PathVariable("descriptions") List<String> descriptions) {
        return testerService.getTestersByBugs(countries, descriptions);
    }
}
