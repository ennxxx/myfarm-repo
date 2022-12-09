package controller;

public interface AbstractFactory <ReturnType, CreateFlag> {
    ReturnType create(CreateFlag flag);
}


