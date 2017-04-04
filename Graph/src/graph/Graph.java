package graph;

import java.util.ArrayList;

public class Graph<TKey extends Comparable<TKey>, TValue> {

    private Node<TKey, TValue>[] array; // Array to store linkedlist of nodes

    // Constructor which decides the size of the array
    public Graph(int size) {
        array = new Node[size];
    }

    // Inserts a node in the graph
    public void insertNode(TKey key, TValue data) {
        int arrayIndex = getIndex(key);
        if (array[arrayIndex] == null) {
            array[arrayIndex] = new Node(key, data);
        } else {
            array[arrayIndex].insertNode(key, data);
        }
    }

    // Takes two keys(from and to) and the weight of the edge, and inserts the edge at the correct place with the correct weight
    public void insertEdge(TKey from, TKey to, byte weight) {
        Node fromNode = getNode(from);
        Node toNode = getNode(to);

        if (fromNode == null || toNode == null) {
            System.out.println("Node with matching key not found!");
        } else {
            fromNode.insertEdge(fromNode, toNode, weight);
            toNode.insertEdge(toNode, fromNode, weight);
        }
    }

    // Deletes the passed node, and also removes all the edges linked to it
    public void deleteNode(TKey key) {
        int arrayIndex = getIndex(key);
        if (array[arrayIndex] != null) {
            if (array[arrayIndex].getKey() == key) {
                if (array[arrayIndex].getEdges() != null) {
                    array[arrayIndex].getEdges().deleteEdges(array[arrayIndex]);
                }
                array[arrayIndex] = array[arrayIndex].getNextNode();
                return;
            } else if (array[arrayIndex].getNextNode() != null) {
                array[arrayIndex].deleteNode(key);
                return;
            }
        }
        System.out.println("Key not found!");
    }

    // Deletes a single edge
    public void deleteEdge(TKey from, TKey to) {
        Node fromNode = getNode(from);
        Node toNode = getNode(to);

        if (fromNode == null || toNode == null) {
            System.out.println("Node with matching key not found!");
        } else {
            fromNode.deleteEdge(from, toNode);
            toNode.deleteEdge(to, fromNode);
        }
    }

    // Get-function returning the node with the matching key
    private Node<TKey, TValue> getNode(TKey key) {
        int arrayIndex = getIndex(key);
        if (array[arrayIndex] != null) {
            return array[arrayIndex].getNode(key);
        }
        return null;
    }
    
    // Prim'a algorithm for finding the minimal spanning tree from the selected node
    public Graph<TKey, TValue> prim(TKey key) {
        Graph<TKey, TValue> mst = new Graph(this.array.length); // Minimal spanning tree
        ArrayList<Edge<TKey, TValue>> queue = new ArrayList();  // ArrayList for storing edges
        Node<TKey, TValue> n = getNode(key);    // Getting the node with the matching key
        Edge<TKey, TValue> current = n.getEdges();  // Getting edges
        int index;  // Variable used for sorting the ArrayList

        // Adding to queue
        while (current != null) {
            index = 0;
            // Incrementing the index to place the edge at the correct place in the ArrayList relative to the weight
            while (index < queue.size() && current.compareTo(queue.get(index)) > 0) {
                index++;
            }
            // Adding the edge and updating current to the next edge originating from the node
            queue.add(index, new Edge(current.getFrom(), current.getTo(), current.getWeight()));
            current = current.getNextEdge();
        }

        // Adding nodes with edge between them to MST
        mst.insertNode(queue.get(0).getFrom().getKey(), queue.get(0).getFrom().getValue());
        mst.insertNode(queue.get(0).getTo().getKey(), queue.get(0).getTo().getValue());
        mst.insertEdge(queue.get(0).getFrom().getKey(), queue.get(0).getTo().getKey(), queue.get(0).getWeight());
        
        // Doing the same thing for the rest of the nodes until the queue is empty
        while (!queue.isEmpty()) {            
            queue.get(0).getFrom().setVisited(true);    // Sets the node visited after it's added to MST
            
            // Deletes all the visited nodes from queue
            while (!queue.isEmpty() && queue.get(0).getTo().isVisited()) {
                queue.remove(0);
            }
            
            // Updates n, breaks out of the outer while if the queue is empty after deleting visited nodes
            if (!queue.isEmpty()) {
                n = queue.get(0).getTo();
            } else {
                break;
            }
            
            current = n.getEdges(); // Updates current
            
            // Adding to queue
            while (current != null) {
                index = 0;
                while (index < queue.size() && current.compareTo(queue.get(index)) > 0) {
                    index++;
                }
                queue.add(index, new Edge(current.getFrom(), current.getTo(), current.getWeight()));
                current = current.getNextEdge();
            }
            
            // Adding nodes with edge between them to MST
            if (mst.getNode(queue.get(0).getFrom().getKey()) == null) {
                mst.insertNode(queue.get(0).getFrom().getKey(), queue.get(0).getFrom().getValue());
            }
            if (mst.getNode(queue.get(0).getTo().getKey()) == null) {                
                mst.insertNode(queue.get(0).getTo().getKey(), queue.get(0).getTo().getValue());
            }
            mst.insertEdge(queue.get(0).getFrom().getKey(), queue.get(0).getTo().getKey(), queue.get(0).getWeight());
        }
        this.resetVisited();    // Resets the visited variable of all the nodes in the original graph
        return mst; // Returning MST
    }
    
    // Resets the visited variable of all nodes
    public void resetVisited() {
        for (Node n : array) {
            if (n != null) {
                n.resetVisited();
            }            
        }
    }
    
    // Returns the index of the array where the node should be placed / can be found
    private int getIndex(TKey key) {
        return (Math.abs(key.hashCode()) % array.length);
    }

    // toString-function which returns a string containing data from all the linked lists in the array
    @Override
    public String toString() {
        String s = "Index\tNode\tEdges\n";
        int index = 0;

        for (Node n : array) {
            Node temp = n;
            while (temp != null) {
                s += index + "\t" + temp.toString() + "   ->\t" + temp.getEdges(temp.getKey()) + "\n";
                temp = temp.getNextNode();
            }
            index++;
        }
        return s;
    }
}
