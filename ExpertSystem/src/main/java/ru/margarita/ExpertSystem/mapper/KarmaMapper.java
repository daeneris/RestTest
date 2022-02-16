package ru.margarita.ExpertSystem.mapper;

import org.mapstruct.Mapper;
import ru.margarita.ExpertSystem.DTO.KarmaDTO;
import ru.margarita.ExpertSystem.domain.Karma;

@Mapper(componentModel = "spring")
public interface KarmaMapper {

    KarmaDTO toKarmaDTO (Karma karma);

    Karma toKarma (KarmaDTO karmaDTO);
}
