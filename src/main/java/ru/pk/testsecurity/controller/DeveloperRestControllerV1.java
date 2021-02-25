package ru.pk.testsecurity.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pk.testsecurity.model.Developer;

@RestController
@RequestMapping("/api/v1/developers")
public class DeveloperRestControllerV1 {
    private static final Collection<Developer> DEVELOPERS;

    static {
        DEVELOPERS = new ArrayList<>();
        DEVELOPERS.addAll(
                Arrays.asList(
                        new Developer(1L, "Иван", "Иванов"),
                        new Developer(2L, "Костя", "Морозов"),
                        new Developer(3L, "Арт", "Ловянников")
                )
        );
    }

    @GetMapping
    @PreAuthorize("hasAuthority('dev:read')")
    public Collection<Developer> getAll() {
        return DEVELOPERS;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('dev:read')")
    public Developer getById(@PathVariable("id") Long id) {
        return DEVELOPERS.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst().orElse(null);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('dev:write')")
    public Developer create(@RequestBody Developer d) {
        DEVELOPERS.add(d);
        return d;
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('dev:write')")
    public void deleteById(@PathVariable("id") Long id) {
        DEVELOPERS.removeIf(d -> d.getId().equals(id));
    }

}
