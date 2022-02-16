package ru.margarita.ExpertSystem.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.margarita.ExpertSystem.DTO.KarmaDTO;
import ru.margarita.ExpertSystem.DTO.PersonDTO;
import ru.margarita.ExpertSystem.DTO.TopicDTO;
import ru.margarita.ExpertSystem.service.KarmaService;

import java.util.List;


@RequestMapping("/api/karma")
@RestController
@AllArgsConstructor
public class KarmaController {
    private final KarmaService karmaService;

    @PatchMapping
    public void addKarmaInTopic (@RequestBody TopicDTO topicDTO, @RequestParam Integer personFromID,
                                 @RequestParam Integer personToID) {
        karmaService.addKarmaInTopic(personFromID, personToID, topicDTO);
    }

    @GetMapping
    public List<KarmaDTO> getKarma (@RequestBody PersonDTO personDTO) {
       return karmaService.getAnonKarma(personDTO);
    }
}
