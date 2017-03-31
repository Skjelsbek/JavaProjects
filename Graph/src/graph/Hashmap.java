package graph;

import java.util.ArrayList;

public class Hashmap<TKey extends Comparable<TKey>, TValue> {

    private Node<TKey, TValue>[] array; // Array to store linkedlist of nodes

    // Constructor which decides the size of the array
    public Hashmap(int size) {
        array = new Node[size];
    }

    // Inserts a node in the hash map
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

    // Get-function returning the whole node
    private Node<TKey, TValue> getNode(TKey key) {
        int arrayIndex = getIndex(key);
        if (array[arrayIndex] != null) {
            return array[arrayIndex].getNode(key);
        }
        return null;
    }

    public Hashmap<TKey, TValue> prim(TKey key) {
        Hashmap<TKey, TValue> mst = new Hashmap(this.array.length);
        ArrayList<Edge<TKey, TValue>> queue = new ArrayList();
        Node<TKey, TValue> n = getNode(key);

        // CREATING QUEUE
        int i;
        Edge current = n.getEdges();
        while (current != null) {
            i = 0;
            while (queue.get(i) != null && current.compareTo(queue.get(i)) > 0) {
                i++;
            }
            queue.add(i, current);
            current = current.getNextEdge();
        }

        //ADDING NODE
        mst.insertNode(queue.get(0).getFrom().getKey(), queue.get(0).getFrom().getValue());
        mst.insertNode(queue.get(0).getTo().getKey(), queue.get(0).getTo().getValue());
        mst.insertEdge(queue.get(0).getFrom().getKey(), queue.get(0).getTo().getKey(), queue.get(0).getWeight());
        n.setVisited();
        n = queue.get(0).getTo();
        queue.remove(0);

        while (!queue.isEmpty()) {
            // CREATING QUEUE
            current = n.getEdges();
            while (current != null) {
                i = 0;
                while (queue.get(i) != null && current.compareTo(queue.get(i)) > 0) {
                    i++;
                }
                queue.add(i, current);
                current = current.getNextEdge();
            }

            //ADDING NODE
            mst.insertNode(queue.get(0).getFrom().getKey(), queue.get(0).getFrom().getValue());
            mst.insertNode(queue.get(0).getTo().getKey(), queue.get(0).getTo().getValue());
            mst.insertEdge(queue.get(0).getFrom().getKey(), queue.get(0).getTo().getKey(), queue.get(0).getWeight());
            n.setVisited();
            n = queue.get(0).getTo();
            queue.remove(0);
        }
        return mst;
    }

    // Returns the index of the array where the node should be placed
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
                s += index + "\t" + temp.toString() + "   ->\t" + temp.getEdges(temp.getKey()).toString() + "\n";
                temp = temp.getNextNode();
            }
            index++;
        }
        return s;
    }
}
