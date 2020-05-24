package com.codebind.Classes;

/**
 * Класс кубической функции со свойствами <b>a</b>, <b>b</b>, <b>c</b> и <b>d</b> .
 * @autor Игнатович
 * @version 1.0
 */
public class CubeFunction {
    /** Поле параметра a */
    public double a;
    /** Поле параметра b */
    public double b;
    /** Поле параметра c */
    public double c;
    /** Поле параметра d */
    public double d;
    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param a - параметр a
     * @param b - параметр a
     * @param c - параметр a
     * @param d - параметр d
     */
    public CubeFunction(double a, double b, double c, double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
}
