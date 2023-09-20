package ru.gb.seminars.sem3.hw;

public class MainHW {

    /**
     * 3.1. Нужно покрыть тестами метод на 100%
     * Метод проверяет, является ли целое число записанное в переменную n, чётным (true) либо нечётным (false).
     * @param n целое число.
     * @return результат проверки на четность
     */
    public boolean evenOddNumber(int n) {
        return n % 2 == 0;
    }

    /**
     * 3.2. Нужно написать метод, который проверяет,
     * попадает ли переданное число в интервал (25;100) и возвращает true, если попадает и false - если нет,
     * @param n число.
     * @return результат проверки на вхождение в интервал.
     */
    public boolean numberInInterval(int n) {
        return n >= 25 && n <= 100;
    }

}
