package com.a9.service;

import com.a9.dto.GameDto;
import com.a9.entity.Car;
import com.a9.entity.Game;
import com.a9.entity.MapGame;
import com.a9.entity.User;
import com.a9.mapper.CarMapper;
import com.a9.mapper.GameMapper;
import com.a9.mapper.MapMapper;
import com.a9.mapper.UserMapper;
import com.a9.vo.GameVo;
import com.a9.vo.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {
    @Autowired
    GameMapper gameMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    CarMapper carMapper;

    @Autowired
    MapMapper mapMapper;

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

    public GameVo view(int id) {
        Game game = gameMapper.view(id);

        GameVo gameVo = new GameVo();
        BeanUtils.copyProperties(game, gameVo);

        SimpleDateFormat format = new SimpleDateFormat(patten);
        gameVo.setDuring(format.format(game.getDuring()));

        User user = userMapper.view(game.getCreatedBy());
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(user, userVo);
        gameVo.setCreatedBy(userVo);

        MapGame mapGame = mapMapper.view(game.getMap());
        gameVo.setMap(mapGame);

        Car car = carMapper.view(game.getCar());
        gameVo.setCar(car);

        return gameVo;

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
