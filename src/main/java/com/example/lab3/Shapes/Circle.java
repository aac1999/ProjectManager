package com.example.lab3.Shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends FillableShape{
    private double diameter;

    public Circle(double x, double y, Color color, boolean filled, double diameter) {
        super(x, y, color, filled);
        this.diameter = diameter;
    }

    public Circle() {
        super();
        this.diameter = 100; //sätter bara ett random värde!
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    @Override
    public void paint(GraphicsContext gc) {
        if(!isFilled()) {
            gc.setStroke(getColor());
            gc.strokeOval(getX(), getY(), diameter, diameter); //antar att jag gjort rätt?
        }
        else if(isFilled()){
            gc.setFill(getColor());
            gc.fillOval(getX(), getY(), diameter, diameter); //kolla om allt stämmer senare!!
        }
    }


    @Override
    public void constrain(double boxX, double boxY, double boxWidth, double boxHeight) {
        //OBS: Fungerar endast övre och vänstra sidan!
        super.constrain(boxX, boxY, boxWidth, boxHeight);
        double dx = getDx();
        double dy = getDy();

        if (diameter < boxX) {
            dx = Math.abs(dx);
        } else if (diameter > boxWidth) {
            dx = -Math.abs(dx);
        }
        if (diameter < boxY) {
            dy = Math.abs(dy);
        } else if (diameter > boxHeight) {
            dy = -Math.abs(dy);
        }
        setVelocity(dx, dy);
    }

    @Override
    public String toString() {
        return super.toString() +
                ", diameter= " +
                diameter;
    }

}
