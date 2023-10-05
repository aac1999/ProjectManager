package com.example.lab3.Shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends FillableShape{

    private double width, height;

    public Rectangle(double x, double y, double width, double height, Color color, boolean filled) {
        super(x, y, color, filled);
        if(width<=0 || height<=0) throw new IllegalArgumentException("Width or Height Value Too Small");
        this.width = width;
        this.height = height;
    }

    public Rectangle() {
        super();
        this.width = 100;
        this.height = 100;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if(width<=0) throw new IllegalArgumentException("Width Value Too Small");
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if(height<=0) throw new IllegalArgumentException("Height Value Too Small");
        this.height = height;
    }

    @Override
    public void move(long elapsedTimeNs) {
        super.move(elapsedTimeNs);
    }

    @Override
    public void constrain(double boxX, double boxY, double boxWidth, double boxHeight) {
        // If outside the box - calculate new dx and dy
        super.constrain(boxX, boxY, boxWidth, boxHeight);
        double dx = getDx();
        double dy = getDy();
        if (getX() + width < boxX ) {
            dx = Math.abs(dx);
        } else if (getX() + width > boxWidth) {
            dx = -Math.abs(dx);
        }
        if (getY() + height < boxY) {
            dy = Math.abs(dy);
        } else if (getY() + height > boxHeight) {
            dy = -Math.abs(dy);
        }
        setVelocity(dx, dy);
    }

    @Override
    public void paint(GraphicsContext gc) {
        if(!isFilled()) {
            gc.setStroke(getColor());
            gc.strokeRect(getX(), getY(), width, height);
        }
        else if(isFilled()){
            gc.setFill(getColor());
            gc.fillRect(getX(), getY(), width, height);
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                ", x2=" + width +
                ", y2=" + height +
                '}';
    }
}