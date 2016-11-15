package demo.base.c8.s3;

import java.util.*;

public class Canvas {
    //	// 同时在画布上绘制多个形状
//	public void drawAll(List<Shape> shapes)
//	{
//		for (Shape s : shapes)
//		{
//			s.draw(this);
//		}
//	}
//	public void drawAll(List<?> shapes)
//	{
//		for (Object obj : shapes)
//		{
//			Shape s = (Shape)obj;
//			s.draw(this);
//		}
//	}
    // 同时在画布上绘制多个形状，使用被限制的泛型通配符
    public void drawAll(List<? extends Shape> shapes) {
        for (Shape s : shapes) {
            s.draw(this);
        }
    }

    public static void main(String[] args) {
        List<Circle> circleList = new ArrayList();


        Circle circle = new Circle();
        circleList.add(circle);

        Canvas c = new Canvas();
        c.drawAll(circleList);


        List<Rectangle> rectangleList = new ArrayList();
        Rectangle r = new Rectangle();
        rectangleList.add(r);
        Canvas c2 = new Canvas();
        c2.drawAll(rectangleList);
    }
}
