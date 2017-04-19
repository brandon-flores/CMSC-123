/*
 * To change this license header, choose License Headers in Project Properatoratortiestack.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

import java.lang.Math;
import java.util.*;

/**
 *
 * @author chromalix
 */
public class ExpressionTree {

    static Stack<String> stack = new Stack<String>();

    public static int eval(MyTreeNode root) {
        if (root.getLeft() == null && root.getRight() == null) {
            stack.push(root.getData());
        } else {
            eval(root.getRight());
            eval(root.getLeft());
            stack.push(root.getData());
            String operator = stack.pop();
            if (null != operator) {
                switch (operator) {
                    case "+":
                        stack.push(String.valueOf((Integer.parseInt(stack.pop()) + Integer.parseInt(stack.pop()))));
                        break;
                    case "-":
                        stack.push(String.valueOf((Integer.parseInt(stack.pop()) - Integer.parseInt(stack.pop()))));
                        break;
                    case "*":
                        stack.push(String.valueOf((Integer.parseInt(stack.pop()) * Integer.parseInt(stack.pop()))));
                        break;
                    case "/":
                        stack.push(String.valueOf((Integer.parseInt(stack.pop()) / Integer.parseInt(stack.pop()))));
                        break;
                    case "^":
                        stack.push(String.valueOf((int) Math.pow(Integer.parseInt(stack.pop()), Integer.parseInt(stack.pop()))));
                        break;
                    default:
                        break;
                }
            }
        }
        return Integer.parseInt(stack.peek());
    }
}
