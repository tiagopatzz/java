package br.univates.exemplo3.apresentacao;

import br.univates.exemplo3.negocio.Historico;
import br.univates.exemplo3.negocio.Retangulo;
import br.univates.raiz.Horario;
import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class HistoricoDataModel implements TableModel
{
    private ArrayList<Historico> vetor;

    public HistoricoDataModel(ArrayList<Historico> vetor)
    {
        this.vetor = vetor;
    }

    @Override
    public int getRowCount()
    {
        return vetor.size();
    }

    @Override
    public int getColumnCount()
    {
        return 5;
    }

    @Override
    public String getColumnName(int columnIndex)
    {
        String[] colName = { "Data", "Horário", "Base", "Altura", "Área" };
        return colName[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        Historico historico = vetor.get(rowIndex);
        Retangulo r = historico.getRetangulo();
        
        String[] aux = { historico.getData().toString(),
                         historico.getHorario().getHorario( Horario.HHMMSS ),
                         r.getBase()+"",
                         r.getAltura()+"",
                         r.getArea()+"" };

        return aux[columnIndex];
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    {
        
    }

    @Override
    public void addTableModelListener(TableModelListener l)
    {
        
    }

    @Override
    public void removeTableModelListener(TableModelListener l)
    {
        
    }
    
}
