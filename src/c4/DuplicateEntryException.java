package c4;

public class DuplicateEntryException extends Exception {

    /**
     *
     * @param errorMessage
     */
    public DuplicateEntryException(String errorMessage){
        super(errorMessage);
    }
}
