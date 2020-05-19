package com.daru.jokenpo.dto.form;

import com.daru.jokenpo.dto.BetDTO;
import lombok.Data;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class BetFormDTO {

    @NotEmpty(message = "O Jogador 1 não pode ser vazio")
    @NotNull(message = "O Jogador 1 é obrigatório")
    private BetDTO playerOne;

    @NotEmpty(message = "O Jogador 2 não pode ser vazio")
    @NotNull(message = "O Jogador 2 é obrigatório")
    private BetDTO playerTwo;

    @NotEmpty(message = "O Jogador 3 não pode ser vazio")
    @NotNull(message = "O Jogador 3 é obrigatório")
    private BetDTO playerThree;
}
