package br.com.mycompany.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "emailValidator")
public class EmailValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object object) throws ValidatorException {
        String enteredEmail = (String)object;
        
        //set the email pattern String
        Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
        //match the given string with the pattern
        Matcher m = p.matcher(enteredEmail);
        //check whether match is found
        boolean matchFound = m.matches();
        
        if(!matchFound){
           FacesMessage message = new FacesMessage();
           message.setDetail("Email Incorreto!");
           message.setSummary("Email Incorreto!");
           message.setSeverity(FacesMessage.SEVERITY_ERROR);
           throw new ValidatorException(message);          
        }
    }
    
}
