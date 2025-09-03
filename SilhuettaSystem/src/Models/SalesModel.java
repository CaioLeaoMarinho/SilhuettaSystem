/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author caiol
 */
public class SalesModel {
    private int ID;
    private String client_name;
    private String client_CPF;
    private String date;
    private double total;
    private double cash;
    private double debit;
    private double pix;
    private double link;
    private double credit;
    private int installments;
    private String client_address;
    private String client_address_ref;
    private String obs;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getClient_CPF() {
        return client_CPF;
    }

    public void setClient_CPF(String client_CPF) {
        this.client_CPF = client_CPF;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public double getPix() {
        return pix;
    }

    public void setPix(double pix) {
        this.pix = pix;
    }

    public double getLink() {
        return link;
    }

    public void setLink(double link) {
        this.link = link;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public int getInstallments() {
        return installments;
    }

    public void setInstallments(int installments) {
        this.installments = installments;
    }

    public String getClient_address() {
        return client_address;
    }

    public void setClient_address(String client_address) {
        this.client_address = client_address;
    }

    public String getClient_address_ref() {
        return client_address_ref;
    }

    public void setClient_address_ref(String client_address_ref) {
        this.client_address_ref = client_address_ref;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    
}
