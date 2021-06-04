/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmc.esiii.cadcliente.dominio;

/**
 *
 * @author RodrigoRochaSilva
 */
public class Dependente extends Pessoa{
    private TipoParentesco parentesco;
    
    public Dependente(String nome, TipoParentesco parentesco){
    	this.nome = nome;
        this.parentesco = parentesco;               
    }
    public Dependente(){}    
    
     
    
    public TipoParentesco getParentesco() {
		return parentesco;
	}
	public void setParentesco(TipoParentesco parentesco) {
		this.parentesco = parentesco;
	}
	
	
    
}
