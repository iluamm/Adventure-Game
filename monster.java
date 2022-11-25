/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author tanaw
 */
public class monster {
    private int hp;
    private int str;
    private int def;
    
    //get method
    public int gethp(){
        return this.hp;
    }
    public int getstr(){
        return this.str;
    }
    public int getdef(){
        return this.def;
    }
    
    //set method
    public void sethp(int hp){
        this.hp=hp;
    }
    public void setstr(int str){
        this.str=str;
    }
    public void setdef(int def){
        this.def=def;
    }
}
