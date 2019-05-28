///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Encriptacion;
//
//import javax.swing.JOptionPane;
//import org.apache.commons.codec.digest.DigestUtils;
//
///**
// *
// * @author NICOLAS RM
// */
//public class Encriptacion {
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        // TODO code application logic here
//        String passDefault = "1234a0";
//        String passDinamic = JOptionPane.showInputDialog("INSERTE UNA CONTRASEÑA");
//
//        if (passDefault.equals(passDinamic)) {
//            JOptionPane.showMessageDialog(null, "CONTRASEÑA CORRECTA");
//            JOptionPane.showMessageDialog(null, "ENCRIPTANDO CONTRASEÑA");
//            String encriptacion = DigestUtils.sha512Hex(passDinamic);
//            JOptionPane.showMessageDialog(null, "CONTRASEÑA ENCRIPTADA CON EXITO");
//            JOptionPane.showMessageDialog(null, "CONTRASEÑA : " + encriptacion);
//
//        } else {
//            JOptionPane.showMessageDialog(null, "CONTRASEÑA INCORRECTA");
//        }
//    }
//
//}
