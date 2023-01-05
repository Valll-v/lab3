package org.slovenlypolygon.lab3.model.validators;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

@FacesValidator("rCordValidator")
public class RCordValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        FacesMessage message = new FacesMessage();
        if (o == null) {
            message.setSummary("R cord can not be empty");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
        try {
            double value = Double.parseDouble(o.toString());
            if (value > 2 || value < -2) {
                message.setSummary("R cord must be between -2 and 2");
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