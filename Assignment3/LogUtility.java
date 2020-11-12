/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
/**
 *
 * @author tenzintashi
 */

public class LogUtility {
    
    /**
     * Private final class field of ArrayList data type of 
     */
    private final ArrayList<LogEntry> listLogEntries;

    /**
     * A private enumerator with all the name of the getter methods used for the 
     * find first common method.
     */
    private enum firstCommonOperation{
        getSequence,
        getPacketSize,
        getDateTime,
        getSourceIP,
        getDestinationIP,
        getProtocol,
        getComment;
        
    }

    /**
     * A private method that takes two parameter of String and enumerator type and 
     * find the first data from the ArrayList using the appropriate getter from the enumerator. 
     * @param data A String data type that hold the data we are looking for
     * @param operation A enumerator data type that holds the operation
     * @return A LogEntry object if the data is found in the ArrayList else returns null object
     */
    private LogEntry findFirstCommonMethod(String data, firstCommonOperation operation){
        for(LogEntry item: this.listLogEntries) {
            switch(operation){
                case getSequence:
                    if (item.getSequence().compareTo(data) == 0) {
                        return item;
                    }
                case getPacketSize:
                    if (item.getPacketSize().compareTo(data) == 0) {
                        return item;
                    }
                case getDateTime:
                    if (item.getDateTime().compareTo(data) == 0) {
                        return item;
                    }
                case getSourceIP:
                    if (item.getSourceIP().compareTo(data) == 0) {
                        return item;
                    }
                case getDestinationIP:
                    if (item.getDestinationIP().compareTo(data) == 0) {
                        return item;
                    }
                case getProtocol:
                    if (item.getProtocol().compareTo(data) == 0) {
                        return item;
                    }
                case getComment:
                    if (item.getComment().compareTo(data) == 0) {
                        return item;
                    }
            }
            
            
        }
        return null;
    }
    
    
    /**
     * A Default Constructor that initialize the ArrayList of LogEntry type
     */
    public LogUtility(){
        this.listLogEntries = new ArrayList<>();
    }

    /**
     * A public method that reads a file, parse the data, add the data to the ArrayList
     * handles the exception from the LogEntry Class. 
     * @param fileName A String variable that holds the name of a file
     * @return 
     * @throws FileNotFoundException If file with "fileName" cannot be found in the given location.
     */
    public boolean parseFile(String fileName) throws FileNotFoundException{
        try(Scanner fileReader = new Scanner(new File(fileName))) {
            while(fileReader.hasNext()){
                String logLine = fileReader.nextLine();
                String logArr[] = logLine.split(",");
                try{
                    this.listLogEntries.add(new LogEntry(logArr[0], logArr[1], logArr[2], logArr[3], logArr[4], logArr[5], logArr[6]));
            
                }catch(InstantiationException ex){
                    System.out.printf("Skipping line: %s\n", logLine);
                }
            }
        }
        return true;
    }

    /**
     * 
     * @return A String of a message with the number of valid record found
     */
    public String toString(){
        return String.format("LogUtility: there are %d records\n", this.listLogEntries.size());
    }
    
    /**
     * A member function that finds all the records from the valid input between given dates.
     * @param startDateString A String variable that holds the starting date to search from.
     * @param endDateString A String variable that holds the ending date to search from.
     * @return A ArrayList of LogEntry between the given starting and ending date
     * @throws ParseException 
     */
    public ArrayList<LogEntry> getBetween(String startDateString,String endDateString) throws ParseException {
        ArrayList<LogEntry> between = new ArrayList<>();
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date startDate, endDate;
        try{
            startDate = df.parse(startDateString);
            endDate = df.parse(endDateString);
            for(LogEntry item: this.listLogEntries){
                if(startDate.compareTo(item.getDateTimeAsDate()) <=0 && endDate.compareTo(item.getDateTimeAsDate()) >= 0){
                    between.add(item);
                }
            }
        }catch (ParseException ex){
            System.err.println("Can't parse");
        }
        return between;
    }
    
    /**
     * A member function that to find the first LogEntry with the given Sequence number
     * @param id A String variable that holds the Sequence number we are looking for
     * @return A LogEntry object if the data is found on the ArrayList else returns null
     */
    public LogEntry findFirstId(String id){
        return findFirstCommonMethod(id, firstCommonOperation.getSequence);
    }

    /**
     * A member function that to find the first LogEntry with the given Date
     * @param date A String variable that holds the Date we are looking for
     * @return  A LogEntry object if the data is found on the ArrayList else returns null
     */
    public LogEntry findFirstTimestamp(String date){
        return findFirstCommonMethod(date, firstCommonOperation.getDateTime);
    }

    /**
     * A member function that to find the first LogEntry with the given Source IP Address
     * @param sourceIP A String variable that holds the Source IP Address we are looking for
     * @return A LogEntry object if the data is found on the ArrayList else returns null
     */
    public LogEntry findFirstSourceIP(String sourceIP){
        return findFirstCommonMethod(sourceIP, firstCommonOperation.getSourceIP);
    }

    /**
     * A member function that to find the first LogEntry with the given Destination IP Address
     * @param destinationIP A String variable that holds the Destination IP Address we are looking for
     * @return A LogEntry object if the data is found on the ArrayList else returns null
     */
    public LogEntry findFirstDestinationIP(String destinationIP){
        return findFirstCommonMethod(destinationIP, firstCommonOperation.getDestinationIP);
    }

    /**
     * A member function that to find the first LogEntry with the given Protocol
     * @param protocol A String variable that holds the Protocol we are looking for
     * @return A LogEntry object if the data is found on the ArrayList else returns null
     */
    public LogEntry findFirstProtocol(String protocol){
        return findFirstCommonMethod(protocol, firstCommonOperation.getProtocol);
    }

    /**
     * A member function that to find the first LogEntry with the given Packet Size
     * @param packetSize A String variable that holds the Packet Size we are looking for
     * @return A LogEntry object if the data is found on the ArrayList else returns null
     */
    public LogEntry findFirstLength(String packetSize){
        return findFirstCommonMethod(packetSize, firstCommonOperation.getPacketSize);
    }
    
    /**
     * A member function that to find the first LogEntry with the given Comment
     * @param comment A String variable that holds the Comment we are looking for
     * @return A LogEntry object if the data is found on the ArrayList else returns null
     */
    public LogEntry findFirstDescription(String comment){
        return findFirstCommonMethod(comment, firstCommonOperation.getComment);
    }
    
    
    
}
