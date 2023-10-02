package com.example.lab3.Shapes;

import javafx.scene.paint.Color;

abstract public class FillableShape extends Shape{
    private boolean filled;

    protected FillableShape(double x, double y, Color color, boolean filled) {
        super(x, y, color);
        this.filled = filled;
    }

    protected FillableShape() {
        super();
        this.filled = true; //this.filled = filled, kan alternativt också sätta this.filled till false.
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
}
