/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo1.rest.response;

import java.io.Serializable;

/**
 *
 * @author .local
 */
public enum ResponseType implements Serializable{
    
    SUCCESS("success", "Operación realizada correctamente"),
    ERROR("error", "Ocurrió un error al realizar la operación solicitada");


    private final String status;
    private final String message;

    ResponseType(String status, String message){
        this.status = status;
        this.message = message;
    }
}
