package zimareva.exception;

import zimareva.model.TypeInputData;

import java.text.MessageFormat;

public class NotValidTypeInputDataException extends RuntimeException {
    public NotValidTypeInputDataException(TypeInputData type) {
        super(MessageFormat.format("Not valid type of input data {0}", type.toString()));
    }
}
