package two.three.tree;

public class Node<T extends Comparable<T>> {

    T xKey, yKey, zKey, tmpKey;
    Node<T> farLeftChild, leftChild, farRightChild, rightChild, tmpNode;

    public Node(T data) {
        this.yKey = data;
    }

    public Node<T> insert(T data) {
        if (yKey != null && xKey == null && zKey == null) {
            if (farLeftChild != null && data.compareTo(yKey) < 0) {
                tmpNode = farLeftChild.insert(data);
                if (tmpNode != farLeftChild) {
                    xKey = tmpNode.yKey;
                    this.farLeftChild = tmpNode.farLeftChild;
                    this.leftChild = tmpNode.farRightChild;
                }

            } else if (farRightChild != null && data.compareTo(yKey) >= 0) {
                tmpNode = farRightChild.insert(data);
                if (tmpNode != farRightChild) {
                    zKey = tmpNode.yKey;
                    farRightChild = tmpNode.farRightChild;
                    rightChild = tmpNode.farLeftChild;
                }

            } else if (data.compareTo(yKey) < 0) {
                xKey = data;
            } else {
                zKey = data;
            }
        } else if (yKey != null && xKey != null && zKey == null) {
            if (farLeftChild != null && data.compareTo(xKey) < 0) {
                tmpNode = farLeftChild.insert(data);
                if (tmpNode != farLeftChild) {
                    zKey = yKey;
                    yKey = xKey;
                    xKey = tmpNode.yKey;

                    this.farLeftChild = tmpNode.farLeftChild;
                    if (this.leftChild != null) {
                        if (this.rightChild != null) {
                            this.farRightChild = this.rightChild;
                        }
                        this.rightChild = this.leftChild;
                    }
                    this.leftChild = tmpNode.farRightChild;
                }

            } else if (leftChild != null && data.compareTo(xKey) >= 0 && data.compareTo(yKey) < 0) {

                tmpNode = leftChild.insert(data);
                if (tmpNode != leftChild) {
                    zKey = yKey;
                    yKey = tmpNode.yKey;

                    this.leftChild = tmpNode.farLeftChild;
                    if (this.rightChild != null) {
                        this.farRightChild = this.rightChild;
                    }
                    this.rightChild = tmpNode.farRightChild;
                }

            } else if (farRightChild != null && data.compareTo(yKey) >= 0) {
                tmpNode = farRightChild.insert(data);
                if (tmpNode != farRightChild) {
                    zKey = tmpNode.yKey;

                    this.farRightChild = tmpNode.farRightChild;
                    if (this.rightChild != null) {
                        if (this.leftChild != null) {
                            this.farLeftChild = this.leftChild;
                        }
                        this.leftChild = this.rightChild;
                    }
                    this.rightChild = tmpNode.farLeftChild;
                }

            } else if (data.compareTo(yKey) < 0) {
                if (data.compareTo(xKey) >= 0) {
                    zKey = yKey;
                    yKey = data;
                } else {
                    zKey = yKey;
                    yKey = xKey;
                    xKey = data;
                }
            } else {
                zKey = data;
            }
        } else if (yKey != null && xKey == null && zKey != null) {
            if (farLeftChild != null && data.compareTo(yKey) < 0) {
                tmpNode = farLeftChild.insert(data);
                if (tmpNode != farLeftChild) {
                    xKey = tmpNode.yKey;

                    this.farLeftChild = tmpNode.farLeftChild;
                    if (this.leftChild != null) {
                        if (this.rightChild != null) {
                            this.farRightChild = this.rightChild;
                        }
                        this.rightChild = this.leftChild;
                    }
                    this.leftChild = tmpNode.farRightChild;
                }
            } else if (leftChild != null && data.compareTo(yKey) >= 0 && data.compareTo(zKey) < 0) {
                tmpNode = leftChild.insert(data);
                if (tmpNode != leftChild) {
                    xKey = yKey;
                    yKey = tmpNode.yKey;
                    this.leftChild = tmpNode.farLeftChild;
                    if (this.rightChild != null) {
                        this.farRightChild = this.rightChild;
                    }
                    this.rightChild = tmpNode.farRightChild;
                }
            } else if (rightChild != null && data.compareTo(yKey) >= 0 && data.compareTo(zKey) < 0) {
                tmpNode = rightChild.insert(data);
                if (tmpNode != rightChild) {
                    xKey = yKey;
                    yKey = tmpNode.yKey;
                    this.rightChild = tmpNode.farRightChild;
                    if (this.leftChild != null) {
                        this.farLeftChild = this.leftChild;
                    }
                    this.leftChild = tmpNode.farLeftChild;
                }
            } else if (farRightChild != null && data.compareTo(zKey) >= 0) {
                tmpNode = farRightChild.insert(data);
                if (tmpNode != farRightChild) {
                    xKey = yKey;
                    yKey = zKey;
                    zKey = tmpNode.yKey;
                    this.farRightChild = tmpNode.farRightChild;
                    if (this.rightChild != null) {
                        if (this.leftChild != null) {
                            this.farLeftChild = this.leftChild;
                        }
                        this.leftChild = this.rightChild;
                    }
                    this.rightChild = tmpNode.farLeftChild;
                }
            } else if (data.compareTo(yKey) < 0) {
                xKey = data;
            } else if (data.compareTo(zKey) >= 0) {
                xKey = yKey;
                yKey = zKey;
                zKey = data;
            } else {
                xKey = yKey;
                yKey = data;
            }
        }

        if (yKey != null && xKey != null && zKey != null) {
            Integer testInt = new Integer(5);
            if (data.compareTo((T) testInt) == 0) {
                System.out.println("Den kommer inn her");
            }
            tmpNode = new Node(yKey);
            tmpNode.farLeftChild = new Node(xKey);
            tmpNode.farRightChild = new Node(zKey);
            tmpNode.farLeftChild.farLeftChild = this.farLeftChild;
            tmpNode.farLeftChild.farRightChild = this.leftChild;
            tmpNode.farRightChild.farLeftChild = this.rightChild;
            tmpNode.farRightChild.farRightChild = this.farRightChild;
            return tmpNode;
        }
        return this;
    }

    public void infix() {
        if (farLeftChild != null) {
            farLeftChild.infix();
        }
        if (xKey != null) {
            System.out.println(xKey);
        }
        if (leftChild != null) {
            leftChild.infix();
        }
        System.out.println(yKey);
        if (rightChild != null) {
            rightChild.infix();
        }
        if (zKey != null) {
            System.out.println(zKey);
        }
        if (farRightChild != null) {
            farRightChild.infix();
        }
    }

    public boolean search(T data) {
        if (yKey == data) {
            return true;
        } else if (xKey == data) {
            return true;
        } else if (zKey == data) {
            return true;
        } else if (xKey != null && data.compareTo(xKey) < 0 && farLeftChild != null) {
            return farLeftChild.search(data);
        } else if (yKey != null && data.compareTo(yKey) < 0 && leftChild != null) {
            return leftChild.search(data);
        } else if (zKey != null && data.compareTo(zKey) < 0 && rightChild != null) {
            return rightChild.search(data);
        } else if (farRightChild != null) {
            return farRightChild.search(data);
        }
        return false;
    }
}
