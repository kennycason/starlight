package com.kennycason.starlight.input;

/**
 * Created by kenny on 5/22/15.
 *
 * Simple controller interface
 */
public interface Controller {

    boolean isUp();
    boolean isDown();
    boolean isLeft();
    boolean isRight();

    boolean isStart();
    boolean isSelect();

    boolean isA();
    boolean isB();
    boolean isX();
    boolean isY();

    boolean isL1();
    boolean isL2();
    boolean isR1();
    boolean isR2();

    boolean isAny();

    long whenUp();
    long whenDown();
    long whenLeft();
    long whenRight();

    long whenStart();
    long whenSelect();

    long whenA();
    long whenB();
    long whenX();
    long whenY();

    long whenL1();
    long whenL2();
    long whenR1();
    long whenR2();

}
