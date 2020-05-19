package com.daru.jokenpo.business;

import com.daru.jokenpo.dto.ResultDTO;
import com.daru.jokenpo.dto.form.BetFormDTO;

import java.util.Optional;

public interface Game {
    Optional<ResultDTO> play(BetFormDTO bet);
}
