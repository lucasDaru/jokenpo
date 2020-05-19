package com.daru.jokenpo;

import com.daru.jokenpo.business.Game;
import com.daru.jokenpo.dto.BetDTO;
import com.daru.jokenpo.dto.ResultDTO;
import com.daru.jokenpo.dto.form.BetFormDTO;
import com.daru.jokenpo.enums.BetEnum;
import com.daru.jokenpo.enums.ResultEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class JokenpoApplicationTests {

	@Autowired
	private Game game;

	private String name;
	private BetDTO playerTest;
	private Optional<BetDTO> playerResult;
	private Optional<ResultDTO> result;
	private BetFormDTO betFormDTO;

	@Test
	void contextLoads() {

	}

	@Test
	void testLoser(){

		betFormDTO = new BetFormDTO();
		playerTest = new BetDTO();
		name = "Lucas";
		result = null;
		playerResult = null;

		playerTest.setName(name);
		playerTest.setBet(BetEnum.LIZARD);
		betFormDTO.setPlayerOne(playerTest);

		playerTest = new BetDTO();
		playerTest.setName("Daru");
		playerTest.setBet(BetEnum.SCISSORS);
		betFormDTO.setPlayerTwo(playerTest);

		playerTest = new BetDTO();
		playerTest.setName("Miguel");
		playerTest.setBet(BetEnum.SPOCK);
		betFormDTO.setPlayerThree(playerTest);

		result = game.play(betFormDTO);


		if (result.isPresent()){
			playerResult = retBetDTO(result.get());
		}
		assertThat(playerResult.get().getResult()).isEqualTo("LOSER");

	}

	@Test
	void testWin(){

		betFormDTO = new BetFormDTO();
		playerTest = new BetDTO();
		name = "Lucas";
		result = null;
		playerResult = null;

		playerTest.setName(name);
		playerTest.setBet(BetEnum.LIZARD);
		betFormDTO.setPlayerOne(playerTest);

		playerTest = new BetDTO();
		playerTest.setName("Daru");
		playerTest.setBet(BetEnum.PAPER);
		betFormDTO.setPlayerTwo(playerTest);

		playerTest = new BetDTO();
		playerTest.setName("Miguel");
		playerTest.setBet(BetEnum.SPOCK);
		betFormDTO.setPlayerThree(playerTest);

		result = game.play(betFormDTO);


		if (result.isPresent()){
			playerResult = retBetDTO(result.get());
		}
		assertThat(playerResult.get().getResult()).isEqualTo("WIN");
	}


	@Test
	void testDraw(){
		betFormDTO = new BetFormDTO();
		playerTest = new BetDTO();
		name = "Lucas";
		result = null;
		playerResult = null;

		playerTest.setName(name);
		playerTest.setBet(BetEnum.LIZARD);
		betFormDTO.setPlayerOne(playerTest);

		playerTest = new BetDTO();
		playerTest.setName("Daru");
		playerTest.setBet(BetEnum.LIZARD);
		betFormDTO.setPlayerTwo(playerTest);

		playerTest = new BetDTO();
		playerTest.setName("Miguel");
		playerTest.setBet(BetEnum.LIZARD);
		betFormDTO.setPlayerThree(playerTest);

		result = game.play(betFormDTO);


		if (result.isPresent()){
			playerResult = retBetDTO(result.get());
		}
		assertThat(playerResult.get().getResult()).isEqualTo("DRAW");
	}

	private Optional<BetDTO> retBetDTO(ResultDTO resultDTO){
		return resultDTO.getBets().stream()
				.filter(p -> p.getName().equals(name))
				.findFirst();
	}

}
