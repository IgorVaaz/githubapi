package com.igor.nvpc.controller;

import com.igor.nvpc.models.Root;
import com.igor.nvpc.services.FindRepositoriesService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("repositories")
public class FindRepositoriesController {
    private final FindRepositoriesService findRepositoriesService;

    public FindRepositoriesController(FindRepositoriesService findRepositoriesService) {
        this.findRepositoriesService = findRepositoriesService;
    }

    @GetMapping("{user}")
    public Collection<Root> findAllRepositories(@PathVariable final String user, @RequestParam final String filter, @RequestParam final String order){
        return findRepositoriesService.execute(user, filter, order);
    }
}
