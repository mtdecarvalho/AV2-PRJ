/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Carvalho
 */
public class itemVenda {
    private int codigo, preco, qtdVendida;
    private double precoTotal;
    
    // para calcular o preco total, pegar o preco individual do preco e multiplicar pela qtdvendida
    
    public int getCodigo()                                  { return codigo; }
    public int getPreco()                                   { return preco; }  
    public int qtdVendida()                                 { return qtdVendida; }
    public double getPrecoTotal()                           { return precoTotal; }
    
    public void setCodigo( int codigo )                     { this. codigo = codigo; }
    public void setQtdVendida( int qtdVendida )             { this.qtdVendida = qtdVendida; }
    public void setPreco( int preco )                       { this.preco = preco; }
    public void setPrecoTotal( double precoTotal )          { this.precoTotal = precoTotal; } 
}
