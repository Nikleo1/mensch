/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensch.aerger.dich.nicht.modell;

/**
 *
 * @author Janna
 */
public class SpielerInfo {
    
    private String name;
    private boolean computer;
    private int id;

    public SpielerInfo(int id, String name, boolean computer) {
        this.name = name;
        this.computer = computer;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public boolean isComputer() {
        return computer;
    }

    public int getId() {
        return id;
    }
    
    
    
}
