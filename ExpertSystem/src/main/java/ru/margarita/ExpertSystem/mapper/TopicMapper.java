package ru.margarita.ExpertSystem.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import ru.margarita.ExpertSystem.DTO.TopicDTO;
import ru.margarita.ExpertSystem.domain.Topic;
import ru.margarita.ExpertSystem.repository.DivisionRepo;


@Mapper (componentModel = "spring")
public abstract class TopicMapper {
    @Autowired
    protected DivisionRepo divisionRepo;

    @Mapping (target = "divisionId", source = "topic.division.id")
    public abstract TopicDTO toTopicDTO(Topic topic);

    @Mapping(target = "division", expression = "java(divisionRepo.findById(topicDTO.getDivisionId()).orElseThrow())")
    public abstract Topic toTopic (TopicDTO topicDTO);

}
