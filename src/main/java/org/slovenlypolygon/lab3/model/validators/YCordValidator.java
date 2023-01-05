package org.slovenlypolygon.lab3.model.validators;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

@FacesValidator("yCordValidator")
public class YCordValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        FacesMessage message = new FacesMessage();
        if (o == null) {
            message.setSummary("Y cord can not be empty");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
        try {
            double value = Double.parseDouble(o.toString());
            if (value > 5 || value < -5) {
                message.setSummary("Y cord must be between -5 and 5");
                message.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(message);
            }
        } catch (NumberFormatException ignored) {
            message.setSummary("Wrong number format");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
    }
}