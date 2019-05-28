/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logico;

import DAO.SesionDao;
import Entidades.Sesion;
import java.util.List;

/**
 *
 * @author NICOLAS RM
 */
public class SesionLog {

    SesionDao pass = new SesionDao();

    public boolean AgregarPass(Sesion per) {
        return pass.AgregarPass(per);
    }

    public boolean UpdateSessionActivo(Sesion per) {
        return pass.UpdateSessionActivo(per);
    }

    public boolean UpdateSessionInactivo(Sesion per) {
        return pass.UpdateSessionInactivo(per);
    }
//
//    public boolean DeletePersona(Sesion per) {
//        return pass.DeletePersona(per);
//    }

    public List<Sesion> listado() {
        return pass.listado();
    }

}
