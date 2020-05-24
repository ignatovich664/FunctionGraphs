package com.codebind.Classes;

/**
 * Класс настроек координатный осей X и Y и со свойствами <b>xMin</b>, <b>xMax</b>, <b>yMin</b> и <b>yMax</b> .
 * @autor Игнатович
 * @version 1.0
 */
public class AxisSetting {
    /** Поле минимальное значение коордитантой оси X */
    public int xMin;
    /** Поле максимальное значение коордитантой оси X */
    public int xMax;
    /** Поле минимальное значение коордитантой оси Y */
    public int yMin;
    /** Поле максимальное значение коордитантой оси Y */
    public int yMax;
    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param xMin - минимальное значение коордитантой оси X
     * @param xMax - максимальное значение коордитантой оси X
     * @param yMin - минимальное значение коордитантой оси Y
     * @param yMax - максимальное значение коордитантой оси Y
     */
    public AxisSetting(int xMin, int xMax, int yMin, int yMax) {
        this.xMin = xMin;
        this.xMax = xMax;
        this.yMin = yMin;
        this.yMax = yMax;
    }
}
