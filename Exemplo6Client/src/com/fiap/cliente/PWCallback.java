package com.fiap.cliente;

import org.apache.ws.security.WSPasswordCallback;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;

public class PWCallback implements CallbackHandler {

   public void handle(Callback[] callbacks)
            throws IOException, UnsupportedCallbackException {

      for (int i = 0; i < callbacks.length; i++) {
         if (callbacks[i] instanceof WSPasswordCallback) {
            WSPasswordCallback pc=(WSPasswordCallback)callbacks[i];
                if (pc.getIdentifier().equals("rodrigo")) {
                    pc.setPassword("987654");
                } else {
                    throw new UnsupportedCallbackException(callbacks[i], "Senha Incorreta");
                }
            } else {
                throw new UnsupportedCallbackException(callbacks[i],"Callback Inválido");
            }
        }
    }
}