import java.io.*;
import java.util.*;
/**
 * Retrieves the data from the file.
 *
 * @author Kai Toledano
 */
public class TextReader
{
    private ArrayList <Question> questionSet;
      
    /**
      * Constructor for TextReader class.
      */
    public TextReader()
    {
      questionSet = new ArrayList<Question>();
        
      try
      {          
          Scanner input = new Scanner(new File("exam.txt"));
                              
          String question = "";
          
          String[] choices = new String[4];
                  
          String answer = "";
          
          int i = 0;
          
          int counter = 1;
                                                     
          boolean flag = false;
          
          while (input.hasNext()) // Runs as long as the EOF has not been reached.
          {
              
              while(!flag) // Controlled infinite loop. 
              {                
                  String line = input.nextLine();
              
                  // As mentioned before, the file needs to be submitted in a certain pattern, as mentioned in the pdf:        
                  
                  if (counter%5 == 1) // First line contains the question, every 5 lines, the current line should contain the next question.
                  {
                      question = line;
                  }
                  else if (counter%5 == 2) // Second line contains the correct answer, every 5 lines, the current line should contain the answer to the next question.
                  {
                      answer = line;
                      choices[i] = line;
                      i++;
                  }
                  else // The rest of the options.
                  {
                      choices[i] = line;
                      i++;
                  }                                 
              
                  if (counter%5 == 0) // Every 5 lines, a data for a whole question has been accquired and the program stops the loop.
                  {
                      flag = true;
                  }
              
                  counter++;
              }
                      
              flag = false;
              
              i = 0;
              
              questionSet.add(new Question(question, choices, answer)); // Sends the data to the Question class for formulation and stores it as an Question object in the questionSet array.
          }
                   
          Collections.shuffle(questionSet, new Random());  // Shuffles the questions.
                    
          input.close();              
         
      }
      catch(IOException err)
      {
          err.printStackTrace();
      }          
    }    
    
    public ArrayList<Question> getQuestionSet()
    {
        return questionSet;
    }   
}
