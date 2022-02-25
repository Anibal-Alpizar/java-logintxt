/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compraautos;

import javax.swing.JOptionPane;

/**
 *
 * @author anibal
 */
public class Usuario {
    
    
    String mensaje; //se usara para mostrar un mensaje personalizado al usuario dependiendo de los intentos 
    frmLogin frmlogin = new frmLogin(); //creamos una instancia de la ventana y la usuaramos para pasar por parametros los intentos

    public void validarUsuario(String usuarios[], String user, String pwd, int intentos) {  //metodo con parametros (array para almacenar los usuario del archivo)
        boolean encontrado = false; //usaremos esta variable para saber si hay un usuario o no
        for (int i = 0; i < usuarios.length; i++) { //recorremos el array con los usuario, UNO POR UNO
            if ((usuarios[i].equalsIgnoreCase(user) && usuarios[i + 1].equals(pwd))) {  //IMPORTANTE: Username -> numeros pares, Password -> numeros impares
                //si el usuario y contrasegna estan bien, vas hacer lo siguiente:
                mensaje = "Bienvenido " + user;
                encontrado = true;  //ponemos la variable en true, porque si se encontro un usuario 
                JOptionPane.showMessageDialog(null, mensaje, " Inicio de SesiÃ³n ", JOptionPane.INFORMATION_MESSAGE);
                intentos = 0;       //reseteamos los intentos en 0, en el caso de que ya tuviera intentos previamente
                frmlogin.intentos_registrados(intentos); //le mandamos los intentos al metodo que esta en el login
                break;          //break = termine la ejecuacion aqui, no continue mas.      
            }
        }
        if (encontrado == false) {  //en el caso de que encontrado sea false, osea, no encontro, vas hacer lo siguiente
            mensaje = "clave y/o usuarios erroresones van" + intentos + " intentos fallidos";
            JOptionPane.showMessageDialog(null, mensaje, " inicio de sesion ", JOptionPane.ERROR_MESSAGE);
        }
        if (intentos > 2) {     //si los intentos superan 2, vas hacer la aplicacion, **OPCIONAL**
            JOptionPane.showMessageDialog(null, "3 intentos fallidos, esto se serrarÃ¡", " Inicio de SesiÃ³n ", JOptionPane.ERROR_MESSAGE);
            System.exit(0);

        }
    }
    
    
}
