package ru.margarita.ExpertSystem.DTO;

import lombok.Data;

//impot javax.validation.constrains.NotEmpty;

@Data
public class RegistrationRequest {

    // насколько я помню, в мавене не добавляла эту зависимость
  //  @NotEmpty
    private String login;

  //  @NotEmpty
    private String password;

    private String name;

    private String nickName;

}
