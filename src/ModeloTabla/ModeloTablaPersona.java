package ModeloTabla;

import Entidades.Sesion;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author NICOLAS RM
 */
public class ModeloTablaPersona extends AbstractTableModel {

    String[] columnas = {"Nombre", "Apellido Paterno", "Apellido Materno"};
    public List<Sesion> personas = new ArrayList<>();

    public ModeloTablaPersona(List<Sesion> personas) {
        this.personas = personas;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    @Override
    public int getRowCount() {
        return personas.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object resp = null;
        if (columnIndex == 0) {
            resp = personas.get(rowIndex).getPass();
        } else {
            if (columnIndex == 1) {
                resp = personas.get(rowIndex).getPass();
            } else {
                resp = personas.get(rowIndex).getPass();
            }
        }
        return resp;
    }

    public Sesion DamePersona(int fila) {
        return personas.get(fila);
    }
}
