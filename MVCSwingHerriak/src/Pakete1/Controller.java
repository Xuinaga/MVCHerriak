/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pakete1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author suinaga.jon
 */
public class Controller implements ActionListener {

    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        
        view.nireTaula.nireDatuak=model.arrayListaBete();
        view.nireTaula.fireTableDataChanged();
        anadirActionListener(this);
    }

    private void anadirActionListener(ActionListener listener) {
        view.jButtonGehitu.addActionListener(listener);
        view.jButtonEzabatu.addActionListener(listener);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        //listenerrak entzun dezakeen eragiketa bakoitzeko. Konponenteek 'actionCommad' propietatea daukate
        Herria h = new Herria(view.jTextField1.getText(),view.jComboBox1.getSelectedItem().toString(),view.jCheckBox1.isSelected(), view.jTextArea1.getText());
        switch (actionCommand) {
            case "Herria gehitu":
                model.gehitu(h);
                view.jTable1.setModel(new TableModela());
                break;
            case "Herria ezabatu":
                model.ezabatu();
                view.jTable1.setModel(new TableModela());
                break;
            default:
                System.out.println("???");
        }
        
    }
}
