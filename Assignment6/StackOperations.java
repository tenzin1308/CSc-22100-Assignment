/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment6;

/**
 *
 * @author tenzintashi
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


/**
 * A set of tools which operate on a Stack
 */
public class StackOperations {

    /**
     * Uses Java's streams to generate a Queue object from an existing Stack object in the same order.
     * Use the LinkedLists class since it implements the Queue interface
     *
     * @param stackOriginal the stack to be converted to a Queue
     * @return a queue containing all the elements of the original Stack in the same order
     */
    public static Queue<Character> toQueue(Stack<Character> stackOriginal) {
        Queue<Character> newQueue = stackOriginal.stream()
                                                .collect(Collectors.toCollection(LinkedList::new));
        return newQueue;
    }

    /**
     * Uses Java's streams to generate a new Stack object from an existing Stack object but in reversed order.
     * The original stack's becomes empty after copied over
     *
     * @param stackOriginal the stack to be reversed
     * @return a new stack containing the same items from the original Stack
     */
    public static Stack<Character> reverseStack(Stack<Character> stackOriginal) {
        Stack<Character> streamReverse = new Stack<>();
        stackOriginal.stream().forEach(x -> {
            streamReverse.add(0, x);
        });
        return streamReverse;

    }

    /**
     * Uses Java's streams to sum all items between the star and end positions inclusive.
     * Account for invalid ranges such as endPosition < startPosition or large ranges
     *
     * @param stackOriginal the stack with the items to sum
     * @param startPosition the position of the starting element in the sum (included)
     * @param endPosition   the position of the end element in the sum (included)
     * @return the sum of all items between the star and end positions inclusive. The method returns -1 if the sum range is invalid
     */
    public static int sumBetween(Stack<Integer> stackOriginal, int startPosition, int endPosition) {
        if (startPosition > endPosition || startPosition > stackOriginal.size()) {
            return -1;
        }
        return stackOriginal.stream()
                            .filter(x -> (stackOriginal.indexOf(x) + 1) >= startPosition && (stackOriginal.indexOf(x) + 1) <= endPosition)
                            .mapToInt(x -> x)
                            .sum();
        
        
    }

    /**
     * Uses Java's streams to read the characters from InputFile.txt one character at a time.
     * If the character read is a number, it is added to a Stack. Otherwise, the character is simply discarded.
     * In case of an Exception, simply print the stack trace which will cause the method to stop the read process and return.
     * <p>
     * Here is an example which filters the characters from a String
     *
     * <pre>   {@code
     *
     * String line = "abc0123!@#$";
     *   line.chars()
     *       .mapToObj(i -> (char) i)
     *       .forEach(c -> System.out.println(c));
     *
     * }</pre> </p>
     *
     * @param filePath the input file containing alpha-numeric characters
     * @return a stack containing numeric characters only
     */
    public static Stack<Character> readNumericFromFile(final String filePath) {
        Stack<Character> numStack= new Stack<>();
        try{
          String content = Files.lines(Paths.get(filePath))
                            .collect(Collectors.joining(System.lineSeparator()));
          content.chars()
            .mapToObj(i -> (char) i)
            .filter(x -> Character.isDigit(x))
            .forEach(x -> {
                numStack.push(x);
            });
          }catch(IOException ex){
              System.out.println("Exception "+ ex);
        }
        return numStack;
    }
}