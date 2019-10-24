/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 *          Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie2
{
    /**
     * Get a default greeting   
     * @return a greeting
     */
    public String getGreeting()
    {
        return "Hello, let's talk.";
    }
    
    /**
     * Gives a response to a user statement
     * 
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        statement = statement.trim();
        String response = "";
        //PLTW 1.1.6 Part C start
        int no = findKeyword(statement, "no");
        int famM = findKeyword(statement, "mother");
        int famB = findKeyword(statement, "brother");
        int famD = findKeyword(statement, "father");
        int famS = findKeyword(statement, "sister");
        int petd = findKeyword(statement, "dog");
        int petc = findKeyword(statement, "cat");
        int genderM = findKeyword(statement, "mr.");
        int genderF = findKeyword(statement, "ms.");
        int genderF2 = findKeyword(statement, "mrs.");
        int teach = findKeyword(statement, "Kaehms");
        if (no != -1)
        {
            response = "Why so negative?";
        }
        else if (famM != -1)
        {
            response = "Tell me more about your family.";
        }
        else if (famB != -1)
        {
            response = "Tell me more about your family.";
        }
        else if (famS != -1)
        {
            response = "Tell me more about your family.";
        }
        else if (famD != -1)
        {
            response = "Tell me more about your family.";
        }
        else if (petd != -1){
          response = "Tell me more about your pets.";
        }
        else if (petc != -1){
          response = "Tell me more about your pets.";
        }
        else if (genderM != -1){
          response = "He sounds like a good teacher.";
        }
        else if (genderF != -1){
          response = "She sounds like a good teacher.";
        }
        else if (genderF2 != -1){
          response = "She sounds like a good teacher.";
        }
        else if (teach != -1)
        {
            response = "He sounds like a good teacher";
        }
        else if (statement.length()<= 0)
        {
            response = "Say something please :(";
        }
        //PLTW 1.1.6 Part C end
        else if (statement.indexOf("Mamma") >= 0 || statement.indexOf("mamma") >= 0)
        {
            response = "Aww man. You got me. You got me good :(.";
        }
        else if (statement.indexOf("Joe")>=0 || statement.indexOf("joe")>=0)
        {
            response = "Who's Joe?";
        }
        else if (statement.indexOf("Minecraft")>=0 || statement.indexOf("minecraft")>=0)
        {
            response = ("It's time to go get your revenge " + 
            "So we back in the mine, got our pick axe swinging side to side, day and night");
        }
        else
        {
            response = getRandomResponse();
        }
        return response;
    }
    
    //PLTW 1.1.6 PART C START
    private int findKeyword(String statement, String goal,
    int startPos)
    {
        String phrase = statement.trim();
        // The only change to incorporate the startPos is in
        // the line below
        int psn = phrase.toLowerCase().indexOf(
                goal.toLowerCase(), startPos);

        // Refinement--make sure the goal isn't part of a
        // word
        while (psn >= 0)
        {
            // Find the string of length 1 before and after
            // the word
            String before = " ", after = " ";
            if (psn > 0)
            {
                before = phrase.substring(psn - 1, psn)
                .toLowerCase();
            }
            if (psn + goal.length() < phrase.length())
            {
                after = phrase.substring(
                    psn + goal.length(),
                    psn + goal.length() + 1)
                .toLowerCase();
            }

            // If before and after aren't letters, we've
            // found the word
            if (((before.compareTo("a") < 0) || (before
                    .compareTo("z") > 0)) // before is not a
                // letter
            && ((after.compareTo("a") < 0) || (after
                    .compareTo("z") > 0)))
            {
                return psn;
            }

            // The last position didn't work, so let's find
            // the next, if there is one.
            psn = phrase.indexOf(goal.toLowerCase(),
                psn + 1);

        }

        return -1;
    }
    
    private int findKeyword(String statement, String goal)
    {
        return findKeyword(statement, goal, 0);
    }
    
    //PLTW 1.1.6 PART C END
    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    private String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 6;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";
        
        if (whichResponse == 0)
        {
            response = "Interesting, tell me more.";
        }
        else if (whichResponse == 1)
        {
            response = "Hmmm.";
        }
        else if (whichResponse == 2)
        {
            response = "Do you really think so?";
        }
        else if (whichResponse == 3)
        {
            response = "You don't say.";
        }
        else if (whichResponse == 4)
        {
            response = "yo das crazy";
        }
        else if (whichResponse == 5)
        {
            response = "go stupid ahahhh go ctazy ahahaha";
        }

        return response;
    }
}
