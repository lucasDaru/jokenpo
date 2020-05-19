package com.daru.jokenpo.controller;

import com.daru.jokenpo.business.Game;
import com.daru.jokenpo.dto.ResultDTO;
import com.daru.jokenpo.dto.form.BetFormDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/1.0")
@Api(value="Game Controller", description="Jokenpo Game Daru")
public class GameController {

    @Autowired
    private Game game;

    @PostMapping(value = "/teste", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(httpMethod = "POST", value = "Game jokenpo", notes = "Game jokenpo.")
    public ResponseEntity<ResultDTO> getAllUsers(@RequestBody @Valid BetFormDTO betFormDTO) {
        return new ResponseEntity<ResultDTO>(game.play(betFormDTO).orElse(null), HttpStatus.OK);
    }
}
