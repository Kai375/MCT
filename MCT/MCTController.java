import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
public class MCTController 
{
    /*Declaration of variables.*/
    
    private TextReader reader = new TextReader();
    
    private ToggleGroup group = new ToggleGroup();

    private static int i = 0;
    
    private static int score = 0;
    
    private static final int NUMBER_OF_RADIO_BUTTONS = 4;
        
    @FXML
    private Button NewGame;
    
    @FXML
    private Button Next;
        
    @FXML
    private Button Submit;
    
    @FXML
    private RadioButton radio1;

    @FXML
    private RadioButton radio2;

    @FXML
    private RadioButton radio3;

    @FXML
    private RadioButton radio4;
    
    private RadioButton[] answers = new RadioButton[NUMBER_OF_RADIO_BUTTONS];
    
    @FXML
    private Label question;

    @FXML
    private Label result;
    
    private String correctAnswer = ""; 
    
    private static String userAnswer = "";
              
    private boolean start = true;
    
     @FXML
     /**
      * When a radio button is selected by the user, the program will compare it with the correct answer and update the score accordingly.
      */
    void processRadioButton(ActionEvent event) 
    {
        String q = ((Button)event.getSource()).getText();
        
        for (int j = 0; j < NUMBER_OF_RADIO_BUTTONS; j++)
        {
            if (answers[j].isSelected()) // Checks which radio button has been selected by the user, gets the label, compares it with the correct answer and prints the outcome accordingly.
            {
                if (answers[j].getText() == correctAnswer)
                {
                    result.setText("Correct Answer");
                    score++;
                }
                else 
                {
                    result.setText("Incorrect Answer");
                }               
            }               
        }                       
    }

    @FXML
    /**
     * This starts the game. Afterwards, it serves as the iterator of the MCT.
     */
    void processNextQuestion(ActionEvent event)
    {                 
        if(start) // This sets the game and sets the radio buttons as toggle group.
        {
            question.setText("");
                             
            answers[0] = radio1;
            answers[1] = radio2;
            answers[2] = radio3;
            answers[3] = radio4;
            
            radio1.setToggleGroup(group);
            radio2.setToggleGroup(group);
            radio3.setToggleGroup(group);
            radio4.setToggleGroup(group);
            
            NewGame.setDisable(true);
            start = false;
        }
        
        String q = ((Button)event.getSource()).getText();       
        result.setText("");
      
        
        if (i == reader.getQuestionSet().size()) // Signals to the program that the end of game has been reached and formulates the score.
        {
             question.setText("End of MCT;  Your score is:    " + 100 * ( score / (double) (reader.getQuestionSet().size())));
             Next.setDisable(true);
             Submit.setDisable(true);
             NewGame.setDisable(false);
             for (int j = 0; j < NUMBER_OF_RADIO_BUTTONS; j++)
             {
                 answers[j].setText("");
             }
             result.setText("Do you want to play another round? if so press New Game.");
        }
        else // Gets the data from the file and sends it to the Question class for formulation.
        {
             question.setText(reader.getQuestionSet().get(i).getQuestion());                
             correctAnswer = reader.getQuestionSet().get(i).getAnswer();
                
             for (int j = 0; j < NUMBER_OF_RADIO_BUTTONS; j++) // Sets the possible answers as the radio buttons label.
             {
                 answers[j].setText(reader.getQuestionSet().get(i).getChoices().get(j));
             }
                        
             i++;
        }                                   
    }
    
    @FXML
    /**
      * Resets the game.
      */
    void processNewGame(ActionEvent event) 
    {
        String q = ((Button)event.getSource()).getText();
        
        start = true;
        i = 0;
        score = 0;
        NewGame.setDisable(true);
        Next.setDisable(false);
        Submit.setDisable(false);
        result.setText("");
        question.setText("");
        
        processNextQuestion(event);
    }

}
