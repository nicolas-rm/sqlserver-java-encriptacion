/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Sesion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author NICOLAS RM
 */
public class SesionDao {

    Conexion conexion = new Conexion();

    public boolean AgregarPass(Sesion session) {
        Connection con = null;
        CallableStatement cstm = null;
        boolean resp = true;
        try {
            con = conexion.getConecion();
            con.setAutoCommit(false);
            cstm = con.prepareCall("{Call ENCRIPT(?,?,?)}");
            cstm.setString(1, session.getUser());
            System.out.println("USER: "+session.getUser());
            cstm.setString(2, DigestUtils.sha512Hex(session.getPass()));
            System.out.println("CONTRASEÑA : " + DigestUtils.sha512Hex(session.getPass()));
            cstm.setString(3, session.getStatus());
            System.out.println("ESTATUS : "+session.getStatus());
//            cstm.setString(3, per.getApellidoM());
            resp = cstm.execute();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.Cerrar1(con, cstm);
        }
        return resp;
    }

    public boolean UpdateSessionActivo(Sesion per) {
        Connection con = null;
        CallableStatement cstm = null;
        boolean resp = true;
        try {
            con = conexion.getConecion();
            con.setAutoCommit(false);
            cstm = con.prepareCall("{Call UpdateSessionActivo(?,?,?)}");
            System.out.println("USER : UPDATE : "+per.getUser());
            System.out.println("PASS : UPDATE : "+per.getPass());
            System.out.println("ESTATUS : UPDATE : "+per.getStatus());
            cstm.setString(1, per.getUser());
            cstm.setString(2, per.getPass());
            cstm.setString(3, per.getStatus());
//            cstm.setInt(4, per.getIdpers());
            resp = cstm.execute();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar1(con, cstm);
        }
        return resp;
    }
    public boolean UpdateSessionInactivo(Sesion per) {
        Connection con = null;
        CallableStatement cstm = null;
        boolean resp = true;
        try {
            con = conexion.getConecion();
            con.setAutoCommit(false);
            cstm = con.prepareCall("{Call UpdateSessionInactivo(?,?,?)}");
            cstm.setString(1, per.getUser());
            cstm.setString(2, per.getPass());   
            cstm.setString(3, per.getStatus());
//            cstm.setInt(4, per.getIdpers());
//            System.out.println("USER : UPDATE : "+per.getUser());
//            System.out.println("PASS : UPDATE : "+per.getPass());
//            System.out.println("ESTATUS : UPDATE : "+per.getStatus());
            resp = cstm.execute();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar1(con, cstm);
        }
        return resp;
    }
//    public boolean DeletePersona(Sesion per) {
//        Connection con = null;
//        CallableStatement cstm = null;
//        boolean resp = true;
//        try {
//            con = conexion.getConecion();
//            con.setAutoCommit(false);
//            cstm = con.prepareCall("{Call DeletePersona(?)}");
//            cstm.setInt(1, per.getIdpers());
//            resp = cstm.execute();
//            con.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally{
//            conexion.Cerrar1(con, cstm);
//        }
//        return resp;
//    }
    public List<Sesion> listado() {
        Connection con = null;
        CallableStatement cstm = null;
        ResultSet rs = null;
        List<Sesion> lista = null;
        try {
            lista = new ArrayList<>();
            con = conexion.getConecion();
            cstm = con.prepareCall("{Call Listar}");
            rs = cstm.executeQuery();
            Sesion session = null;
            while (rs.next()) {
                session = new Sesion();
                session.setUser(rs.getString("USUARIO"));
                session.setPass(rs.getString("PASS"));
                session.setStatus(rs.getString("ESTATUS"));
//                per.setApellidoM(rs.getString("apellidoM"));
                lista.add(session);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar2(cstm, rs);
        }
        return lista;
    }
}
