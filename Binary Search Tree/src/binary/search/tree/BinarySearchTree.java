package binary.search.tree;

public class BinarySearchTree<Item extends Comparable> {

    Node<Item> root, current;
    
    // Dette er den insert-metoden som blir kalt kalt i main
    public void insert(Item data) {
        /* Hvis root er tom blir det opprettet ett nytt objekt i root med verdi en som blir sendt med i parameteret,
           men hvis det er noe i root kjøres root sin insert-metode. */ 
        if (root == null) {
            root = new Node(data);
        } else {
            root.insert(data);
        }
    }
    
    // Søke algoritme for å sjekke om et element finnes i treet
    public void search(Item data) {
        // Hvis root er tom skrives det ut en beskjed og det blir returnert null
        if (root == null) {
            System.out.println("The tree is empty");
            return;
        }
        
        current = root; // Setter current = root for å ikke gjøre endringer på root
        
        // Looper helt til return
        while (true) {
            // Hvis current.data = data skrives det ut en beskjed om at data finnes i treet, og returnerer
            if (current.data.compareTo(data) == 0){
                System.out.println(data + " finnes i treet");
                return;
            }
            
            /* Endrer current til current sin left eller rightChild i forhold til om data er større eller mindre enn current,
               dette er for å navigere nedover i treet på riktig side. Hvis begge current sine barn = null skrives det ut en
               beskjed om at data ikke er å finne i treet. */                
            if (current.data.compareTo(data) > 0 && current.leftChild != null) {
                current = current.leftChild;
            } else if (current.data.compareTo(data) < 0 && current.rightChild != null) {
                current = current.rightChild;
            } else {
                System.out.println(data.toString() + " finnes ikke i treet");
                return;
            }
        }        
    }
    
    // Dette er delete-metoden som blir kalt fra main
    public void delete(Item data) {
        /* Hvis root er tom blir det skrevet ut en beskjed om at treet er tomt,
           ellers kalles root sin delete-metode. */
        if (root == null) {
            System.out.println("The tree is empty");            
        } else {
            root = root.delete(data);
        }
    }
    
    // Preorder traverseringsmetode som kalles fra main
    public void prefix() {
        /* Hvis root er tom skrives det ut en beskjed om at treet er tomt,
           ellers kalles root sin preorder traverseringsmetode. */
        if (root == null) {
            System.out.println("The tree is empty");
        } else {
            root.prefix();
            System.out.println("");
        }
    }
    
    // Postorder traverseringsmetode som kalles fra main
    public void postfix() {
        /* Hvis root er tom skrives det ut en beskjed om at treet er tomt,
           ellers kalles root sin postorder traverseringsmetode. */
        if (root == null) {
            System.out.println("The tree is empty");
        } else {
            root.postfix();
            System.out.println("");
        }
    }
    
    // Inorder traverseringsmetode som kalles fra main
    public void infix() {
        /* Hvis root er tom skrives det ut en beskjed om at treet er tomt,
           ellers kalles root sin inorder traverseringsmetode. */
        if (root == null) {
            System.out.println("The tree is empty");
        } else {
            root.infix();
            System.out.println("");
        }
    }
}
