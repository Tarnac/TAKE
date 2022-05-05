/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Tarnacki
 */
public class Main {
    
    private static final String URL = "http://localhost:8080/Complaints/";
    
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();

        System.out.println("Count: " + getComplaintsCount(client));
        System.out.println("All complaints:\n" + getAllComplaints(client));
        System.out.println("Open complaint with id 604:");
        Complaint openComplaint = getComplaint(client);
        System.out.println(openComplaint);
        
        System.out.println("Close complaint");
        closeComplaint(client, openComplaint);
        
        System.out.println("All open complaints:\n" + getAllOpenComplaints(client));
        

        client.close();
    }
    
    private static String getComplaintsCount(Client client) {
        return client
                .target(URL + "resources/complaints/count")
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);
    }
    
    private static List<Complaint> getAllComplaints(Client client){
        return client
                .target(URL + "resources/complaints")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Complaint>>(){});
    }
    
    
    private static Complaint getComplaint(Client client){
        return client
                .target(URL + "resources/complaints/604")
                .request(MediaType.APPLICATION_JSON)
                .get(Complaint.class);
    }
    
    private static void closeComplaint(Client client, Complaint complaint){
        complaint.setStatus("closed");
        
        client
        .target(URL + "resources/complaints/604")
        .request(MediaType.APPLICATION_JSON)
        .put(Entity.entity(complaint, MediaType.APPLICATION_JSON));
    }
    
    private static List<Complaint> getAllOpenComplaints(Client client){
                return client
                .target(URL + "resources/complaints?status=open")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Complaint>>(){});
    }
    
}
