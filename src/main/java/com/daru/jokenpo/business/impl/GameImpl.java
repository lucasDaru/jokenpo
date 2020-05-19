package com.daru.jokenpo.business.impl;

import com.daru.jokenpo.business.Game;
import com.daru.jokenpo.dto.BetDTO;
import com.daru.jokenpo.dto.ResultDTO;
import com.daru.jokenpo.dto.form.BetFormDTO;
import com.daru.jokenpo.enums.ResultEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GameImpl implements Game {

    private ResultDTO resultDTO;
    private List<BetDTO> betsRetValues;
    private List<BetDTO> betsValues;
    BetDTO betPreview;
    BetDTO betPreviewOld;

    @Override
    public Optional<ResultDTO> play(BetFormDTO bets){

        betsRetValues = new ArrayList<>();
        betsValues = new ArrayList<>();

        resultDTO = null;
        betPreview = null;
        betPreviewOld = null;

        betsValues.add(bets.getPlayerOne());
        betsValues.add(bets.getPlayerTwo());
        betsValues.add(bets.getPlayerThree());
        betsRetValues.addAll(betsValues);

        for (BetDTO bet : betsValues){
            betsRetValues.remove(bet);
            bet.setResultEnum(ResultEnum.WIN);

            betsRetValues.stream().forEach(r -> {
                if (bet.getResultEnum().equals(ResultEnum.WIN)){
                    if (bet.getBet().losesTo(r.getBet())){
                        bet.setResultEnum(ResultEnum.LOSER);
                    }else if(bet.getBet().equals(r.getBet())) {
                        bet.setResultEnum(ResultEnum.DRAW);
                    }
                }
            });

            betsRetValues.add(bet);
        }

        resultDTO = new ResultDTO();
        resultDTO.setBets(betsRetValues);

        return Optional.ofNullable(resultDTO);
    }

}
