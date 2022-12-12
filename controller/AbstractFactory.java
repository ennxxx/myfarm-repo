package controller;

/**
 * An interface to create Crops and Tools.
 *
 * @param <ReturnType> a class
 * @param <CreateFlag> string
 */
public interface AbstractFactory <ReturnType, CreateFlag> {
    ReturnType create(CreateFlag flag);
}


