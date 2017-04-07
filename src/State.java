/**
 * Created by Boyd on 4/7/2017.
 */
public class State {

    private int symbol0State;
    private int symbol1State;
    private int myState;

    public State(int myState)
    {
        this.myState = myState;
    }

    public void setZeroTransition(int nextState)
    {
        this.symbol0State = nextState;
    }

    public int getZeroTransition() {
        return this.symbol0State;
    }

    public void setOneTransition(int nextState)
    {
        this.symbol1State = nextState;
    }

    public int getOneTransition()
    {
        return this.symbol1State;
    }

    public int myState()
    {
        return this.myState;
    }


}
