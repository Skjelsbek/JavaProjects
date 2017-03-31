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
            fromNode.insertEdge(from, toNode, weight);
            toNode.insertEdge(to, fromNode, weight);
        }
    }

    // Deletes the passed node, and also removes all the edges linked to it
    public void deleteNode(TKey key) {
        int arrayIndex = getIndex(key);
        if (array[arrayIndex] != null) {
            if (array[arrayIndex].key == key) {
                if (array[arrayIndex].edges != null) {
                    array[arrayIndex].edges.deleteEdges(array[arrayIndex]);
                }
                array[arrayIndex] = array[arrayIndex].nextNode;
                return;
            } else if (array[arrayIndex].nextNode != null) {
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
        Edge current = n.edges;
        while (current != null) {
            i = 0;
            while (queue.get(i) != null && current.compareTo(queue.get(i)) > 0) {
                i++;
            }
            queue.add(i, current);
            current = current.nextEdge;
        }

        //ADDING NODE
        mst.insertNode(n.key, n.data);
        mst.insertNode(queue.get(0).getRefrence().key, queue.get(0).getRefrence().data);
        mst.insertEdge(n.key, queue.get(0).getRefrence().key, queue.get(0).getWeight());
        n.setVisited();
        n = queue.get(0).getRefrence();
        queue.remove(0);

        while (!queue.isEmpty()) {
            // CREATING QUEUE
            current = n.edges;
            while (current != null) {
                i = 0;
                while (queue.get(i) != null && current.compareTo(queue.get(i)) > 0) {
                    i++;
                }
                queue.add(i, current);
                current = current.nextEdge;
            }

            //ADDING NODE
            mst.insertNode(n.key, n.data);
            mst.insertNode(queue.get(0).getRefrence().key, queue.get(0).getRefrence().data);
            mst.insertEdge(n.key, queue.get(0).getRefrence().key, queue.get(0).getWeight());
            n.setVisited();
            n = queue.get(0).getRefrence();
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
                s += index + "\t" + temp.toString() + "   ->\t" + temp.getEdges(temp.key).toString() + "\n";
                temp = temp.nextNode;
            }
            index++;
        }
        return s;
    }
}
