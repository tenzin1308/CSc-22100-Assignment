/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3;

import java.util.Date;

/**
 *
 * @author tenzintashi
 */
public class LogEntry {
    
    /**
     * Private final variables of String datatype to hold the respective data from the network log file.
     */
    private final String sequence;
    private final String packetSize;
    private final String dateTime;
    private final String sourceIP;
    private final String destinationIP;
    private final String protocol;
    private final String comment;
    
    /**
     * Non Default Constructor that takes 7 parameters and set the value of 
     * member variables to the respective parameters.
     * This Constructor also checks for the validation of each data and handles 
     * the exception.
     * @param sequence A variable of a String data type that hold the value of Sequence from the log file
     * @param dateTime A variable of a String data type that hold the value of Date and Time from the log file
     * @param sourceIP A variable of a String data type that hold the value of Source IP Address from the log file
     * @param destinationIP A variable of a String data type that hold the value of Destination IP Address from the log file
     * @param protocol A variable of a String data type that hold the value of Protocol from the log file
     * @param packetSize A variable of a String data type that hold the value of Packet Size from the log file
     * @param comment A variable of a String data type that hold the value of Comment from the log file
     * @throws InstantiationException If it finds any error in validating the data.
     */
    public LogEntry(String sequence,String dateTime,String sourceIP,
            String destinationIP,String protocol,String packetSize, 
            String comment) throws InstantiationException{
        int intSequence;
        int intPacketSize;
        try {
            intSequence = Integer.parseInt(sequence);
            intPacketSize = Integer.parseInt(packetSize);
        }catch(NumberFormatException ex){
            throw new InstantiationException("One or more values are invalid");
        }
        if ((intSequence < 1 || intSequence > Integer.MAX_VALUE) || 
                (dateTime.length() != 19) || 
                (sourceIP.isEmpty() || sourceIP == null) || 
                (destinationIP.isEmpty() || destinationIP == null) || 
                (!(protocol.equalsIgnoreCase("TCP") || protocol.equalsIgnoreCase("UDP"))) ||
                (intPacketSize < 1 || intPacketSize > 1500)){
            throw new InstantiationException("One or more values are invalid");
        }
        
        this.sequence = sequence;
        this.dateTime = dateTime;
        this.sourceIP = sourceIP;
        this.destinationIP = destinationIP;
        this.protocol = protocol;
        this.packetSize = packetSize;
        this.comment = comment;

    }

    /**
     * Gets the value of Sequence
     * @return A String representing the sequence value
     */
    public String getSequence(){
        return this.sequence;
    }

    /**
     * Gets the value of Date and Time
     * @return A String representing the date and time value
     */
    public String getDateTime(){
        return this.dateTime;
    }

    /**
     * Gets the value of Source IP Address
     * @return A String representing the Source IP Address
     */
    public String getSourceIP(){
        return this.sourceIP;
    }

    /**
     * Gets the value of Destination IP Address
     * @return A String representing the Destination IP Address
     */
    public String getDestinationIP(){
        return this.destinationIP;
    }

    /**
     * Gets the value of Protocol
     * @return A String representing the Protocol value
     */
    public String getProtocol(){
        return this.protocol;
    }

    /**
     * Gets the value of Comment
     * @return A String representing the Comment value
     */
    public String getComment(){
        return this.comment;
    }

    /**
     * Gets the value of Packet Size
     * @return A String representing the Packet Size
     */
    public String getPacketSize(){
        return this.packetSize;
    }
    
    /**
     * Gets the value of Date and Time in the format of Date
     * @return A Date object representing the Date and Time
     */
    public Date getDateTimeAsDate(){
        return new Date(this.dateTime);
        
    }
    
    /**
     * 
     * @return A String formated object
     */
    public String toString(){
        return String.format("%s,%s,%s,%s,%s,%s,%s", this.sequence,this.dateTime,this.sourceIP,this.destinationIP,this.protocol,this.packetSize,this.comment);
    }
    
    
}
