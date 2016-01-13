package com.tlherr.Events;

/**
 * Created by tom on 2016-01-13.
 */
public interface EventConsumer {

    /**
     * This method is called whenever the observed object is changed. An
     * application calls an <tt>Observable</tt> object's
     * <code>notifyObservers</code> method to have all the object's
     * observers notified of the change.
     *  @param o   the observable object.
     * @param arg an argument passed to the <code>notifyObservers</code>
     */
    public void update(EventDispatcher o, String event, Object arg);
}
