package com.codebind.Classes;

/**
 * Класс линейной функции со свойствами <b>k</b> и <b>b</b>.
 * @autor Игнатович
 * @version 1.0
 */
public class LineFunction {
    /** Поле параметра k */
    public double k;
    /** Поле параметра b */
    public double b;
    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param k - параметр a
     * @param b - параметр a
     */
    public LineFunction(double k, double b) {
        this.k = k;
        this.b = b;
    }
}
