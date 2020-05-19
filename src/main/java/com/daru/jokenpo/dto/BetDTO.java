package com.daru.jokenpo.dto;

import com.daru.jokenpo.enums.BetEnum;
import com.daru.jokenpo.enums.ResultEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class BetDTO {

    @NotEmpty(message = "O campo Nome não pode ser vazio")
    @NotNull(message = "O campo Nome é obrigatório")
    private String name;

    @NotEmpty(message = "O campo Aposta não pode ser vazio")
    @NotNull(message = "O campo Aposta é obrigatório")
    private BetEnum bet;

    @JsonIgnore
    @ToString.Exclude
    private ResultEnum resultEnum;

    @ToString.Include(name = "result")
    public String getResult() {
        return resultEnum != null? resultEnum.toString(): null;
    }
}
