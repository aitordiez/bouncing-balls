import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael KÃ¶lling and David J. Barnes
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
        Random bolaAleatoria=new Random();
        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);
        for(int i=0; i<balls; i++){
            //El radio y color de las bolas son aleatorios.
            //Aqui se crea el radio para que salga de forma aleatoria.
            int radioDeLaBola = bolaAleatoria.nextInt(40) + 5;
            //Aqui se crea el color para que salga de forma aleatoria.
            int red=bolaAleatoria.nextInt(256);
            int green=bolaAleatoria.nextInt(256);
            int blue=bolaAleatoria.nextInt(256);
            Color colores= new Color(red, green, blue);
            //Crearemos de forma aleatoria la posicion 
            int posicionX=bolaAleatoria.nextInt(300);
            //Muestra por pantalla las bolas que el usuario ha elegido por parametro
            BouncingBall bolass= new BouncingBall(posicionX, 60, radioDeLaBola, colores, ground, myCanvas);
            bolas.add(bolass);
            bolass.draw();
        }


        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
             //Para mover las bolas que ha elegido el usuario
             for(int i=0; i<balls; i++){
                 bolas.get(i).move();
             }
             //La animación debe terminar cuando alguna bola se salga del suelo por la derecha.
             for(int i=0; i<balls; i++){
                 if(bolas.get(i).getXPosition()>=550){
                     finished=true;
                 }
             }

        }
    }
}

