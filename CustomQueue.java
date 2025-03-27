public class CustomQueue<T> implements QueueInterface<T> {
    // Tracks the front and rear nodes of the queue and its size
    private Node<T> front, rear; // Front points to the first element, rear points to the last
    private int size; // Stores the number of elements in the queue





    // Inner static class to represent a node in the queue
    private static class Node<T> {
        T data;       // Holds the data for this node
        Node<T> next; // Points to the next node in the queue

        // Constructor to initialize a node with data
        Node(T data) {
            this.data = data; // Set the data for the node
            this.next = null; // Initially, the next node is null
        }
    }







    // Constructor to initialize an empty queue
    public CustomQueue() {
        this.front = null; // The front of the queue is null initially
        this.rear = null;  // The rear of the queue is null initially
        this.size = 0;     // The size of the queue starts at 0
    }



    /**
     * Adds a new element to the rear of the queue.
     * @param data The data to add to the queue
     * Time Complexity: O(1)
     */




    @Override
    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data); // Create a new node with the provided data
        if (rear != null) {
            rear.next = newNode; // Link the current rear node to the new node
        }
        rear = newNode; // Update the rear pointer to the new node
        if (front == null) { // If the queue was empty
            front = rear; // The new node is also the front node
        }
        size++; // Increment the size of the queue
    }






    /**
     * Removes and returns the element at the front of the queue.
     * @return The data of the removed element
     * @throws RuntimeException If the queue is empty
     * Time Complexity: O(1)
     */






    @Override
    public T dequeue() {
        if (isEmpty()) { // Check if the queue is empty
            throw new RuntimeException("Queue is empty"); // Throw an exception if no elements to dequeue
        }
        T data = front.data; // Get the data from the front node
        front = front.next;  // Move the front pointer to the next node
        if (front == null) { // If the queue is now empty
            rear = null; // Set the rear pointer to null as well
        }
        size--; // Decrement the size of the queue
        return data; // Return the data of the removed node
    }






    /**
     * Checks if the queue is empty.
     * @return True if the queue is empty, false otherwise
     * Time Complexity: O(1)
     */



    @Override
    public boolean isEmpty() {
        return front == null; // The queue is empty if the front is null
    }



    /**
     * Returns the size of the queue.
     * @return The number of elements in the queue
     * Time Complexity: O(1)
     */


    @Override
    public int size() {
        return size; // Return the size of the queue
    }
}
