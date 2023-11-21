package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class card_trick {

    public static int count(int N) {
        Queue<Integer> cards = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for (int i = 1; i <= 51; i++) {
            cards.add(i);
        }

        while (!cards.element().equals(N)) {

            for (int i = 0; i < 7; i++) {
                stack.push(cards.poll());
            }

            for (int i = 0; i < 7; i++) {
                cards.add(stack.pop());
                cards.add(cards.poll());
            }

            count++;
        }

        return count;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
        System.out.println(count(Integer.parseInt(br.readLine())));
    }
}