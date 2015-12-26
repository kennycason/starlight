package com.kennycason.starlight.input;

import com.badlogic.gdx.utils.TimeUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kenny on 5/27/15.
 */
public class InputTimeRecorder {

    final public Map<Button, Long> lastPressedMap = new HashMap<>();

    public void recordUp() {
        record(Button.DPAD_UP);
    }

    public void recordDown() {
        record(Button.DPAD_DOWN);
    }

    public void recordLeft() {
        record(Button.DPAD_LEFT);
    }

    public void recordRight() {
        record(Button.DPAD_RIGHT);
    }

    public void recordStart() {
        record(Button.START);
    }

    public void recordSelect() {
        record(Button.SELECT);
    }

    public void recordA() {
        record(Button.A);
    }

    public void recordB() {
        record(Button.B);
    }

    public void recordX() {
        record(Button.X);
    }

    public void recordY() {
        record(Button.Y);
    }

    public void recordL1() {
        record(Button.L1);
    }

    public void recordL2() {
        record(Button.L2);
    }

    public void recordR1() {
        record(Button.R1);
    }

    public void recordR2() {
        record(Button.R2);
    }

    public long whenUp() {
        return when(Button.DPAD_UP);
    }

    public long whenDown() {
        return when(Button.DPAD_DOWN);
    }

    public long whenLeft() {
        return when(Button.DPAD_LEFT);
    }

    public long whenRight()  {
        return when(Button.DPAD_RIGHT);
    }

    public long whenStart()  {
        return when(Button.START);
    }

    public long whenSelect()  {
        return when(Button.SELECT);
    }

    public long whenA()  {
        return when(Button.A);
    }

    public long whenB()  {
        return when(Button.B);
    }

    public long whenX()  {
        return when(Button.X);
    }

    public long whenY()  {
        return when(Button.Y);
    }

    public long whenL1()  {
        return when(Button.L1);
    }

    public long whenL2()  {
        return when(Button.L2);
    }

    public long whenR1() {
        return when(Button.R1);
    }

    public long whenR2() {
        return when(Button.R2);
    }

    private void record(final Button button) {
        lastPressedMap.put(button, TimeUtils.millis());
    }

    private long when(final Button button) {
        if(lastPressedMap.containsKey(button)) { return lastPressedMap.get(button); }
        return 0L;
    }

}
