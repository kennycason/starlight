package com.kennycason.starlight.input;

/**
 * Created by kenny on 5/22/15.
 */
public class MultiController implements Controller {

    private final Controller[] controllers;

    public MultiController(final Controller... controllers) {
        this.controllers = controllers;
    }


    @Override
    public boolean isUp() {
        for(Controller controller : controllers) {
            if(controller.isUp()) { return true; }
        }
        return false;
    }

    @Override
    public boolean isDown() {
        for(Controller controller : controllers) {
            if(controller.isDown()) { return true; }
        }
        return false;
    }

    @Override
    public boolean isLeft() {
        for(Controller controller : controllers) {
            if(controller.isLeft()) { return true; }
        }
        return false;
    }

    @Override
    public boolean isRight() {
        for(Controller controller : controllers) {
            if(controller.isRight()) { return true; }
        }
        return false;
    }

    @Override
    public boolean isStart() {
        for(Controller controller : controllers) {
            if(controller.isStart()) { return true; }
        }
        return false;
    }

    @Override
    public boolean isSelect() {
        for(Controller controller : controllers) {
            if(controller.isSelect()) { return true; }
        }
        return false;
    }

    @Override
    public boolean isA() {
        for(Controller controller : controllers) {
            if(controller.isA()) { return true; }
        }
        return false;
    }

    @Override
    public boolean isB() {
        for(Controller controller : controllers) {
            if(controller.isB()) { return true; }
        }
        return false;
    }

    @Override
    public boolean isX() {
        for(Controller controller : controllers) {
            if(controller.isX()) { return true; }
        }
        return false;
    }

    @Override
    public boolean isY() {
        for(Controller controller : controllers) {
            if(controller.isY()) { return true; }
        }
        return false;
    }

    @Override
    public boolean isL1() {
        for(Controller controller : controllers) {
            if(controller.isL1()) { return true; }
        }
        return false;
    }

    @Override
    public boolean isL2() {
        for(Controller controller : controllers) {
            if(controller.isL2()) { return true; }
        }
        return false;
    }

    @Override
    public boolean isR1() {
        for(Controller controller : controllers) {
            if(controller.isR1()) { return true; }
        }
        return false;
    }

    @Override
    public boolean isR2() {
        for(Controller controller : controllers) {
            if(controller.isR2()) { return true; }
        }
        return false;
    }

    @Override
    public boolean isAny() {
        for(Controller controller : controllers) {
            if(controller.isAny()) { return true; }
        }
        return false;
    }

    @Override
    public long whenUp() {
        for(Controller controller : controllers) {
            if(controller.whenUp() > 0) { return controller.whenUp(); }
        }
        return 0L;
    }

    @Override
    public long whenDown() {
        for(Controller controller : controllers) {
            if(controller.whenDown() > 0) {
                return controller.whenDown(); }
        }
        return 0L;
    }

    @Override
    public long whenLeft() {
        for(Controller controller : controllers) {
            if(controller.whenLeft() > 0) {
                return controller.whenLeft(); }
        }
        return 0L;
    }

    @Override
    public long whenRight() {
        for(Controller controller : controllers) {
            if(controller.whenRight() > 0) {
                return controller.whenRight(); }
        }
        return 0L;
    }

    @Override
    public long whenStart() {
        for(Controller controller : controllers) {
            if(controller.whenStart() > 0) {
                return controller.whenStart(); }
        }
        return 0L;
    }

    @Override
    public long whenSelect() {
        for(Controller controller : controllers) {
            if(controller.whenSelect() > 0) {
                return controller.whenSelect(); }
        }
        return 0L;
    }

    @Override
    public long whenA() {
        for(Controller controller : controllers) {
            if(controller.whenA() > 0) {
                return controller.whenA(); }
        }
        return 0L;
    }

    @Override
    public long whenB() {
        for(Controller controller : controllers) {
            if(controller.whenB() > 0) {
                return controller.whenB(); }
        }
        return 0L;
    }

    @Override
    public long whenX() {
        for(Controller controller : controllers) {
            if(controller.whenX() > 0) {
                return controller.whenX(); }
        }
        return 0L;
    }

    @Override
    public long whenY() {
        for(Controller controller : controllers) {
            if(controller.whenY() > 0) { return controller.whenY(); }
        }
        return 0L;
    }

    @Override
    public long whenL1() {
        for(Controller controller : controllers) {
            if(controller.whenL1() > 0) { return controller.whenL1(); }
        }
        return 0L;
    }

    @Override
    public long whenL2() {
        for(Controller controller : controllers) {
            if(controller.whenL2() > 0) { return controller.whenL2(); }
        }
        return 0L;
    }

    @Override
    public long whenR1() {
        for(Controller controller : controllers) {
            if(controller.whenR1() > 0) { return controller.whenR1(); }
        }
        return 0L;
    }

    @Override
    public long whenR2() {
        for(Controller controller : controllers) {
            if(controller.whenR2() > 0) { return controller.whenR2(); }
        }
        return 0L;
    }
}
