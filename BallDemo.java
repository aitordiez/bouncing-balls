import java.awt.Color;
import java.util.ArrayList;
/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private ArrayList<BouncingBall>bolas;
    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
        bolas = new ArrayList<BouncingBall>();
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int balls)
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);
       
        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);
        for(int i=0; i<balls; i++){
            BouncingBall bolass= new BouncingBall(60 + (50*i), 60, 50, Color.GREEN, ground, myCanvas);
            bolas.add(bolass);
            bolass.draw();
        }


        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
             for(int i=0; i<balls; i++){
                 bolas.get(i).move();
             }
            // stop once ball has travelled a certain distance on x axis
            /*if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
                finished = true;
            }*/
            
        }
    }
}

