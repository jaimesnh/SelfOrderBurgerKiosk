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
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        Order order = (Order) c.getOrder();
        
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
                int cardNumber = (int) kiosk.getCardNumber();
                
                if (bank.comunicationAvaiable()) {
            try {
                if (bank.doOperation(cardNumber, order.getTotalAmount())) {
                    int kioskNumber = c.getKioskNumber();
                    int orderNumber = incrementOrderNumber(kioskNumber);
                    this.writerOrderToFile(order, kioskNumber);
                    kiosk.print(order.getTicket());
                    if (kiosk.expelCreditCard(30)) {
                        return new WelcomeScreen();
                    }
                }
                else {
                    return (KioskScreen) this;
                }
            } catch (CommunicationException | IOException ex) {
                Logger.getLogger(PurcheaseScreen.class.getName()).log(Level.SEVERE, null, ex);
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
        kiosk.setTitle("Introduce la tarjeta de crédito");
        kiosk.setDescription(order.getOrderText() + "\n" + "Total: " + order.getTotalAmount()/100 + "\n" + "Introduce la tarjeta de crédito para confirmar el pedido o pulsa alguno de los botones inferiores");
        kiosk.setOption('A', "Cancelar pago");
        kiosk.setOption('B', "Cancelar pedido");
    }
        
    public int incrementOrderNumber(int kioskNumber) {
        int orderNumber = 0;
        String ORDER_FILE = "data/order_file.txt";
        // Leer el último número de pedido desde el disco
        try (BufferedReader reader = new BufferedReader(new FileReader(ORDER_FILE))) {
            orderNumber = Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error leyendo el número de pedido: " + e.getMessage());
        }

        // Incrementar el número de pedido
        orderNumber += kioskNumber;

        // Escribir el nuevo número de pedido en el disco
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ORDER_FILE))) {
            writer.write(Integer.toString(orderNumber));
        } catch (IOException e) {
            System.err.println("Error escribiendo el número de pedido: " + e.getMessage());
        }

        return orderNumber;
    }

    public void writerOrderToFile(Order order, int kioskNumber) throws IOException {
  
        String ORDER_FILE = "data/order_file.txt";
        String LOCK_FILE = "order_file.lock";
        Files.createFile(Paths.get(LOCK_FILE));

        File orderFile = new File(ORDER_FILE);
        long lastModified = orderFile.lastModified();

        // Verificar si el archivo debe reiniciarse
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH");
        int lastModifiedHour = Integer.parseInt(dateFormat.format(new Date(lastModified)));
        int currentHour = Integer.parseInt(dateFormat.format(new Date()));

        if (lastModifiedHour < 5 && currentHour >= 5) {
            // Renombrar el archivo actual con la fecha
            String dateSuffix = new SimpleDateFormat("yyyyMMdd").format(new Date());
            File renamedFile = new File("order_file_" + dateSuffix + ".txt");
            orderFile.renameTo(renamedFile);

            // Crear un nuevo archivo de pedidos
            orderFile = new File(ORDER_FILE);
            try {
                orderFile.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(PurcheaseScreen.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Inicializar el número de pedido
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(orderFile))) {
                writer.write(Integer.toString(kioskNumber));
            }
        }

        // Escribir el pedido en el archivo actual
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ORDER_FILE, true))) {
            writer.write(order.getOrderText());
            writer.newLine();
            writer.write(order.getTotalAmount());
        }
    }
        
}
