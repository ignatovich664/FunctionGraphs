package com.codebind.Classes;

/**
 * Класс квадратной функции со свойствами <b>a</b>, <b>b</b> и <b>c</b>.
 * @autor Игнатович
 * @version 1.0
 */
public class SquareFunction {
    /** Поле параметра a */
    public double a;
    /** Поле параметра b */
    public double b;
    /** Поле параметра c */
    public double c;
    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param a - параметр a
     * @param b - параметр a
     * @param c - параметр a
     */
    public SquareFunction(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
