package com.itsziroy.bukkitredis.messaging;


public interface ExtensibleMessage extends Message {

    /**
     * The callbacks that should be executed before this message is being sent.
     */
    void executeCallbacks();
}
