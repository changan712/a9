package com.a9.service;

import com.a9.dto.GameDto;
import com.a9.entity.Game;
import com.a9.mapper.GameMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GameService {
    @Autowired
    GameMapper gameMapper;
    final String patten = "mm:ss.SSS";

    public void create(GameDto body) {

        Game game = new Game();
        game.setCreatedBy(1);
        game.setCar(body.getCar());
        game.setCarScore(body.getCarScore());

        SimpleDateFormat format = new SimpleDateFormat(patten);

        try {
            Date d = format.parse(body.getDuring());
            // Time time = new Time(d.getTime());
            game.setDuring(d);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        gameMapper.create(game);

    }

    public GameDto view(int id) {
        Game game = gameMapper.view(id);


        GameDto gameDto = new GameDto();
        BeanUtils.copyProperties(game, gameDto);
        SimpleDateFormat format = new SimpleDateFormat(patten);
        gameDto.setDuring(format.format(game.getDuring()));

        return gameDto;


    }

    public List<GameDto> index() {


        List<Game> list = gameMapper.index();

        return list.stream().map(item -> {

            GameDto gameDto = new GameDto();
            BeanUtils.copyProperties(item, gameDto);
            SimpleDateFormat format = new SimpleDateFormat(patten);
            gameDto.setDuring(format.format(item.getDuring()));
            return gameDto;
        }).collect(Collectors.toList());
    }

}
