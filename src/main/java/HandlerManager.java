import Factory.HandlerFactory;
import Factory.HandlerTypes;
import Factory.IHandler;
import Model.Article;
import Model.Customer;
import Model.Order;

import java.io.InvalidObjectException;
import java.util.Scanner;

public class HandlerManager {
    private static Scanner in = new Scanner(System.in);

    //Main Process
    public static void runMain() throws InvalidObjectException {

        System.out.println("Choose which Entity:\nCustomer(1)\nArticle(2)\nOrder(3)");
        String entityOutput = in.nextLine();
        IHandler handler = null;
        HandlerTypes type = null;

        //get handler & type from console input
        if(entityOutput.equals("1")) {handler = HandlerFactory.getHandler(HandlerTypes.Customer); type = HandlerTypes.Customer;}
        else if(entityOutput.equals("2")){handler = HandlerFactory.getHandler(HandlerTypes.Article); type = HandlerTypes.Article;}
        else if(entityOutput.equals("3")){handler = HandlerFactory.getHandler(HandlerTypes.Order); type = HandlerTypes.Order;}
        else {System.out.println("wrong number");}

        //chosse call type

        switch (chooseCallType()){
            case "1": //Get all Data ID's
                getAllData(handler);
                break;

            case "2": //Get Data by ID
                getDataByID(handler);
                break;

            case "3": //Post Data
                postUpdateData(handler,type,false);
                break;

            case "4": //Update Data
                postUpdateData(handler,type,true);
                break;

            case "5": //Delete Data
                deleteData(handler);
                break;

            default:
                throw new InvalidObjectException("wrong number");

        }

    }

    //Console UI Functions
    private static String chooseCallType(){
        System.out.println("choose the method\nGET (1)" +
                           "\nGET by ID (2)"            +
                           "\nPOST (3)"                 +
                           "\nUPDATE (4)"               +
                           "\nDELETE (5)");

        return in.nextLine();
    }

    //Call Functions
    private static void getAllData(IHandler handler){
        String listData[] = handler.getAll();
        System.out.println("All ID's:");

        for(String data : listData){
            System.out.println(data);
        }
    }

    private static void getDataByID(IHandler handler){
        System.out.println("ID: ");
        String ID = in.nextLine();
        System.out.println(handler.getByID(ID));
    }

    private static void postUpdateData(IHandler handler, HandlerTypes types, Boolean updateCall){

        switch (types){
            case Article:
                System.out.println("Add the following data:");

                System.out.println("Articlenumber");
                String number = in.nextLine();

                System.out.println("Description");
                String description = in.nextLine();

                System.out.println("Price");
                String price = in.nextLine();

                Article article = new Article(number,description,Integer.parseInt(price));

                //update data
                if(updateCall.equals(true)){System.out.println(handler.updateData(article)); break;}

                //post data
                System.out.println(handler.postData(article));
                break;

            case Customer:
                System.out.println("Add the following data:");

                System.out.println("User ID");
                String userId = in.nextLine();

                System.out.println("Forename");
                String forename = in.nextLine();

                System.out.println("Surename");
                String surename = in.nextLine();

                System.out.println("Birthday");
                String birthday = in.nextLine();

                System.out.println("City");
                String city = in.nextLine();

                System.out.println("Code");
                String code = in.nextLine();

                System.out.println("Street");
                String street = in.nextLine();

                System.out.println("Housenumber");
                String housenumber = in.nextLine();

                System.out.println("E-Mail");
                String email = in.nextLine();

                System.out.println("Telephone");
                String telephone = in.nextLine();

                Customer customer = new Customer(userId,forename,surename,birthday,city,code,street,housenumber,email,telephone);

                //update data
                if(updateCall.equals(true)){System.out.println(handler.updateData(customer)); break;}

                //post data
                System.out.println(handler.postData(customer));
                break;

            case Order:
                System.out.println("Add the following data:");

                System.out.println("Ordernumber");
                String ordernumber = in.nextLine();

                System.out.println("Orderdate");
                String orderdate = in.nextLine();

                System.out.println("User ID");
                String userID = in.nextLine();

                System.out.println("Article ID");
                String articleID = in.nextLine();

                Order order = new Order(orderdate,ordernumber,userID,articleID);

                //update data
                if(updateCall.equals(true)){System.out.println(handler.updateData(order)); break;}

                //post data
                System.out.println(handler.postData(order));
                break;
        }
    }

    private static void deleteData(IHandler handler){
        System.out.println("Add the ID to delete:");
        String ID = in.nextLine();
        System.out.println(handler.deleteData(ID));
    }
}