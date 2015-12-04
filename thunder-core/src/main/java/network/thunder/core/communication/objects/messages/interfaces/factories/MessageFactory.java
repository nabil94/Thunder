package network.thunder.core.communication.objects.messages.interfaces.factories;

import network.thunder.core.communication.Message;
import network.thunder.core.communication.objects.messages.interfaces.message.FailureMessage;

/**
 * Created by matsjerratsch on 27/11/2015.
 */
public interface MessageFactory {
    public FailureMessage getFailureMessage (String failure);

    public Message parseMessage (Object object);

}
