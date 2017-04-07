import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Boyd on 4/7/2017.
 */

public class main {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> acceptingStates = new ArrayList<Integer>();
        ArrayList<State> DFA = new ArrayList<State>();
        String input;
        DFA = getDFA();
        acceptingStates = getAcceptingStates(DFA);

        while(true) {
            System.out.println("Enter an input string.");
            input = sc.nextLine();

            System.out.println(test(DFA, acceptingStates, input));
        }




        //System.exit(1);
    }

    public static String test(ArrayList<State> dfa, ArrayList<Integer> accepting, String input)
    {

        State startingState = dfa.get(0);
        State currentState = startingState;

        char[] inputArray = input.toCharArray();
        for(int i = 0; i < inputArray.length; i++)
        {
           int currentHead = Integer.parseInt( Character.toString(inputArray[i]) );
            switch(currentHead)
            {
                case 0:
                    currentState = dfa.get(currentState.getZeroTransition()-1);
                    break;
                case 1:
                    currentState = dfa.get(currentState.getOneTransition()-1);
                    break;
            }
        }

        if(accepting.contains(currentState.myState()))
        {
            System.out.println("Accepted: " + currentState.myState());
            return "ACCEPTED";
        }
        else
        {
            System.out.println("Rejected: " + currentState.myState());
            return "REJECTED";
        }



    }



    public static ArrayList<Integer> getAcceptingStates(ArrayList<State> DFA)
    {
        ArrayList<Integer> acceptingStates = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the number of accepting states.");
        int numAccepting = sc.nextInt();
        if(numAccepting > DFA.size())
        {
            System.out.println("ERROR: Number of accepting states greater than total number of states");
            System.exit(-1);
        }
        else
        {
            for(int i = 1; i <= numAccepting; i++)
            {
                System.out.println("Please enter a accepting state." + i + "/" + numAccepting);
                acceptingStates.add(sc.nextInt());
            }
            return acceptingStates;
        }

        return null;
    }


    public static ArrayList<State> getDFA() {
        Scanner sc = new Scanner(System.in);
        ArrayList<State> returnList = new ArrayList<State>();
        System.out.println("Please enter the number of states");
        int numStates = sc.nextInt();

        for(int i = 1; i <= numStates; i++)
        {
            State nState = new State(i);
            System.out.println("Please enter the state M goes to from state" + (i) + " and symbol 0");
            nState.setZeroTransition(sc.nextInt());
            System.out.println("Please enter the state M goes to from state" + (i)  + " and symbol 1");
            nState.setOneTransition(sc.nextInt());
            returnList.add(nState);
        }
        return returnList;
    }


}
