package ru.margarita.ExpertSystem.configSecurity;

import lombok.Data;
import ru.margarita.ExpertSystem.domain.Person;
//impot javax.validation.constrains.NotEmpty;

@Data
public class RegistrationRequest {

    // насколько я помню, в мавене не добавляла эту зависимость
  //  @NotEmpty
    private String login;

  //  @NotEmpty
    private String password;

}
