import java.util.Observable;


public class HangoMeter extends Observable {

    private int maxValue;
    private int minValue;
    private int currentValue;
    
    public HangoMeter()
    {
        maxValue = 100;
        minValue = 0;
        currentValue = 100;
    }
    
    public String getCurrentValue()
    {
        return currentValue + "%";
    }
    
    public void addLife()
    {
        if(currentValue <= maxValue){
            if(currentValue <= maxValue && currentValue >= maxValue-10){
                currentValue = maxValue;
            }
            else{
                currentValue += 10;
            }
            setChanged();
            notifyObservers(getCurrentValue());
        }
    }
    
    public String endOfGame()
    {
        return "Hangometer is down to zero % and you have not found your friend.\nGAME OVER";
    }
    
    public void looseLife()
    {
        if((currentValue - 1) >= minValue) {
            currentValue -= 1;
            setChanged();
            notifyObservers(getCurrentValue());
        }
        /*if(currentValue == minValue) { //Game over
            setChanged();
            notifyObservers(endOfGame());
        }*/
    }
}
