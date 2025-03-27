public class CustomStack<T> implements StackInterface<T> {
    // Tracks the top node of the stack and the size of the stack
    private Node<T> top; // Points to the top element of the stack
    private int size;    // Tracks the number of elements in the stack




    // Inner static class to represent a node in the stack
    private static class Node<T> {
        T data;       // Holds the data of this node
        Node<T> next; // Points to the node below this one in the stack

        // Constructor to initialize a node with data
        Node(T data) {
            this.data = data; // Assign the provided data to the node
            this.next = null; // Initially, the next node is null
        }
    }






    // Constructor to initialize an empty stack
    public CustomStack() {
        this.top = null; // The stack is empty, so the top is null
        this.size = 0;   // The initial size of the stack is 0
    }





    /**
     * Adds a new element to the top of the stack (push operation).
     * @param data The data to add to the stack
     * Time Complexity: O(1)
     */




    @Override
    public void push(T data) {
        Node<T> newNode = new Node<>(data); // Create a new node with the provided data
        newNode.next = top; // Link the new node to the current top node
        top = newNode;      // Update the top pointer to the new node
        size++;             // Increment the size of the stack
    }






    /**
     * Removes and returns the element at the top of the stack (pop operation).
     * @return The data of the removed element
     * @throws RuntimeException If the stack is empty
     * Time Complexity: O(1)
     */



    @Override
    public T pop() {
        if (isEmpty()) { // Check if the stack is empty
            throw new RuntimeException("Stack is empty"); // Throw an exception if there's nothing to pop
        }
        T data = top.data; // Get the data from the top node
        top = top.next;    // Move the top pointer to the next node in the stack
        size--;            // Decrease the size of the stack
        return data;       // Return the data of the removed node
    }





    /**
     * Returns the element at the top of the stack without removing it (peek operation).
     * @return The data of the top element
     * @throws RuntimeException If the stack is empty
     * Time Complexity: O(1)
     */




    @Override
    public T peek() {
        if (isEmpty()) { // Check if the stack is empty
            throw new RuntimeException("Stack is empty"); // Throw an exception if there's nothing to peek at
        }
        return top.data; // Return the data of the top node
    }




    /**
     * Checks if the stack is empty.
     * @return True if the stack is empty, false otherwise
     * Time Complexity: O(1)
     */




    @Override
    public boolean isEmpty() {
        return top == null; // The stack is empty if the top node is null
    }




    /**
     * Returns the size of the stack.
     * @return The number of elements in the stack
     * Time Complexity: O(1)
     */



    @Override
    public int size() {
        return size; // Return the current size of the stack
    }
}
