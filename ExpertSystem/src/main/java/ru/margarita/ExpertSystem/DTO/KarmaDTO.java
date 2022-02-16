package ru.margarita.ExpertSystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.margarita.ExpertSystem.domain.Karma;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class KarmaDTO {

    private int id;

    private Karma.Operation operation;

    private Karma.Type type;

    private Integer fromPersonID;

    private Integer toPersonID;

    private LocalDateTime dateTime;

    private Integer amount;

}
