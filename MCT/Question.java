import java.util.*;
/**
 * Formulates the data from the file via TextReader class.
 *
 * @author Kai Toledano
 */
public class Question
{
    private String question;
    private ArrayList<String> choices;
    private String answer;
    
    /**
      * Constructor for Question class.
      */
    public Question(String question, String[] choices, String answer)
    {
        this.question = question;
        this.choices = new ArrayList<String>();
        
        for (int i = 0; i < choices.length; i++)
        {
            this.choices.add(choices[i]);
        }
        
        Collections.shuffle(this.choices); // Randomizes the questions and their answers.
        this.answer = answer;
    }
    
    public String getQuestion()
    {
        return question;
    }
    
    public ArrayList<String> getChoices()
    {
        return choices;
    }
    
    public String getAnswer()
    {
        return answer;
    }
}