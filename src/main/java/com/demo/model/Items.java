package com.demo.model;

public class Items {

    private String label;
    private String routerLink;
    
    public Items(String label, String routerLink) {
	this.label = label;
	this.routerLink = routerLink;
    }
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public String getRouterLink() {
        return routerLink;
    }
    public void setRouterLink(String routerLink) {
        this.routerLink = routerLink;
    }
    
    

}
