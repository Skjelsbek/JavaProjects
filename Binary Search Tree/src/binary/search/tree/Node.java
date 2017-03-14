package binary.search.tree;

public class Node<Item extends Comparable> {
    final Item data;    // Lager en final Item-variabel. Den er final fordi den aldri skal bytte verdi
    Node<Item> leftChild, rightChild; // Lager en Node-variabel for både left og rightChild. Denne er ikke final fordi den skal kunne endres.
    
    // Konstruktør som setter instans-variabelen data lik dataen som blir sendt inn i parameteret
    public Node(Item data) {
        this.data = data;        
    }
    
    // Denne insert-metoden blir kalt fra BinarySearchTree sin insert-metode hvis root ikke er tom
    public void insert(Item data) {
        /* Hvis noden som metoden kalles fra ikke har leftChild og data < this.data opprettes en Node i leftChild.
           Hvis noden som metoden kalles fra har en leftChild og data < this.data kalles leftChild sin insert-metode.
           Og samme med høyre side. */
        if (this.data.compareTo(data) > 0 && leftChild == null) {
            leftChild = new Node(data);
        } else if (this.data.compareTo(data) > 0) {
            leftChild.insert(data);
        } else if (this.data.compareTo(data) <= 0 && rightChild == null) {
            rightChild = new Node(data);
        } else {
            rightChild.insert(data);
        }
    }
    
    // Dette er delete-metoden som blir kalt fra BinarySearchTree sin delete-metode hvis root ikke er tom
    public Node delete(Item data){                
        if (this.data.compareTo(data) == 0) {
            /* hvis den du skal slette ikke har barn, kan den bare slettes fordi det er ingenting som skal erstattes.
             return null betyr at parenten som venter på nytt barn peker på null istedet. */
            if (this.rightChild == null && this.leftChild == null) {                
                return null;               
            } 
            /* Hvis den som skal slettes har høyre barn, og det høyre barnet ikke har venstre barn,
               skal høyre barnet få dens venstre barn og høyre barnet returneres til parenten.*/
            else if (this.rightChild != null && this.rightChild.leftChild == null) {
                this.rightChild.leftChild = this.leftChild;
                return this.rightChild;
            } 
            /* Hvis den ikke har høyre barn sendes venstre barn til parenten. */
            else if (this.rightChild == null) {
                return this.leftChild;
            } 
            /* Hvis den som skal slettes har høyre barn og det høyre barnet har et venstrebarn:
               1. Finner barnet lengst til venstre for høyre barnet og lagrer det som tmp.
               2. tmp arver barna til den som skal slettes.
               3. Returneres tmp til den som skal slettes' forelder.*/
            else {
                Node tmp = this.rightChild.headLeft(this);
                tmp.leftChild = this.leftChild;
                tmp.rightChild = this.rightChild;
                return tmp;
            }
            
        } 
        
        /* Hvis this.data ikke er lik data skal det navigeres lenger ned i systemet.*/
        else if (this.data.compareTo(data) < 0 && this.rightChild != null) {
            rightChild = this.rightChild.delete(data);
        }         
        else if (this.data.compareTo(data) > 0 && this.leftChild != null){
            leftChild = this.leftChild.delete(data);
        }         
        else {
            System.out.println(data.toString() + " finnes ikke i treet");
        }
               
        return this; // Hvis this ikke skal slettes returneres den tilbake til parenten.
    }
    
    // Denne metoden navigere så langt ned mot venstre som mulig
    private Node headLeft(Node<Item> parent) {
        // Når den har kommet så langt til venstre som mulig blir nodens høyre barn til forelderens venstre barn.
        if(this.leftChild == null) {
            parent.leftChild =  this.rightChild;
            return this;
        }
        return this.leftChild.headLeft(this);
    }
    
    // Resten har du laga selv Joakim! :)
    public void prefix() {
        System.out.print(this + " ");
        if (leftChild != null) {
            leftChild.prefix();
        }
        if (rightChild != null) {
            rightChild.prefix();
        }
    }

    public void postfix() {
        if (leftChild != null) {
            leftChild.postfix();
        }
        if (rightChild != null) {
            rightChild.postfix();
        }
        System.out.print(this + " ");
    }

    public void infix() {
        if (leftChild != null) {
            leftChild.infix();
        }
        System.out.print(this + " ");
        if (rightChild != null) {
            rightChild.infix();
        }
    }

    @Override
    public String toString() {
        return data.toString();
    }
}