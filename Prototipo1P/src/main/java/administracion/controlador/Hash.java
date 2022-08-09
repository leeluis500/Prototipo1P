package administracion.controlador;

import java.util.Base64;
import java.util.logging.Logger;

public class Hash {
    
    
    // Retorna un hash MD5 a partir de un texto 
    public static String getMD5(String txt) {
        Base64.Encoder encoder = Base64.getEncoder();
        String encodedString = encoder.encodeToString(txt.getBytes());
        return encodedString;
    }
 
    // Retorna un string a partir de un MD5
    public static String getString(String txt) {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] bytes = decoder.decode(txt);
        return new String(bytes);
    }
 

}
