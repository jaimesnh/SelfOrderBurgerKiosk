/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package screens;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.CommunicationException;
import manager.Context;
import manager.SimpleKiosk;
import products.Order;
import urjc.UrjcBankServer;

/**
 *
 * @author jaime
 */
public class PurcheaseScreen implements KioskScreen{

    @Override
    public KioskScreen show(Context c) {
        SimpleKiosk kiosk = c.getKiosk();
        Order order = c.getOrder();
        
        kiosk.setMenuMode();
        kiosk.clearScreen();
        configureScreenButtons(kiosk, order);

        char event = kiosk.waitEvent(30);

        switch (event) {
            case 'A':
                return new OrderScreen();
            case 'B':
                return new WelcomeScreen();
            case '1': 
                
                UrjcBankServer bank = new UrjcBankServer();
                kiosk.retainCreditCard(false);
                long cardNumber = kiosk.getCardNumber();
                
                
                if (bank.comunicationAvaiable()) {
                  
            try {
                if (bank.doOperation(cardNumber, order.getTotalAmount())) {
                    kiosk.setMessageMode();
                    kiosk.setTitle("Proceso de pago exitoso");
                    kiosk.setDescription("Ya puedes recoger tu tarjeta\nTu número de pedido es 33\nRecoge el ticket\nTe rogamos que permanezcas atento a las pantallas");
                        
                    int orderNumber = this.incrementOrderNumber(c.getKioskNumber());
                    List ticket = order.getTicket();
                    ticket.add("Número de pedido: " + Integer.toString(orderNumber));
                    kiosk.print(ticket);
                    this.writerOrderToFile(orderNumber, ticket);
                    
                    if (kiosk.expelCreditCard(30)) {
                        return new WelcomeScreen();
                    } 
                } 
                else {
                    kiosk.setMessageMode();
                    kiosk.setTitle("Problemas en el proceso de pago");
                    kiosk.setDescription("El banco dice que no tienes dinero. Prueba con otra tarjeta.");
                    return new OrderScreen();
                }
            } catch (CommunicationException ex) {
                kiosk.setMessageMode();
                kiosk.setTitle("Problemas de comunicación en el proceso de pago");
                kiosk.setDescription("Reintentando");
            }
                }
                else {
                    return (KioskScreen) this;
                }
            default: {
                return this;
            }
        }
    }
    
    private void configureScreenButtons(SimpleKiosk kiosk, Order order) {
        kiosk.setMessageMode();
        kiosk.setTitle("Introduce la tarjeta de crédito");
        kiosk.setDescription(order.getOrderText() + "\n" + "Total: " + order.getTotalAmount()/100.0 + " €" + "\n" + "Introduce la tarjeta de crédito para confirmar el pedido o pulsa alguno de los botones inferiores");
        kiosk.setOption('A', "Cancelar pago");
        kiosk.setOption('B', "Cancelar pedido");
    }
        
    public int incrementOrderNumber(int KioskNumber) {
        int orderNumber = 0;
        String ORDER_FILE = "order_number.txt";
        File orderFile = new File(ORDER_FILE);

        try {
            try (BufferedReader reader = new BufferedReader(new FileReader(orderFile))) {
                String line = reader.readLine();
                if (line != null && line.matches("\\d+")) {
                    orderNumber = Integer.parseInt(line);
                } else {
                    System.err.println("Error: El contenido del archivo no es un número válido.");
                    orderNumber = 1;
                }
            }

            long lastModified = orderFile.lastModified();
            Calendar lastModifiedCalendar = Calendar.getInstance();
            lastModifiedCalendar.setTimeInMillis(lastModified);

            Calendar currentCalendar = Calendar.getInstance();

            if (lastModifiedCalendar.get(Calendar.HOUR_OF_DAY) < 5 && 
                currentCalendar.get(Calendar.HOUR_OF_DAY) >= 5 &&
                lastModifiedCalendar.get(Calendar.DAY_OF_YEAR) != currentCalendar.get(Calendar.DAY_OF_YEAR)) {
                orderNumber = 1;
            }
        } catch (IOException e) {
            System.err.println("Error al manejar el archivo de número de pedido: " + e.getMessage());
            orderNumber = 1;
        }
        
        orderNumber += KioskNumber;
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ORDER_FILE))) {
            writer.write(Integer.toString(orderNumber));
        } catch (IOException e) {
            System.err.println("Error escribiendo el nuevo número de pedido: " + e.getMessage());
        }

        return orderNumber;
    }   
    
    public void writerOrderToFile(int orderNumber, List<String> order) {

        File orderFile = new File("data/", "order" + orderNumber + ".txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(orderFile))) {
            for (String line : order) {
                writer.write(line);
                writer.newLine();
            }

        }   catch (IOException ex) {
                Logger.getLogger(PurcheaseScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

}
