package model;

import static positioning.Parameters.DELAY;

public class DelayParameters {
    private int delay;
    private int timerAccelerator = 0;

    public DelayParameters(){
        this.delay = DELAY;
    }

    public void increaseAccelerator(){
        this.timerAccelerator++;
    }

    public void checkAccelerator(){
        if(this.timerAccelerator%5 == 0 && this.timerAccelerator != 0){
            this.timerAccelerator = 0;
            this.delay = this.delay*9/10;
        }
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }
}
