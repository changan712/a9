package com.a9.mapper;

import com.a9.entity.Car;

import java.util.List;

public interface CarMapper {

    List<Car> index();

    Car view(Integer id);

    Integer create(Car body);

}
