/**
 * Created by azhang on 1/30/15.
 */
import java.util.EventObject;
public class GameEvent extends EventObject{

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     * http://www.jguru.com/faq/view.jsp?EID=98547 implement this eventually
     */
    public String message;
    public GameEvent(Object source, String msg) {
        super(source);
        message = msg;
    }

}
