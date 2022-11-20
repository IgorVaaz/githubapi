package com.igor.nvpc.controller;


import com.igor.nvpc.exceptions.RestTemplateErrorException;
import com.igor.nvpc.jsons.Root;
import com.igor.nvpc.services.FindRepositoriesService;
import com.igor.nvpc.utils.GetEnum;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("repositories")
public class FindRepositoriesController {
    private final FindRepositoriesService findRepositoriesService;

    public FindRepositoriesController(final FindRepositoriesService findRepositoriesService) {
        this.findRepositoriesService = findRepositoriesService;
    }

    @GetMapping("{user}")
    @ResponseStatus(HttpStatus.OK)
    public Collection<Root> findAllRepositories(@PathVariable final String user, @RequestParam(required = false) final String filter, @RequestParam(required = false) final String order, @RequestParam(required = false) final String search) throws RestTemplateErrorException {
        final var filterOperation = GetEnum.filter(filter);
        final var orderOperation = GetEnum.order(order);
        return findRepositoriesService.execute(user, filterOperation, orderOperation, search);
    }
}
