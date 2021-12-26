/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

/**
 *
 * @author saum
 */
public class Lab5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.addLast(15);
        list.addLast(20);
        list.addLast(35);
        list.addLast(40);
        list.addLast(45);
        list.addLast(50);
        list.addLast(70);
        list.addLast(80);
        list.addLast(99);
        list.addLast(100);
        try {
            list.find(15);
            list.find(200);
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        } finally {
            System.out.println("Final block execution");
        }

    }

}
