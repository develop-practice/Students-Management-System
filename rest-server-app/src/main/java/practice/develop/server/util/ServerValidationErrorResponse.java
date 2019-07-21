package practice.develop.server.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
@SuppressWarnings("serial")
public class ServerValidationErrorResponse implements Serializable {

    private final String message;

    @Getter
    @RequiredArgsConstructor
    private static class ValidationMessage implements Serializable {
        private final String message;
    }

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ValidationMessage> validationMessages = new ArrayList<>();
    
    public void addValidationMessage(String message) {
        validationMessages.add(new ValidationMessage(message));
    }
}
