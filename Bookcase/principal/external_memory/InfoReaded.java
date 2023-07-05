package externalMemory;

class InfoReaded<E> {
    private E info;
    private int rightSon;
    private boolean isLeaf;

    public InfoReaded(E info, int rightSon, boolean isLeaf) {
        this.info = info;
        this.rightSon = rightSon;
        this.isLeaf = isLeaf;
    }

    public E getInfo() {
        return info;
    }

    public int getRightSon() {
        return rightSon;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

}
